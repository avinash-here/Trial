package com.masai.ui;

import java.time.LocalDate;
import java.util.Scanner;

import com.masai.dao.StudentDao;
import com.masai.dto.Student;

public class Main {
	
	public static void addStudentData(Scanner sc) {
//		Scanner sc1 = new Scanner(System.in);
		
		System.out.print("Enter your roll  ");
		String roll = sc.next();
		System.out.print("Enter your name  ");
		String name = sc.next();
		System.out.print("Enter your cgpa  ");
		double cgpa = sc.nextDouble();
		System.out.print("Enter your dob (YYYY-MM-DD)  ");
		LocalDate date = LocalDate.parse(sc.next());
		
		Student st = new Student(roll, name, cgpa, date);
		
		StudentDao.addStudent(st);
		
//		sc1.close();
	}
	
	
	public static void main(String[] args) {
		
		int selection = 0;
		Scanner sc = new Scanner(System.in);
		do {
			
			System.out.println("Enter a selection");
			System.out.println("1. Add student data \n2. Update student data \n3. Delete student data \n4. View student data \n0. Exit");
			selection = sc.nextInt();
			
			if(selection == 1) {
				addStudentData(sc);
			}
			else if(selection == 2) {
				
			}
			else if(selection == 3) {
				
			}
			else if(selection == 4) {
	
			}
			else if(selection == 0) {
	
			}
			else {
				System.out.println("Invalid Selection");
			}
		}
		while(selection != 0);
		
	}

}
