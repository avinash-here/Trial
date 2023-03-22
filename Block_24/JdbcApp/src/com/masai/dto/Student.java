package com.masai.dto;

import java.time.LocalDate;

public class Student {
	private String roll;
	private String name;
	private double cgpa;
	private LocalDate dob;
	
	public Student() { }
	
	public Student(String roll, String name, double cgpa, LocalDate dob) {
		super();
		this.roll = roll;
		this.name = name;
		this.cgpa = cgpa;
		this.dob = dob;
	}

	public String getRoll() {
		return roll;
	}

	public void setRoll(String roll) {
		this.roll = roll;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getCgpa() {
		return cgpa;
	}

	public void setCgpa(double cgpa) {
		this.cgpa = cgpa;
	}

	public LocalDate getDob() {
		return dob;
	}

	public void setDob(LocalDate dob) {
		this.dob = dob;
	}

	@Override
	public String toString() {
		return "Student [roll=" + roll + ", name=" + name + ", cgpa=" + cgpa + ", dob=" + dob + "]";
	}
	
	

}
