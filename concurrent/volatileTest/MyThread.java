package volatileTest;

public class MyThread extends Thread{
	volatile public static int count;
	synchronized private static void addCount(){
		for (int i = 0; i < 100; i++)
		{
			count++;
			
		}
		System.out.println("Count="+count);
	}
	@Override
	public void run(){
		addCount();
	}
}
