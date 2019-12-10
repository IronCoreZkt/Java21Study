package com.chapter20;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;

public class DmozHandlerImpl implements DmozHandler {
	@Override
	public HashMap<String, String> getRandomSite() {
		Connection conn = getMysqlConnection();
		HashMap<String, String> response = new HashMap<String, String>();
		
		try {
			Statement st = conn.createStatement();
			//此sql效率极低，order by rand()会多次执行
			ResultSet rs = st.executeQuery("SELECT * FROM cooldata ORDER BY RAND() LIMIT 1");
			if(rs.next()){
				response.put("url", rs.getString("url"));
				response.put("title", rs.getString("title"));
				response.put("description", rs.getString("description"));
			}else{
				response.put("error", "no database record found");
			}
			rs.close();
			st.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return response;
	}

	private Connection getMysqlConnection() {
		Connection conn = null;
		String JDBC_DRIVER = "com.mysql.jdbc.Driver";
		String DB_URL = "jdbc:mysql://localhost:3306/test";
		try {
			Class.forName(JDBC_DRIVER);
			conn = DriverManager.getConnection(DB_URL, "root", "123456");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return conn;
	}
}
