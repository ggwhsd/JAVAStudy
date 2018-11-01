package ConcurrentHashMap;

public class Thread2B extends Thread {
	private MyService2 service;
	public Thread2B(MyService2 service)
	{
		super();
		this.service = service;
	}
	public void run()
	{
		for(int i =0; i<5000; i++)
		{
			service.map.put("ThreadB"+(i+1), "ThreadB"+i+1);
			System.out.println("ThreadA"+(i+1));
			
		}
	}
}
