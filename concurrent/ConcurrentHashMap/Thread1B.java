package ConcurrentHashMap;

public class Thread1B extends Thread{
	private MyServicehashMap service;
	public Thread1B(MyServicehashMap service)
	{
		super();
		this.service  = service ;
	}
	public void run()
	{
		for (int i = 0; i<5000; i++)
		{
			service.map.put("Thread1B" + (i+1), "ThreadB" + i + 1);
			System.out.println("ThreadB" + (i+1));
		}
	}
}
