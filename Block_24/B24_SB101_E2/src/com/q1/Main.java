package com.q1;

public class Main {
	
	public static void main(String[] args) {
		
		Thread dhoni = new Thread(new Dhoni(), "Dhoni");
		Thread rohit = new Thread(new Rohit(), "Rohit");
		Thread virat = new Thread(new Virat(), "Virat");
				
		try {
			dhoni.start();
			dhoni.join();
			
			rohit.start();
			rohit.join();
			
			virat.start();
			virat.join();
			
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		System.out.println("Finished");
	}

}


class Dhoni implements Runnable {

	@Override
	public void run() {
		for(int i = 1; i <= 10; i++) {
			System.out.println(Thread.currentThread().getName() + " is printing " + i);
		}				
	}
	
}

class Rohit implements Runnable {

	@Override
	public void run() {
		int product = 1;
		for(int i = 1; i <= 10; i++) {
			product *= i;
		}
		System.out.println(Thread.currentThread().getName() + " is printing the product of first 10 numbers, " + product);
	}
	
}

class Virat implements Runnable {

	@Override
	public void run() {
		int sum = 0;
		for(int i = 1; i <= 20; i++) {
			sum += i;
		}
		System.out.println(Thread.currentThread().getName() + " is printing the sum of first 20 numbers, " + sum);				
	}
	
}
