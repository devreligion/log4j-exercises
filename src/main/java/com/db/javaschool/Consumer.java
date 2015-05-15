package com.db.javaschool;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Callable;

public class Consumer implements Callable<Double>{

	private final BlockingQueue<Double> queue;
	private double sum = 0;
	private final double desiredValue;

	public Consumer(BlockingQueue<Double> queue, double desiredValue) {
		this.queue = queue;
		this.desiredValue = desiredValue;
	}

	public Double call() {
		while (true) {
			try {
				sum += queue.take();
				System.out.println("Current value: " + sum);
				if (sum > desiredValue) {
					return sum;
				}
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
}
