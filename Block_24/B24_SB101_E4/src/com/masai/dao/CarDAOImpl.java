package com.masai.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.masai.dto.CarDTO;

public class CarDAOImpl implements CarDAO{

	@Override
	public void addCar(CarDTO car_dto) {

		Connection conn = null;
		
		try {
			conn = DBUtils.acquireConnection();
			
			String query = "Insert into car values (?, ?, ?, ?, ?)";
			PreparedStatement ps = conn.prepareStatement(query);
			
			ps.setString(1, car_dto.getCar_Id());
			ps.setString(2, car_dto.getModel_name());
			ps.setInt(3, car_dto.getPrice());
			ps.setInt(4, car_dto.getSeats());
			ps.setString(5, car_dto.getCom_dto().getCompany_Id());
			
			ps.executeUpdate();
			
			System.out.println("Car inserted successfully. \n");
			
		} catch (SQLException e) {
			System.out.println("Something went wrong");
			System.out.println("Try Again \n");
		} finally {
			DBUtils.closeConnection(conn);
		}		
		
	}
	
	@Override
	public void viewAllCars() {

		Connection conn = null;

		try {
			conn = DBUtils.acquireConnection();
			String query = "select car_id, model_name, price, total_seats, company_name, turnover_in_crores "
					+ "FROM car cr JOIN company cm ON cr.company_id = cm.company_id";
			
			PreparedStatement ps = conn.prepareStatement(query);	
			ResultSet rs = ps.executeQuery();
			
			if(DBUtils.isResultSetEmpty(rs)) {
				System.out.println("No Cars in the CAR table");
				return;
			}

			while(rs.next()) {				
				System.out.println("Car Id: "+ rs.getString(1) +"  Model Name: "+ rs.getString(2) +"  Price: "+ rs.getInt(3) + 
				"  Total Seats: "+ rs.getInt(4) +"  Company Name: "+ rs.getString(5) +"  Company Turnover: " + rs.getInt(6) +" Crores");				
			}
			
		} catch (SQLException e) {
			System.out.println("Something went wrong");
			System.out.println("Try Again \n");
		} finally {
			DBUtils.closeConnection(conn);
		}		
		
	}
	
	
	@Override
	public void updateCar(CarDTO car_dto) {

		Connection conn = null;
		
		try {
			conn = DBUtils.acquireConnection();
			
			String query = "update car set model_name=?, price=?, total_seats=?, company_id=? where car_id=?";
			PreparedStatement ps = conn.prepareStatement(query);
			
			ps.setString(1, car_dto.getModel_name());
			ps.setInt(2, car_dto.getPrice());
			ps.setInt(3, car_dto.getSeats());
			ps.setString(4, car_dto.getCom_dto().getCompany_Id());
			ps.setString(5, car_dto.getCar_Id());
			
			ps.executeUpdate();
			
			System.out.println("Car updated successfully. \n");
			
		} catch (SQLException e) {
			System.out.println("Something went wrong");
			System.out.println("Try Again \n");
		} finally {
			DBUtils.closeConnection(conn);
		}		
		
	}
	
	
	@Override
	public void deleteCar(String car_id) {

		Connection conn = null;		
		try {
			conn = DBUtils.acquireConnection();
			
			String query = "delete from car where car_id=?";
			PreparedStatement ps = conn.prepareStatement(query);			
			ps.setString(1, car_id);			
			
			ps.executeUpdate();
			
			System.out.println("Car deleted successfully. \n");
			
		} catch (SQLException e) {
			System.out.println("Something went wrong");
			System.out.println("Try Again \n");
		} finally {
			DBUtils.closeConnection(conn);
		}		
		
	}
	
	
	@Override
	public void numberOfCarsByCompany() {

		Connection conn = null;
		try {
			conn = DBUtils.acquireConnection();
			String query = "select company_name, count(car_id) FROM company cm LEFT JOIN car cr "
						 + "ON cr.company_id = cm.company_id GROUP BY company_name";
			
			PreparedStatement ps = conn.prepareStatement(query);	
			ResultSet rs = ps.executeQuery();
			
			System.out.println("Company Name    Total Models");
			
			while(rs.next()) {				
				System.out.print(String.format("%-16s", rs.getString(1)));
				System.out.println(rs.getInt(2));
			}
			
		} catch (SQLException e) {
			System.out.println("Something went wrong");
			System.out.println("Try Again \n");
		} finally {
			DBUtils.closeConnection(conn);
		}		
		
	}

}