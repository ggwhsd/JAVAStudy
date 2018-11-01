package ConcurrentHashMap;

public class test4 {
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
