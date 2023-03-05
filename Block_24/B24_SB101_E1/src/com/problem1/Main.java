package com.problem1;

import java.util.function.*;

public class Main {
	
	public static void main(String[] args) {
		
		Function<String, Product> myFun = s -> {
			String[] str = s.split(",");
			return new Product(Integer.parseInt(str[0]), str[1], Double.parseDouble(str[2]),Integer.parseInt(str[3]));
		};		
		System.out.println(myFun.apply("1,Pen,20.00,100"));
				
		Supplier<Product> mySupplier = () -> new Product(2, "Pencil", 10.00, 200);		
		System.out.println(mySupplier.get());
				
		Consumer<Product> myCon = p -> System.out.println(p);		
		myCon.accept(new Product(3, "Eraser", 8.00, 100));
		
		Predicate<Product> myPre = p -> p.getQuantity() < 5;
		System.out.println(myPre.test(new Product(4, "Notebook", 40.00, 2)));
		System.out.println(myPre.test(new Product(5, "Sharpner", 10.00, 20)));
				
	}
	
}