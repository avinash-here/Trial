package com.masai.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.masai.dto.CarDTO;
import com.masai.dto.CarDTOImpl;
import com.masai.dto.CompanyDTOImpl;
import com.masai.exceptions.NoRecordFoundException;
import com.masai.exceptions.SomethingWentWrongException;

public class CarDAOImpl implements CarDAO{

	@Override
	public void addCar(CarDTO car_dto) throws SomethingWentWrongException {

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
			
		} catch (SQLException e) {
			throw new SomethingWentWrongException("Something went wrong. Please try again.");
		} finally {
			DBUtils.closeConnection(conn);
		}		
		
	}
	
	@Override
	public List<CarDTO> viewAllCars() throws SomethingWentWrongException, NoRecordFoundException {

		Connection conn = null;
		List<CarDTO> list = new ArrayList<>();
		
		try {
			conn = DBUtils.acquireConnection();
			String query = "select car_id, model_name, price, total_seats, company_name, turnover_in_crores "
					+ "FROM car cr JOIN company cm ON cr.company_id = cm.company_id";
			
			PreparedStatement ps = conn.prepareStatement(query);	
			ResultSet rs = ps.executeQuery();
			
			if(DBUtils.isResultSetEmpty(rs)) {
				throw new NoRecordFoundException("No records found in the CAR table.");
			}

			while(rs.next()) {	
				list.add(new CarDTOImpl(rs.getString(1), rs.getString(2), rs.getInt(3), rs.getInt(4), 
										new CompanyDTOImpl(null, rs.getString(5), rs.getLong(6), null)));								
			}
			
		} catch (SQLException e) {
			throw new SomethingWentWrongException("Something went wrong. Please try again.");
		} finally {
			DBUtils.closeConnection(conn);
		}		
		
		return list;
	}
	
	
	@Override
	public void updateCar(CarDTO car_dto) throws SomethingWentWrongException {

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
						
		} catch (SQLException e) {
			throw new SomethingWentWrongException("Something went wrong. Please try again.");
		} finally {
			DBUtils.closeConnection(conn);
		}		
		
	}
	
	
	@Override
	public void deleteCar(String car_id) throws SomethingWentWrongException {

		Connection conn = null;		
		try {
			conn = DBUtils.acquireConnection();
			
			String query = "delete from car where car_id=?";
			PreparedStatement ps = conn.prepareStatement(query);			
			ps.setString(1, car_id);			
			
			ps.executeUpdate();
						
		} catch (SQLException e) {
			throw new SomethingWentWrongException("Something went wrong. Please try again.");
		} finally {
			DBUtils.closeConnection(conn);
		}		
		
	}
	
	
	@Override
	public Map<String, Integer> numberOfCarsByCompany() throws SomethingWentWrongException, NoRecordFoundException {

		Connection conn = null;
		Map<String, Integer> map = new HashMap<>();
		try {
			conn = DBUtils.acquireConnection();
			String query = "select company_name, count(car_id) FROM company cm LEFT JOIN car cr "
						 + "ON cr.company_id = cm.company_id GROUP BY company_name";
			
			PreparedStatement ps = conn.prepareStatement(query);	
			ResultSet rs = ps.executeQuery();
			
			if(DBUtils.isResultSetEmpty(rs)) {
				throw new NoRecordFoundException("No records found in the CAR table.");
			}
			
			while(rs.next()) {
				map.put(rs.getNString(1), rs.getInt(2));
			}
						
		} catch (SQLException e) {
			throw new SomethingWentWrongException("Something went wrong. Please try again.");
		} finally {
			DBUtils.closeConnection(conn);
		}	
		
		return map;
	}

}