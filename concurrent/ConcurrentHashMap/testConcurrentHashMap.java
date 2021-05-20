package ConcurrentHashMap;

public class testConcurrentHashMap {

	/*
	 * ConcurrentHashMap并发hashmap，比hashtable性能更好。当然比hashmap性能稍弱些。
	 */
	public static void main(String[] args) {
		
		MyService3 service = new MyService3();
		Thread3A a = new Thread3A(service);
		Thread3B b = new Thread3B(service);
		
		a.start();
		b.start();
		
		try
		{
			Thread.sleep(1000);
		}
		catch(InterruptedException e)
		{
			
		}
		System.out.println(service.map.size());
	}

}
