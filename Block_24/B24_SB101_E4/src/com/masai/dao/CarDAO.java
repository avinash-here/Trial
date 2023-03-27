package com.masai.dao;

import com.masai.dto.CarDTO;

public interface CarDAO {
	
	public void addCar(CarDTO car_dto);
	
	public void viewAllCars();
	
	public void updateCar(CarDTO car_dto);
	
	public void deleteCar(String car_id);
	
	public void numberOfCarsByCompany();

}
