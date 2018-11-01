package ConcurrentHashMap;

public class test2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	MyService2 service = new MyService2();
		
		Thread2A a = new Thread2A(service);
		Thread2B b = new Thread2B(service);
		
		a.start();
		b.start();
		try
		{
			Thread.sleep(5000);
		}
		catch(InterruptedException e)
		{
			
		}
		System.out.println(service.map.size());
		
	}

}
