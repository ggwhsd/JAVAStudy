package ConcurrentHashMap;

public class Thread2A extends Thread {
	private MyServiceHashtable service;
	public Thread2A(MyServiceHashtable service){
		super();
		this.service = service;
		
	}
	public void run(){
		for (int i = 0; i<5000; i++)
		{
			service.map.put("ThreadA" + (i+1), "THreadA"+i+1);
			System.out.println("ThreadA"+(i+1));
		}
	}
}
