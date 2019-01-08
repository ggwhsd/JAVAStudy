package ConcurrentHashMap;

public class test3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
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
