package ThreadPoolTest3;

import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.TimeUnit;

public class Run {
	public static void main(String[] args)
	{
		MyThreadpoolExecutor executor = new MyThreadpoolExecutor(2,2,Integer.MAX_VALUE, TimeUnit.SECONDS, new LinkedBlockingDeque<Runnable>());
		executor.execute(new MyRunnable("A1"));
		executor.execute(new MyRunnable("A2"));
		executor.execute(new MyRunnable("A3"));
		executor.execute(new MyRunnable("A4"));
		executor.shutdown();
	}
}
