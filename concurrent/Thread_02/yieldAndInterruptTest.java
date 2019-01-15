package Thread_02;


/*
 * 关于Thread类的interrupt方法，以及interrupted()的使用，一般我不会使用着两个方法。
 * 以及yield方法。
 */
public class yieldAndInterruptTest {
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
		
		MyYieldThread boy = new MyYieldThread();
		boy.start();
	}
}
