package Thread_01;

public class Test2MyThread {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
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
