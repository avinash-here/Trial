package com.pack_1;

import java.util.Objects;

public class Employee implements Comparable<Employee>{
	private int empId;
	private String name;
	private String address;
	private int salary;
	
	public Employee() {
		
	}

	public Employee(int empId, String name, String address, int salary) {
		super();
		this.empId = empId;
		this.name = name;
		this.address = address;
		this.salary = salary;
	}

	public int getEmpId() {
		return empId;
	}

	public void setEmpId(int empId) {
		this.empId = empId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

	@Override
	public String toString() {
		return "Employee [empId=" + empId + ", name=" + name + ", address=" + address + ", salary=" + salary + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(address, empId, name, salary);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Employee other = (Employee) obj;
		return Objects.equals(address, other.address) && empId == other.empId && Objects.equals(name, other.name)
				&& salary == other.salary;
	}

	@Override
	public int compareTo(Employee o) {		
		if(this.getSalary() < o.getSalary()) return -1;
		else if(this.getSalary() > o.getSalary()) return 1;
		return 0;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
		
}
