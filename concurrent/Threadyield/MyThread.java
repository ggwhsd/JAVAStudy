package Threadyield;

public class MyThread extends Thread {
	@Override
	public void run()
	{
		long beginTime = System.currentTimeMillis();
		int count = 0;
		for ( int i = 0 ; i < 5000000 ; i++)
		{
			Thread.yield();
			count = count + ( i + 1 );
		}
		long endTime = System.currentTimeMillis();
		System.out.println("consume time : " + (endTime - beginTime) + "millisencods");
	}
}
