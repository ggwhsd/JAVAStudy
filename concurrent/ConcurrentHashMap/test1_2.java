package ConcurrentHashMap;

public class test1_2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MyService1 service = new MyService1();
		
		Thread1A a = new Thread1A(service);
		Thread1B b = new Thread1B(service);
		
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
