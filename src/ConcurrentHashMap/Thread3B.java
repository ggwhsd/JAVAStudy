package ConcurrentHashMap;

public class Thread3B extends Thread {
	private MyService3 service;
	public Thread3B(MyService3 service){
		super();
		this.service = service;
		
	}
	public void run(){
		for (int i = 0; i<5000; i++)
		{
			service.map.put("ThreadB" + (i+1), "THreadB"+i+1);
			System.out.println("ThreadB"+(i+1));
		}
	}
}
