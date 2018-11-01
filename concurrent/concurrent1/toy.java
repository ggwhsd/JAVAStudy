package concurrent1;

public class toy {
	private int number;
	public toy(){
		number = 100;
	}
	synchronized public void getToy()
	{
		
		number--;
		System.out.println(Thread.currentThread().getName() + " toy's total number reduced one! now : " + number);
		
	
	}
	public void showHello()
	{
		System.out.println(Thread.currentThread().getName()+"hello begin");
		try{
			int i = (int) (Math.random()*10000);
		System.out.println(i+"seconds");

		Thread.sleep(i);
		}
		catch(Exception e)
		{
			
		}
		System.out.println(Thread.currentThread().getName()+"hello end");
		
	}
	synchronized public void paint()
    {
		System.out.println("thread:"+Thread.currentThread().getName() + ":paint begin");
		try{
			int i = (int) (Math.random()*10000);
		System.out.println(i+"seconds");

		Thread.sleep(i);
		}
		catch(Exception e)
		{
			
		}
        System.out.println("thread:"+Thread.currentThread().getName()+":paint");
        System.out.println("thread:"+Thread.currentThread().getName() + ":paint end");
    }
	 synchronized public void write()
    {
		System.out.println("thread:"+Thread.currentThread().getName() + ":write begin");
		try{
			int i = (int) (Math.random()*10000);
		System.out.println(i+"seconds");
		Thread.sleep(i);
		}
		catch(Exception e)
		{
			
		}
        System.out.println("thread:"+Thread.currentThread().getName()+":write");
        System.out.println("thread:"+Thread.currentThread().getName() + ":write end");
    }
}
