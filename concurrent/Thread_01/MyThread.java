package Thread_01;

public class MyThread extends Thread {
	public MyThread(){
		
		System.out.println("MyThread currentThread().getName()="+Thread.currentThread().getName());
		System.out.println("MyThread this.getName=" + this.getName());
		
	}
	@Override
	public void run(){
		
		System.out.println("run currentThread().getName()="+Thread.currentThread().getName());
		System.out.println("run this.getName="+this.getName());
		int i=2;
		while(i>0)
		{
			System.out.println("run " + this.getName() + ": i = " + (i--));
			try{
			Thread.sleep(10000);
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
		}
		
		
	}
}
