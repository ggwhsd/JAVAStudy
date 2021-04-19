package ThreadPoolTest;

public class SimpleTask implements Runnable {
	
	@Override
	public void run(){
		
			System.out.println(Thread.currentThread().getName()
						+ " "+System.currentTimeMillis());
			
			System.out.println("A");
			System.out.println("Runnable1 end"
						+ System.currentTimeMillis());
	}
}
