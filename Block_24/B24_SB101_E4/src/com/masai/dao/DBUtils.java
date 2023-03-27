package com.masai.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class DBUtils {
	
	public static Connection acquireConnection() throws SQLException {
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		ResourceBundle rb = ResourceBundle.getBundle("dbdetails");
				
		return DriverManager.getConnection(rb.getString("url"), rb.getString("usrnm"), rb.getString("pswd"));
				
	}
	
	public static void closeConnection(Connection conn) {
		if(conn != null) {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	public static boolean isResultSetEmpty(ResultSet rs) {
		try {
			if(!rs.isBeforeFirst() && rs.getRow() == 0) {
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;		
	}

}
