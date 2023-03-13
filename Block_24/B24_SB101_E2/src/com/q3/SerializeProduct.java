package com.q3;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.util.LinkedHashMap;
import java.util.Map;
public class SerializeProduct {
	public static void main(String[] args) throws IOException {
		Map<String, Double> productMap = new LinkedHashMap<>();
		productMap.put("salt", 30.00);
		productMap.put("turmeric", 35.00);
		productMap.put("cumin", 40.00);
		productMap.put("cinnamon", 70.00);
		productMap.put("mace", 25.00);
		
		ObjectOutput oo = new ObjectOutputStream(new
		FileOutputStream("product.ser"));
		oo.writeObject(productMap);
		oo.close();
		
		System.out.println("Product details serialized");
	}
}
