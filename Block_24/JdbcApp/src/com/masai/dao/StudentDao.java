package com.masai.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.masai.dto.Student;

public class StudentDao {
	
	public static void addStudent(Student st) {
		
		Connection con = DBUtil.provideConnection();
		
		try {
			PreparedStatement ps = con.prepareStatement("insert into student values (?, ?, ?, ?)");
			
			ps.setString(1, st.getRoll());
			ps.setString(2, st.getName());
			ps.setDouble(3, st.getCgpa());
			ps.setDate(4, Date.valueOf(st.getDob()));
			
			int x = ps.executeUpdate();
			if(x > 0) {
				System.out.println("Student data saved successfully");
			}
			else {
				System.out.println("Something went wrong");
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		DBUtil.closeConn(con);
		
	}

}
