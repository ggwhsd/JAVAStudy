package thirdThread;

public class Test {
	public static void main(String[] args)
	{
		try{
			MyThread boy = new MyThread();
			boy.start();
			Thread.sleep(2000);
			boy.interrupt();
			
		}catch(InterruptedException e)
		{
			System.out.println("main catch");
			e.printStackTrace();
		}
	}
}
