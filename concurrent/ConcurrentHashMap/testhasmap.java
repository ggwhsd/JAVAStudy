package ConcurrentHashMap;

public class testhasmap {

	/*
	 * HashMap非线程安全，同时启动两个线程就会出现数据不一致问题。最终个数不一定是10000个，有时候是9999，有时候是其他数据
	 */
	public static void main(String[] args) {
		
		MyServicehashMap service = new MyServicehashMap();
		
		Thread1A a = new Thread1A(service);
		Thread1B b = new Thread1B(service);
		
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
