package ExchangerTest;

import java.util.concurrent.Exchanger;

public class ThreadB extends Thread {
	private Exchanger<String> exchanger;
	public ThreadB(Exchanger<String> exchanger)
	{
		super();
		this.exchanger = exchanger;
	}
	@Override
	public void run(){
		try{
			System.out.println(Thread.currentThread().getName()+":begin");
			System.out.println(Thread.currentThread().getName()+":"
								+ exchanger.exchange("chineseB"));
			System.out.println(Thread.currentThread().getName()+":end");
			
		}catch(InterruptedException e){
			e.printStackTrace();
		}
	}
}
