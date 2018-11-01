package ConcurrentHashMap;

public class Thread5B extends Thread {
	private MyService5 service;
	public Thread5B(MyService5 service)
	{
		super();
		this.service = service;
		
	}
	public void run()
	{
		service.map.put("z", "zValue");
	}
}
