package com.db.javaschool;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;


public class Producer implements Runnable{

	private final BlockingQueue<Double> queue;
	
	private volatile boolean running = true;
	
	public Producer(BlockingQueue<Double> queue) {
		this.queue = queue;
	}

	public void run() {
		while (running) {
			double random = Math.random();
			System.out.println("Generated value: " + random);
			try {
				if (!queue.offer(random, 100, TimeUnit.MILLISECONDS)) {
					System.err.println("Queue is full. Stop producing.");
					return;
				}
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

}
