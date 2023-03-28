package com.masai.ui;

import java.util.List;
import java.util.Map;
import java.util.Scanner;

import com.masai.dao.CarDAO;
import com.masai.dao.CarDAOImpl;
import com.masai.dto.CarDTO;
import com.masai.dto.CarDTOImpl;
import com.masai.dto.CompanyDTOImpl;
import com.masai.exceptions.NoRecordFoundException;
import com.masai.exceptions.SomethingWentWrongException;

public class CarUI {
	
	public static void addCar(Scanner sc) {
		System.out.println("Print enter the following details:");
		System.out.print("Car_Id:      ");
		String car_id = sc.next();
		System.out.print("Model Name:  ");
		String model = sc.next();
		System.out.print("Price:       ");
		int price = sc.nextInt();
		System.out.print("Total Seats: ");
		int seats = sc.nextInt();
		System.out.print("Company Id:  ");
		String companyId = sc.next();
		
		CarDTO car = new CarDTOImpl(car_id, model, price, seats, new CompanyDTOImpl(companyId, null, null, null));
		
		CarDAO car_dao = new CarDAOImpl();
		
		try {
			car_dao.addCar(car);
			System.out.println("Car added successfully.");
		} 
		catch (SomethingWentWrongException e) {
			System.out.println(e.getMessage());
		}

	}
	
	public static void viewAllCars() {		
		CarDAO car_dao = new CarDAOImpl();		
		try {
			List<CarDTO> cars = car_dao.viewAllCars();
			for(CarDTO car : cars) {
				System.out.println("Car Id: "+car.getCar_Id()+"   Model Name: "+car.getModel_name()+"   Price: "+car.getPrice()+
									"   Total Seats: "+car.getSeats()+"   Company Name: "+car.getCom_dto().getCompany_name()+
									"   Company Turnover: "+car.getCom_dto().getTurnover()+" Crores");
			}
		} 
		catch (SomethingWentWrongException | NoRecordFoundException e) {
			System.out.println(e.getMessage());
		}
	}
	
	public static void updateCar(Scanner sc) {
		System.out.print("Enter Car_Id:      ");
		String car_id = sc.next();
		System.out.print("Enter Model Name:  ");
		String model = sc.next();
		System.out.print("Enter Price:       ");
		int price = sc.nextInt();
		System.out.print("Enter Total Seats: ");
		int seats = sc.nextInt();
		System.out.print("Enter Company Id:  ");
		String companyId = sc.next();
		
		CarDTO car = new CarDTOImpl(car_id, model, price, seats, new CompanyDTOImpl(companyId, null, null, null));
		
		CarDAO car_dao = new CarDAOImpl();
		
		try {
			car_dao.updateCar(car);
			System.out.println("Car updated successfully.");
		} 
		catch (SomethingWentWrongException e) {
			System.out.println(e.getMessage());
		}
	}
	
	
	public static void deleteCar(Scanner sc) {
		System.out.print("Enter Car_Id of the car you want to delete:  ");
		String car_id = sc.next();		
		
		CarDAO car_dao = new CarDAOImpl();
		
		try {
			car_dao.deleteCar(car_id);
			System.out.println("Car deleted successfully.");
		} 
		catch (SomethingWentWrongException e) {
			System.out.println(e.getMessage());
		}
	}
	
	
	public static void numberOfCarsByCompany() {
		CarDAO car_dao = new CarDAOImpl();
		
		try {
			Map<String, Integer> map = car_dao.numberOfCarsByCompany();
			System.out.println("Company Name    Total Models");
			
			for(String key : map.keySet()) {				
				System.out.print(String.format("%-16s", key));
				System.out.println(map.get(key));
			}
		} 
		catch (SomethingWentWrongException | NoRecordFoundException e) {
			System.out.println(e.getMessage());
		}
	}

}
