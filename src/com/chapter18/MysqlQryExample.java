package com.chapter18;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class MysqlQryExample {
	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	static final String DB_URL = "jdbc:mysql://localhost:3306/test";
	
	static final String USERNAME = "root";
	static final String PASSWORD = "123456";
	
	public static void main(String[] args){
		Connection conn = null;
		Statement st = null;
		try {
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
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
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
