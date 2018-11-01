package ConcurrentHashMap;

import java.util.Iterator;

public class Thread4A extends Thread {
	private MyService4 myService;
	public Thread4A(MyService4 myService){
		super();
		this.myService = myService;
		
	}
	public void run(){
		try
		{
			Iterator iterator = myService.hashtable.keySet().iterator();
			while(iterator.hasNext())
			{
				System.out.println(iterator.next());
				Thread.sleep(3000);
				
			}
		}
		catch(InterruptedException ex)
		{
			
		}
		
	}
}
