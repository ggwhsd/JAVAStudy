package firstThreadStudy;

public class test {
	public static void main(String args[])
	{
		MtThread1 my = new MtThread1();
		Thread t = new Thread(my,"thread1");
		t.start();
		try{
		Thread.sleep(1);
		}
		catch(InterruptedException e)
		{
			System.out.println("线程从sleep状态被中断");
		}
		System.out.println(t.getName() + ":" +t.isAlive());
		t.start(); //此时会报错，一个线程运行万run()之后就死亡了。
	}
}
