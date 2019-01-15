package Thread_02;
import java.lang.InterruptedException;

public class MyThread extends Thread {
	@Override
	public void run(){
		super.run();
		try{
			for ( int i = 0; i< 500000 ; i++ )
			{
				//interrupted会擦出内部的标志，所以被interrupte之后，第一次interrupted为true，第二次则为false。
				if(this.interrupted()){
					System.out.println("has interrupted! i am quit!");
					throw new InterruptedException();
				}
				System.out.println("i am not executed , yeah !");
			}
			System.out.println("i am not executed ,too , yeah !");
		}
		catch(InterruptedException e)
		{
			System.out.println("exception has been catched");
			//e.printStackTrace();
		}
	}
}

class MyThread2 extends Thread {
	@Override
	public void run(){
			for ( int i = 0; i< 500000 ; i++ )
			{
				//isInterrupted只是判断是否被打断了，不会修改任何线程内部数据
				if(this.isInterrupted()){
					System.out.println(Thread.currentThread().getName()+"has interrupted! i am quit!");
					//throw new InterruptedException();
				}
				//System.out.println(Thread.currentThread().getName()+"i am not executed , yeah !");
			}
			System.out.println(Thread.currentThread().getName()+"i am not executed ,too , yeah !");
		
		
	}
}



class MyYieldThread extends Thread {
	@Override
	public void run()
	{
		long beginTime = System.currentTimeMillis();
		int count = 0;
		for ( int i = 0 ; i < 5000000 ; i++)
		{
			/*
			 * yield()的作用是让步。它能让当前线程由“运行状态”进入到“就绪状态”，从而让其它具有相同优先级的等待线程获取执行权；但是，并不能保
               证在当前线程调用yield()之后，其它具有相同优先级的线程就一定能获得执行权；也有可能是当前线程又进入到“运行状态”继续运行！
			 */
			Thread.yield();
			count = count + ( i + 1 );
		}
		long endTime = System.currentTimeMillis();
		System.out.println("consume time : " + (endTime - beginTime) + "millisencods");
	}
}
