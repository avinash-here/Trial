package com.masai.ui;

import java.util.Scanner;

public class UI_Main {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int choice = 0;
		
		do {
			System.out.println("Please choose an option");
			System.out.println("1. Add a Car");
			System.out.println("2. View all Cars");
			System.out.println("3. Update a Car");
			System.out.println("4. Delete a Car");
			System.out.println("5. Display number of models according to company");
			System.out.println("0. Exit");
			choice = sc.nextInt();
			System.out.println();
			
			switch(choice) {
			case 1 : 
				CarUI.addCar(sc);
				break;
				
			case 2 : 
				CarUI.viewAllCars();
				break;
				
			case 3 : 
				CarUI.updateCar(sc);
				break;
			
			case 4 : 
				CarUI.deleteCar(sc);
				break;
			
			case 5 : 
				CarUI.numberOfCarsByCompany();
				break;
			
			case 0 : 
				System.out.println("Thank you, visit again!");
				break;	
				
			default :
				System.out.println("Invalid input, Try Again!\n");	
			}
			
		}
		while(choice != 0);
	}

}
