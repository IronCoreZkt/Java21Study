package com.chapter18;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * 本类用于测试MySQL的JDBC驱动，执行最简单的查询。
 * 
 * @author Iron Core
 * @date 2019年10月17日
 * @note 这里用的语句是statement，是三种语句中最简单的。
 * 		  注册驱动-驱动管理器创建连接-连接创建语句-语句执行生成结果集-结果集遍历
 */
public class MysqlQryExample {
	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	static final String DB_URL = "jdbc:mysql://localhost:3306/test";
	
	static final String USERNAME = "root";
	static final String PASSWORD = "123456";
	
	public static void main(String[] args){
		Connection conn = null;
		Statement st = null;
		try {
			//注册JDBC驱动程序，另一种不推荐的方法是DriverManager.registerDriver(new 驱动())
			Class.forName(JDBC_DRIVER);
			conn = DriverManager.getConnection(DB_URL,USERNAME,PASSWORD);
			st = conn.createStatement();
			String sql = "SELECT * FROM EMPLOYEES";
			ResultSet rs = st.executeQuery(sql);
			while (rs.next()) {
				System.out.println("ID:\t\t" + rs.getInt("id"));
				System.out.println("FIRSTNAME:\t" + rs.getString("first_name"));
				System.out.println("LASTNAME:\t" + rs.getString("last_name"));
				System.out.println("AGE:\t\t" + rs.getInt("age") + "\n\t\t---");
			}
			rs.close();
			st.close();
			conn.close();
		} catch (ClassNotFoundException e) {//Class.forname注册驱动时可能产生
			e.printStackTrace();
		} catch (SQLException e) {//SQL相关的操作可能产生
			e.printStackTrace();
		} finally {
			if (st != null)
				try {
					st.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			if (conn != null)
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
		}
	}
}
