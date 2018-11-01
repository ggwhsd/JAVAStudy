package ExchangerTest;

import java.util.concurrent.Exchanger;

public class ExchangerTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Exchanger<String> exchanger = new Exchanger<String>();
		
		ThreadA a = new ThreadA(exchanger);
		a.setName("test1");
		a.start();
		
		ThreadB b = new ThreadB(exchanger);
		b.setName("");
		b.start();
		System.out.println("main End");
	}

}
