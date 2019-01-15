package Thread_01;

public class ThreadCreateTest {

	public static void main(String[] args) {
		
		MyThread boy = new MyThread();
		boy.setName("boy");
		MyThread girl = new MyThread();
		girl.setName("girl");
		Thread car = new Thread(girl);
		car.setName("car");
		boy.start();
		car.start();
		try{
			int i = 50;
			while(i>0)
			{
		Thread.sleep(300);
		System.out.println("car isalive : " + car.isAlive());
		System.out.println("boy isalive : " + boy.isAlive());
		i--;
			}
		
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		System.out.println("method end");
	}

}
