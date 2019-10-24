package com.chapter18;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * 本类测试JDBC批量操作的功能。
 * 
 * @author Iron Core
 * @date 2019年10月24日
 * @note 这里使用了Statement，PreparedStatement也是差不多的形式，
 *
 */
public class BatchJdbcOperator {
	// 数据库驱动名和数据库URL
	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	static final String DB_URL = "jdbc:mysql://localhost:3306/test";
	// 数据库用户密码
	static final String USERNAME = "root";
	static final String PASSWORD = "123456";

	public static void main(String[] args) {
		Connection conn = null;
		Statement stmt = null;
		try {
			Class.forName(JDBC_DRIVER);
			conn = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
			String sql0 = "truncate table batchtest";// DDL自动提交
			String sql1 = "insert into batchtest values(1,001)";
			String sql2 = "insert into batchtest values(2,002)";
			stmt = conn.createStatement();
			conn.setAutoCommit(false);// 设置事务，关闭自动提交
			stmt.addBatch(sql0);
			stmt.addBatch(sql1);
			stmt.addBatch(sql2);
			int[] count = stmt.executeBatch();
			conn.commit();// 事务在操作量大时效率提升明显，在这里有和没有差不多
			for (int a : count) {
				System.out.print(a + " ");
			}
			stmt.close();
			conn.close();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
			try {
				if (conn != null)
					conn.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		} finally {
			try {
				if (stmt != null)
					stmt.close();
				if (conn != null)
					conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
