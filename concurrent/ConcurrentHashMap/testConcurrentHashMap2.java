package ConcurrentHashMap;

import java.util.Collections;

public class testConcurrentHashMap2 {

	/*
	 * concurrenthashmap 当多线程通过迭代器读取时，其他线程更新，也可以安全操作，不会导致迭代器并发冲突。
	 */
	public static void main(String[] args) {
		
		try
		{
			MyService5 service = new MyService5();
			Thread5A a = new Thread5A(service);
			a.start();
			Thread.sleep(1000);
			Thread5B b = new Thread5B(service);
			b.start();
			
		}
		catch(InterruptedException ex)
		{
			ex.printStackTrace();
		}
	}

}
