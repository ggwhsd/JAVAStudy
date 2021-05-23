package ExchangerTest;

import java.util.concurrent.Exchanger;

public class ExchangerTest {

	/*
	 * Exchanger�����������߳�֮��ͬ����ȫ�������ݡ�  
	 * ��A�߳̽���Exchanger.exchange����ʱ����������ֱ��B�̵߳����˸÷�������ʱAB�߳�������ݽ���������������ִ�С�
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
