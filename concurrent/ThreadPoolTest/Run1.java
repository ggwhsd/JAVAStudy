package ThreadPoolTest;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;

public class Run1 {
	public static void main(String[] args)
	{
		System.out.println("start ");
		//线程池无限大，会复用空闲线程
		ExecutorService executorsService = Executors.newCachedThreadPool();
		executorsService.execute(new Runnable(){
			@Override
			public void run(){
				
					System.out.println(Thread.currentThread().getName()
								+ " "+System.currentTimeMillis());
					
					System.out.println("A");
					System.out.println("Runnable1 end"
								+ System.currentTimeMillis());
			}
		});
		System.out.println("step2 ");
		try{
			Thread.sleep(1000);
		}
		catch(InterruptedException ex)
		{
			ex.printStackTrace();
		}
		System.out.println("step3 ");
		executorsService.execute(new Runnable(){
			@Override 
			public void run()
			{
				try{
					System.out.println(Thread.currentThread().getName()
							+ " "+System.currentTimeMillis());
				Thread.sleep(1000);
				System.out.println("B");
				System.out.println("Runnable2 end"
							+ System.currentTimeMillis());
				}
				catch(InterruptedException e){
					e.printStackTrace();
				}
			}
		});
	
		
	}
}
