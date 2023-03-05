package com.problem2;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
	
	public static void main(String[] args) {
		
		List<Student> list = new ArrayList<>();		
		list.add(new Student(1, "Amar", 574, "Patna"));
		list.add(new Student(2, "Bunty", 625, "Lucknow"));
		list.add(new Student(3, "Cheeku", 529, "Delhi"));
		list.add(new Student(4, "Dada", 484, "Kanpur"));
		list.add(new Student(5, "Eric", 441, "Chandigarh"));
		
		
		List<Employee> empList = list.stream().filter(s -> s.getMarks() > 500)
					 						  .map(s -> new Employee(s.getRoll(), s.getName(), s.getMarks()*1000, s.getAddress()))					 						  
					 						  .collect(Collectors.toList());
											  
		empList.sort((e1, e2) -> e1.getSalary() < e2.getSalary() ? 1 : -1);
		
		System.out.println("Employees' List");
		empList.forEach(e -> System.out.println(e));
		
		System.out.println();
		
		System.out.println("Original Students' List");
		list.forEach(s -> System.out.println(s));
			
	}
}