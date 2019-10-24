package com.chapter18;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * 本类使用PreparedStatement来执行批量+事务JDBC操作。
 * 
 * @author Iron Core
 * @date 2019年10月24日
 *
 */
public class BatchJdbcOperatorByPstmt {
	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	static final String DB_URL = "jdbc:mysql://localhost:3306/test";
	static final String USERNAME = "root";
	static final String PASSWORD = "123456";

	public static void main(String[] args) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			Class.forName(JDBC_DRIVER);
			conn = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
			String SQL = " INSERT INTO BATCHTEST VALUES(?,?)";
			pstmt = conn.prepareStatement(SQL);
			conn.setAutoCommit(false);
			printRows(pstmt);
			pstmt.addBatch("truncate table batchtest");

			pstmt.setInt(1, 4);
			pstmt.setInt(2, 004);
			pstmt.addBatch();

			pstmt.setInt(1, 5);
			pstmt.setInt(2, 005);
			pstmt.addBatch();

			int[] count = pstmt.executeBatch();

			System.out.print("影响行数：");
			for (int i = 0; i < count.length; i++) {
				System.out.print(count[i]);
				if (i != count.length - 1)
					System.out.print(",");
				else
					System.out.println();
			}
			printRows(pstmt);

			conn.commit();
			pstmt.close();
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
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	public static void printRows(Statement stmt) throws SQLException {
		ResultSet rs = stmt.executeQuery("SELECT * FROM BATCHTEST");
		while (rs.next()) {
			System.out.print("id:" + rs.getInt("id"));
			System.out.println(",namecode:" + rs.getInt("namecode"));
		}
		rs.close();
	}

}
