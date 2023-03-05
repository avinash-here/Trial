package com.problem6;

import java.util.Objects;

public class GroceryItems implements Comparable<GroceryItems>{
	
	private double price;
	private String name;
	private double usedFrequency;
	
	public GroceryItems() {}

	public GroceryItems(double price, String name, double usedFrequency) {
		super();
		this.price = price;
		this.name = name;
		this.usedFrequency = usedFrequency;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getUsedFrequency() {
		return usedFrequency;
	}

	public void setUsedFrequency(double usedFrequency) {
		this.usedFrequency = usedFrequency;
	}

	@Override
	public String toString() {
		return "GroceryItems [price=" + price + ", name=" + name + ", usedFrequency=" + usedFrequency + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(name, price, usedFrequency);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		GroceryItems other = (GroceryItems) obj;
		return Objects.equals(name, other.name)
				&& Double.doubleToLongBits(price) == Double.doubleToLongBits(other.price)
				&& Double.doubleToLongBits(usedFrequency) == Double.doubleToLongBits(other.usedFrequency);
	}

	@Override
	public int compareTo(GroceryItems o) {
		if(this.usedFrequency < o.usedFrequency) return 1;
		else if(this.usedFrequency > o.usedFrequency) return -1;
		else {
			if(this.price < o.price) return 1;
			else if(this.price > o.price) return -1;
			else return o.name.compareTo(name);
		}
	}
	
}
