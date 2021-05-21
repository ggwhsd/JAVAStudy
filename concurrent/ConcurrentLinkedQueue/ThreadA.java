package ConcurrentLinkedQueue;

public class ThreadA extends Thread{
	private MyService1 service;
	
	public ThreadA(MyService1 service)
	{
		super();
		this.service = service;
	}
	public void run(){
		for(int i=0; i< 500; i++)
		{
			service.queue.add("threadA"+(i+1));
			
		}
	}
}
