package com.masai.ui;

import java.util.Scanner;

import com.masai.dao.CarDAO;
import com.masai.dao.CarDAOImpl;
import com.masai.dto.CarDTO;
import com.masai.dto.CarDTOImpl;
import com.masai.dto.CompanyDTOImpl;

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
		
		car_dao.addCar(car);

	}
	
	public static void viewAllCars() {		
		CarDAO car_dao = new CarDAOImpl();		
		car_dao.viewAllCars();
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
		
		car_dao.updateCar(car);
	}
	
	
	public static void deleteCar(Scanner sc) {
		System.out.print("Enter Car_Id of the car you want to delete:  ");
		String car_id = sc.next();		
		
		CarDAO car_dao = new CarDAOImpl();
		
		car_dao.deleteCar(car_id);
	}
	
	
	public static void numberOfCarsByCompany() {
		CarDAO car_dao = new CarDAOImpl();
		
		car_dao.numberOfCarsByCompany();
		System.out.println();
	}

}
