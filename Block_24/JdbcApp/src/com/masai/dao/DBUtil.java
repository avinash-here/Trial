package com.masai.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class DBUtil {
	
	public static Connection provideConnection() {
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		ResourceBundle rb = ResourceBundle.getBundle("database");
		
		Connection conn = null;
		try {
			conn = DriverManager.getConnection(rb.getString("url"), rb.getString("user"), rb.getString("pass"));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return conn;
	}
	
	public static void closeConn(Connection con) {
		if(con != null)
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
	}

}
