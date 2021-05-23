package ExchangerTest;

import java.util.concurrent.Exchanger;

public class ThreadA extends Thread {
	private Exchanger<String> exchanger;
	public ThreadA(Exchanger<String> exchanger)
	{
		super();
		this.exchanger = exchanger;
	}
	@Override
	public void run(){
		try{
			System.out.println(Thread.currentThread().getName()+":begin");
			System.out.println(Thread.currentThread().getName()+":"
								+ exchanger.exchange("chineseA"));
			Thread.sleep(1000);
			System.out.println(Thread.currentThread().getName()+":end");
			
		}catch(InterruptedException e){
			e.printStackTrace();
		}
	}
}
