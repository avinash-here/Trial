package com.q4;

import java.util.Random;

public class Main {
	
	public static void main(String[] args) {  
		Common c = new Common();
		
		Producer pro = new Producer(c);
		Consumer con = new Consumer(c);
		
		pro.start();
		con.start();
		
		try {
			pro.join();
			con.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
	}

}

class Producer extends Thread {
	Common c;
	public Producer(Common c) {
		this.c = c;
	}
	
	@Override
	public void run() {
		c.produce();
	}
}

class Consumer extends Thread {
	Common c;
	public Consumer(Common c) {
		this.c = c;
	}
	
	@Override
	public void run() {
		c.consume();
	}
}


class Common {
	int value;
	boolean flag = false;
	
	synchronized public void produce() {
		
		int count = 0;
		
		while(count++ < 5) {
			if(flag)
				try {	wait();		} catch (InterruptedException e) {	 e.printStackTrace();	}
			
			int i = (int) (Math.random() * 6);
			System.out.println("Producer produced: " + i);
			value = i;
			
			flag = true;
			notify();
		}
				
	}
	
	
	
	synchronized public void consume() {
		
		int count = 0;
		
		while(count++ < 5) {
			if(!flag)
				try {	wait();  } catch (InterruptedException e) { 	e.printStackTrace();	}
			
			int total = 0;
			for(int i = 0; i <= value; i++) total += i;
			System.out.println("Consumer Calculated Sum is: " + total + "\n");

			flag = false;
			notify();
		}
				
	}
	
}