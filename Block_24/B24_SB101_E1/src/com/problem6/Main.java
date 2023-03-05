package com.problem6;

import java.util.*;

public class Main {
	
	public static void main(String[] args) {		
		
		Comparator<GroceryItems> comp = (o1, o2) -> {
			if(o1.getPrice() < o2.getPrice()) return -1;
			else if(o1.getPrice() > o2.getPrice()) return 1;
			else {
				if(o1.getUsedFrequency() < o2.getUsedFrequency()) return -1;
				else if(o1.getUsedFrequency() > o2.getUsedFrequency()) return 1;
				else return o1.getName().compareTo(o2.getName());					
			}								
		};				
	
		Set<GroceryItems> set1 = new TreeSet<>();
		set1.add(new GroceryItems(20, "Onion", 7));
		set1.add(new GroceryItems(40, "Masala", 10));
		set1.add(new GroceryItems(50, "Pulse", 15));
		set1.add(new GroceryItems(25, "Salt", 30));
		set1.add(new GroceryItems(150, "Oil", 7));
		
		set1.forEach(g -> System.out.println(g));
		System.out.println();
		
		Set<GroceryItems> set2 = new TreeSet<>(comp);
		set2.add(new GroceryItems(20, "Onion", 7));
		set2.add(new GroceryItems(40, "Masala", 10));
		set2.add(new GroceryItems(50, "Pulse", 15));
		set2.add(new GroceryItems(25, "Salt", 30));
		set2.add(new GroceryItems(150, "Oil", 7));
		
		set2.forEach(g -> System.out.println(g));
	}

}
