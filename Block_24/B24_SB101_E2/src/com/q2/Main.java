package com.q2;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.PrintWriter;
import java.nio.Buffer;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Main {
	
	public static void main(String[] args) {		
		
		Runnable first = () -> {
			File f = new File("student.txt");		
			try {
				PrintWriter pw = new PrintWriter(f);			
				pw.println("Anuj 56.25 77.58");
				pw.println("Bharat 66.25 57.58");
				pw.println("Chaman 70.25 66.74");
				pw.println("Dhanush 58.25 95.74");
				pw.println("Garv 58.62 95.74");
				pw.close();
			} catch (FileNotFoundException e) {			
				e.printStackTrace();
			}
		};
		
		Callable<String> second = () -> {
			String res = null;
			double hiPer = 0.0;
			
			BufferedReader br = new BufferedReader(new FileReader("student.txt"));		
			List<String> content = br.lines().toList();
			
			for(String str : content) {
				String[] strArr = str.split(" ");
				if(hiPer < Double.parseDouble(strArr[2])) {
					hiPer = Double.parseDouble(strArr[2]);
					res = strArr[0];
				}
			}	 		
			return res;
		};
		
		Callable<Double> third = () -> {
			Double res = 0.0;
			
			BufferedReader br = new BufferedReader(new FileReader("student.txt"));		
			List<String> content = br.lines().toList();
			
			for(String str : content) {
				String[] strArr = str.split(" ");
				res += Double.parseDouble(strArr[2]);
			}	 		
			return res/content.size();
		};
		
		
		
		Thread t1 = new Thread(first, "First Thread");
		t1.start();
		try {  
			t1.join();  
		} 
		catch (InterruptedException e) {
			e.printStackTrace();  
		}

		ExecutorService es = Executors.newFixedThreadPool(2);
		
		Future<String> resStr = es.submit(second);
		Future<Double> resDub = es.submit(third);
		es.shutdown();
		
		try {
			System.out.println("The student with highest percentage is " + resStr.get());
			System.out.println("The average attendance percentage of all the scholars is " + resDub.get());
		} catch (InterruptedException | ExecutionException e) {			
			e.printStackTrace();
		}
		
		
 		
	}

}










/*

class FirstThread implements Runnable {

	@Override
	public void run() {
		File f = new File("student.txt");		
		try {
			PrintWriter pw = new PrintWriter(f);			
			pw.println("Anuj 56.25 77.58");
			pw.println("Bharat 66.25 57.58");
			pw.println("Chaman 70.25 66.74");
			pw.println("Dhanush 58.25 95.74");
			pw.println("Garv 58.62 95.74");
			
		} catch (FileNotFoundException e) {			
			e.printStackTrace();
		}				
	}
	
}

class SecondThread implements Callable<String> {

	@Override
	public String call() throws Exception {
		String res = null;
		double hiPer = 0.0;
		
		BufferedReader br = new BufferedReader(new FileReader("student.txt"));		
		List<String> content = br.lines().toList();
		
		for(String str : content) {
			String[] strArr = str.split(" ");
			if(hiPer < Double.parseDouble(strArr[2])) {
				hiPer = Double.parseDouble(strArr[2]);
				res = strArr[0];
			}
		}	 		
		return res;
	}
	
}

class ThirdThread implements Callable<Double> {

	@Override
	public Double call() throws Exception {
		Double res = 0.0;
				
		BufferedReader br = new BufferedReader(new FileReader("student.txt"));		
		List<String> content = br.lines().toList();
		
		for(String str : content) {
			String[] strArr = str.split(" ");
			res += Double.parseDouble(strArr[2]);
		}	 		
		return res/content.size();
	}
	
}


*/




