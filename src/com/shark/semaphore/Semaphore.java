package com.shark.semaphore;

public class Semaphore {
	
	private int counter;
	
	Semaphore(int i) {
		if (i < 0) {
			throw new IllegalArgumentException(i + " < 0");
		}
		counter = i;
	}
	
	public synchronized void acquire()
	throws InterruptedException {
		while (counter == 0) {
			this.wait();
		}
		counter--;	
	}
	
	public synchronized void release() {
		if (counter == 0) {
			this.notify();
		}
		counter++;
	}
	
	public static void main(String[] args) {
		
	}
}
