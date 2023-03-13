package com.q4;

import java.util.Random;

public class Main {
	
	public static void main(String[] args) {  // It's not a self-terminating program. You have to terminate it manually.
		Common c = new Common();
		
		Producer pro = new Producer(c);
		Consumer con = new Consumer(c);
		
		pro.start();
		con.start();
		
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
	boolean flag = true;
	
	synchronized public void produce() {
		
		while(true) {
			Random r = new Random();
			int i = (int) (Math.random() * 6);
			System.out.println("Producer produced: " + i);
			value = i;
			flag = false;
			notify();
			try {
				Thread.sleep(1000);
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}			
		}
		
	}
	
	synchronized public void consume() {
		
		if(flag)
			try {
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		while(true) {
			int total = 0;
			for(int i = 0; i <= value; i++) total += i;
			System.out.println("Consumer Calculated Sum is: " + total + "\n");
			notify();
			try {
				Thread.sleep(1000);
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
}