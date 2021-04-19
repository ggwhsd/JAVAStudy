package ThreadPoolTest;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Run3 {
	public static void main(String[] args) {
		System.out.println("start ");
		System.out.println("处理器数量:"+Runtime.getRuntime().availableProcessors());
		ScheduledExecutorService  executorsService = Executors.newScheduledThreadPool(6);
		int count =100;
		while(count>0)
		{
			executorsService.schedule(new SimpleTask(),10,TimeUnit.SECONDS);
			
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
