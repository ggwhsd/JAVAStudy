package ExchangerTest;

import java.util.concurrent.Exchanger;

public class ExchangerTest {

	/*
	 * Exchanger适用于两个线程之间同步安全交互数据。  
	 * 当A线程进入Exchanger.exchange方法时，会阻塞，直到B线程调用了该方法，此时AB线程完成数据交互，都继续往下执行。
	 */
	public static void main(String[] args) {
	
		Exchanger<String> exchanger = new Exchanger<String>();
		
		ThreadA a = new ThreadA(exchanger);
		a.setName("testA");
		a.start();
		
		ThreadB b = new ThreadB(exchanger);
		b.setName("testB");
		b.start();
		System.out.println("main End");
	}

}
