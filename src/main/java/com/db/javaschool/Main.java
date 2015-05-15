package com.db.javaschool;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class Main {

	public static void main(String[] args) throws InterruptedException, ExecutionException {
		ExecutorService executor = Executors.newCachedThreadPool();
		BlockingQueue<Double> queue = new ArrayBlockingQueue<Double>(100);
		Consumer consumer = new Consumer(queue, 1e5);
		long start = System.currentTimeMillis();
		Future<Double> future = executor.submit(consumer);
		for (int i = 0; i < 8; i++) {
			Producer producer = new Producer(queue);
			executor.submit(producer);
		}
		try {
			future.get(10, TimeUnit.SECONDS);
			System.out.println("Elapsed time: " + (System.currentTimeMillis() - start) + " ms");
		} catch (TimeoutException e) {
			e.printStackTrace();
		}	
		executor.shutdownNow();
	}
}
