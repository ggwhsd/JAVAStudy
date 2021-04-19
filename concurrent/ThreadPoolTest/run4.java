package ThreadPoolTest;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


public class run4 {

	public static void main(String[] args) {
		System.out.println("start ");
		System.out.println("处理器数量:"+Runtime.getRuntime().availableProcessors());
		ExecutorService  executorsService = Executors.newSingleThreadExecutor();
		//Executors.newSingleThreadExecutor();
		int count =100;
		while(count>0)
		{
			executorsService.execute(new SimpleTask());
			
			count--;
		}
		executorsService.shutdown();
		
		
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		}
		
		
		System.out.println("---------------------------------------------"+executorsService.isTerminated());
		
	}

}
