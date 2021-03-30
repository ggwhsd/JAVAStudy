package ThreadPool;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ExecutorsOne {
	public static void main(String[] args) {
		//ExecutorService  executor = Executors.newCachedThreadPool();
		//ExecutorService  executor = Executors.newSingleThreadExecutor();
		ExecutorService  executor = Executors.newFixedThreadPool(100);
		for(int i =0; i<15; i++)
		{
			MyTask myTask = new MyTask(i);
			executor.execute(myTask);
			//executor.submit(myTask);
			
			
		}
		executor.shutdown();
	}
}
