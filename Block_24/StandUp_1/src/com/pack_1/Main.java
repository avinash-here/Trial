package com.pack_1;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class Main {
		
	public static void main(String[] args) {
		
		Set<Employee> set = new TreeSet<>();	
		
		set.add(new Employee(1, "Rahul", "Delhi", 60000));
		set.add(new Employee(2, "Rahul", "Delhi", 70000));
		set.add(new Employee(3, "Rahul", "Delhi", 40000));
		
		for(Employee e : set)
		System.out.println(e);
			
	}	
}



















