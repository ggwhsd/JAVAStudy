package ConcurrentLinkedQueue;

public class testConcurrentLinkedQueue {

	public static void main(String[] args) {
		
		try
		{
			MyService1 service = new MyService1();
			ThreadA a = new ThreadA(service);
			ThreadB b = new ThreadB(service);
			
			a.start();
			b.start();
			a.join();
			b.join();
			System.out.println(service.queue.size());
			
			System.out.println(service.queue.poll()+" "+service.queue.size());
			System.out.println(service.queue.peek()+" "+service.queue.size());
			
		}
		catch(InterruptedException ex)
		{
			ex.printStackTrace();
		}
	}

}
