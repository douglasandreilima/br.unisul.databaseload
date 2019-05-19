package br.unisul.databaseload;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) throws InterruptedException {

		BlockingQueue<DataModel> sharedMemory = new ArrayBlockingQueue<DataModel>(1000);

		Thread reader = new Thread(new ReadDataXls("test-files/PAC_2018_06.xlsx", sharedMemory));
		Thread writer = new Thread(new DatabaseWriter(sharedMemory));
		long start = System.currentTimeMillis();

		reader.start();
		writer.start();

		while (reader.isAlive() && writer.isAlive()) {
			Thread.sleep(500);

		}
		System.out.println("Total time: " + (System.currentTimeMillis() - start));
	}
}
