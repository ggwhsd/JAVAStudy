package ConcurrentHashMap;

import java.util.Iterator;

public class Thread5A extends Thread {
	private MyService5 service;
	public Thread5A(MyService5 service)
	{
		super();
		this.service  = service;
	}
	
	public void run(){
		try
		{
			Iterator iterator = service.map.keySet().iterator();
			while(iterator.hasNext())
			{
				System.out.println(iterator.next());
				Thread.sleep(3000);
			}
			
		}
		catch(InterruptedException ex)
		{
			ex.printStackTrace();
		}
	}
}
