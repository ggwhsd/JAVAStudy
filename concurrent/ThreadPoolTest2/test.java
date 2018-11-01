package ThreadPoolTest2;

import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;


public class test {
	public static void main(String[] args) throws InterruptedException{
		MyRunnable2 myRunnable = new MyRunnable2();
		ThreadPoolExecutor pool = new ThreadPoolExecutor(2,9999,9999L,TimeUnit.SECONDS,new LinkedBlockingDeque<Runnable>());
		pool.setThreadFactory(new MyThreadFactoryB());
		pool.execute(myRunnable);
		
	}
}
