package com.masai.dao;

import java.util.List;
import java.util.Map;

import com.masai.dto.CarDTO;
import com.masai.exceptions.NoRecordFoundException;
import com.masai.exceptions.SomethingWentWrongException;

public interface CarDAO {
	
	public void addCar(CarDTO car_dto) throws SomethingWentWrongException;
	
	public List<CarDTO> viewAllCars() throws SomethingWentWrongException, NoRecordFoundException;
	
	public void updateCar(CarDTO car_dto) throws SomethingWentWrongException;
	
	public void deleteCar(String car_id) throws SomethingWentWrongException;
	
	public Map<String, Integer> numberOfCarsByCompany() throws SomethingWentWrongException, NoRecordFoundException;

}
