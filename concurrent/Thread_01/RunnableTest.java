package Thread_01;
/*
 * 线程的两种创建方法示例，其实Thread类也是实现了Runnable的接口类，所以线程本质上创建方法只有一种实现Runnable接口。
 */
public class RunnableTest {
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
