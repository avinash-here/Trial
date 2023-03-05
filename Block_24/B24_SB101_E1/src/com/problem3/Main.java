package com.problem3;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Main {

	public static void main(String[] args) {
		
		List<String> names = Arrays.asList("Amar", "Bunty", "Chandan", "Dada", "Eric", "Farhan", "Gautam", "Harry", "Irvin", "Jackab");
		
		List<String> transformedNames = names.stream().filter(s -> s.length() % 2 == 0)
													  .map(s -> s.toUpperCase())
													  .collect(Collectors.toList());
		
		transformedNames.sort((n1, n2) -> n2.compareTo(n1));
		
		System.out.println("Original List");
		names.forEach(n -> System.out.println(n));
		
		System.out.println();
		
		System.out.println("Transformed List");
		transformedNames.forEach(n -> System.out.println(n));
		
	}
	
}
