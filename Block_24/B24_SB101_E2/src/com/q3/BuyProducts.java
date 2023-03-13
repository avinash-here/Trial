package com.q3;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.util.Map;
import java.util.Scanner;

public class BuyProducts {
	public static void main(String[] args) throws IOException, ClassNotFoundException{
		//Deserialize products
		ObjectInput oi = new ObjectInputStream(new FileInputStream("product.ser"));
		Map<String, Double> map = (Map<String, Double>)oi.readObject();
		oi.close();
		
		Scanner sc = new Scanner(System.in);
		double billAmount = 0;
		while(true) {
			System.out.println("Enter product name & quntity");
			String productName = sc.next();
			int quantity = sc.nextInt();
			billAmount = billAmount + quantity * map.get(productName);
			System.out.println("Do you want to purchase more ");
			char choice = sc.next().toLowerCase().charAt(0);
			if(choice != 'y')
				break;
		}
		
		System.out.println("Toal bill Amount is " + billAmount);
		sc.close();
	}
}
