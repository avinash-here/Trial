package com.pack_1;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class Main {
		
	public static void main(String[] args) {
		
		Set<Employee> set = new TreeSet<>();
		
		//Employee e = new Employee(1, "Rahul", "Delhi", 60000);
		
		set.add(new Employee(1, "Rahul", "Delhi", 60000));
		set.add(new Employee(2, "Rahul", "Delhi", 70000));
		set.add(new Employee(3, "Rahul", "Delhi", 40000));
		
//		set.add("Rahul");
//		set.add("Avinash");
//		set.add("Rahul");
		
		
		for(Employee e : set)
		System.out.println(e);
		
//		for(String e : set)
//			System.out.println(e);
		
		
	}
	
}



