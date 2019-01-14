package Thread_03;

public class Test {
	public static void main(String[] args)
	{
		try{
			MyThread2 boy = new MyThread2();
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
