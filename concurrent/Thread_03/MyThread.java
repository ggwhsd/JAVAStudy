package Thread_03;
import java.lang.InterruptedException;

public class MyThread extends Thread {
	@Override
	public void run(){
		super.run();
		try{
			System.out.println("mythread sleep");
			Thread.sleep(10000);				
			System.out.println("has interrupted! i am quit!");
		}
		catch(InterruptedException e)
		{
			System.out.println("exception has been catched");
			e.printStackTrace();
		}
	}
}
