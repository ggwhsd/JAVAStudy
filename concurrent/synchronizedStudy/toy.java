package synchronizedStudy;

/*
 * 
 * 
一、当两个并发线程访问同一个对象object中的这个synchronized(this)同步代码块时，一个时间内只能有一个线程得到执行。另一个线
程必须等待当前线程执行完这个代码块以后才能执行该代码块。
二、然而，当一个线程访问object的一个synchronized(this)同步代码块时，另一个线程仍然可以访问该object中的非synchronized
(this)同步代码块。
三、尤其关键的是，当一个线程访问object的一个synchronized(this)同步代码块时，其他线程对object中所有其它synchronized(this)
同步代码块的访问将被阻塞。
四、当一个线程访问object的一个synchronized(this)同步代码块时，它就获得了这个object的对象锁。结果，其它线程对该object对象所有同步代码部分的访问都被暂时阻塞。
 */

public class toy {
	private int number;
	public toy(){
		number = 100;
	}
	synchronized public void getToy()
	{
		
		number--;
		System.out.println(Thread.currentThread().getName() + " toy's total number reduced one! now : " + number);
		
	
	}
	public void showHello()
	{
		System.out.println(Thread.currentThread().getName()+"hello begin");
		try{
			int i = (int) (Math.random()*10000);
		System.out.println(i+"seconds");

		Thread.sleep(i);
		}
		catch(Exception e)
		{
			
		}
		System.out.println(Thread.currentThread().getName()+"hello end");
		
	}
	synchronized public void paint()
    {
		System.out.println("thread:"+Thread.currentThread().getName() + ":paint begin");
		try{
			int i = (int) (Math.random()*10000);
		System.out.println(i+"seconds");

		Thread.sleep(i);
		}
		catch(Exception e)
		{
			
		}
        System.out.println("thread:"+Thread.currentThread().getName()+":paint");
        System.out.println("thread:"+Thread.currentThread().getName() + ":paint end");
    }
	 synchronized public void write()
    {
		System.out.println("thread:"+Thread.currentThread().getName() + ":write begin");
		try{
			int i = (int) (Math.random()*10000);
		System.out.println(i+"seconds");
		Thread.sleep(i);
		}
		catch(Exception e)
		{
			
		}
        System.out.println("thread:"+Thread.currentThread().getName()+":write");
        System.out.println("thread:"+Thread.currentThread().getName() + ":write end");
    }
}
