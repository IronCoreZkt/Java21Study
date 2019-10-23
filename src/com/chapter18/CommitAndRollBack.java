package com.chapter18;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * 本类测试JDBC的事务功能。
 * 
 * @author Iron Core
 * @date 2019年10月23日
 * @note 使用手动提交和错误情况下回滚，关键在于关闭连接的自动提交。
 * 		  此外Connection对象有两种方法可用来管理保存点，setSavepoint和releaseSavepoint
 * 		 rollback (String savepointName)方法，它将使用事务回滚到指定的保存点，存档功能。
 *
 */
public class CommitAndRollBack {
	//数据库驱动名和数据库URL
	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	static final String DB_URL = "jdbc:mysql://localhost:3306/test";
	//数据库用户密码
	static final String USERNAME = "root";
	static final String PASSWORD = "123456";

	public static void main(String[] args) {
		Connection conn = null;
		Statement stmt = null;
		try {
			// 注册驱动
			Class.forName(JDBC_DRIVER);
			conn = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
			// 设置连接属性为不自动提交，默认为自动提交
			conn.setAutoCommit(false);
			stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
			String sql = "INSERT INTO EMPLOYEES (FIRST_NAME,LAST_NAME,AGE) VALUES('Curry', 'Stephen',28)";
			stmt.executeUpdate(sql);
			sql = "INSERT INTO EMPLOYEES (FIRST_NAME,LAST_NAME,AGE) VALUES('Kobe', 'Bryant',32)";
			stmt.executeUpdate(sql);
			// 一次性提交事务
			conn.commit();

			String qrySql = "SELECT * FROM EMPLOYEES";
			ResultSet rs = stmt.executeQuery(qrySql);
			printRslt(rs);

			rs.close();
			stmt.close();
			conn.close();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
			// 回滚修改
			try {
				if (conn != null)
					conn.rollback();
			} catch (SQLException e2) {
				e2.printStackTrace();
			}
		} finally {
			try {
				if (stmt != null) {
					stmt.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * 遍历打印结果集
	 * @param rs
	 */
	public static void printRslt(ResultSet rs) {
		try {
			while (rs.next()) {
				System.out.print("ID:" + rs.getInt("id"));
				System.out.print(",FIRSTNAME:" + rs.getString("first_name"));
				System.out.print(",LASTNAME:" + rs.getString("last_name"));
				System.out.println(",AGE:" + rs.getInt("age"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
