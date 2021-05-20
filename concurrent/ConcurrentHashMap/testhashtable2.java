package ConcurrentHashMap;

public class testhashtable2 {
	/*
	 * hashtable虽然是线程安全的，但是当一个线程在迭代器读取hashtable时，另一个线程更新操作，使得其迭代器触发异常。
	 */
	public static void main(String[] args)
	{
		try
		{
			MyService4 service = new MyService4();
			Thread4A a = new Thread4A(service);
			a.start();
			Thread.sleep(1000);
			Thread4B b = new Thread4B(service);
			b.start();
		}
		catch(InterruptedException e)
		{}
	}
}
