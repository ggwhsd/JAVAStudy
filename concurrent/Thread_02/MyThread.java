package Thread_02;
import java.lang.InterruptedException;

public class MyThread extends Thread {
	@Override
	public void run(){
		super.run();
		try{
			for ( int i = 0; i< 500000 ; i++ )
			{
				//判断该对象线程是否中断
				if(this.interrupted()){
					System.out.println("has interrupted! i am quit!");
					throw new InterruptedException();
				}
				System.out.println("i am not executed , yeah !");
			}
			System.out.println("i am not executed ,too , yeah !");
		}
		catch(InterruptedException e)
		{
			System.out.println("exception has been catched");
			e.printStackTrace();
		}
	}
}
