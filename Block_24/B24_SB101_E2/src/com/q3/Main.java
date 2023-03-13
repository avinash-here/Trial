package com.q3;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
	
	static {
		try {
			ObjectOutput objout = new ObjectOutputStream(new FileOutputStream("spices.ser"));
			List<Spice> spices = Arrays.asList(new Spice("Salt", 1000, 30), new Spice("Turmeric", 100, 35), new Spice("Cumin", 100, 40),
											   new Spice("Cinnamon", 25, 70), new Spice("Mace", 10, 25)); 
			
			objout.writeObject(spices);
			objout.close();			
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Welcome to Ramesh Spices");
		
		try {
			ObjectInput objIn = new ObjectInputStream(new FileInputStream("spices.ser"));
			
			List<Spice> spices = (List<Spice>)objIn.readObject();
			
			double total = 0.0;
			
			for(int i = 0; i < spices.size(); i++) {
				Spice s = spices.get(i);
				System.out.println("\n" + s.getName() + " is ₹ " + s.getRate() + " per packet (" + s.getWeight() + "g)");
				System.out.println("Please enter the number of packets");
				int packs = sc.nextInt();
				total += packs * s.getRate();
			}
			
			System.out.println("\nYour total bill is ₹ " + total);
			System.out.println("Thank you for shopping with us.");
			
		} catch (IOException | ClassNotFoundException e) {			
			e.printStackTrace();
		}
		
		
	}

}

class Spice implements Serializable{
	String name;
	int weight; // weight is in grams
	double rate;
	
	public Spice(String name, int weight, double rate) {
		super();
		this.name = name;
		this.weight = weight;
		this.rate = rate;
	}

	public String getName() {
		return name;
	}
	
	public int getWeight() {
		return weight;
	}
	
	public double getRate() {
		return rate;
	}	
	
}
