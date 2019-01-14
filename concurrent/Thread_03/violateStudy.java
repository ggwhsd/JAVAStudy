package Thread_03;

public class violateStudy extends Thread{
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
