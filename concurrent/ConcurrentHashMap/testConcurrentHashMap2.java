package ConcurrentHashMap;

import java.util.Collections;

public class testConcurrentHashMap2 {

	/*
	 * concurrenthashmap �����߳�ͨ����������ȡʱ�������̸߳��£�Ҳ���԰�ȫ���������ᵼ�µ�����������ͻ��
	 */
	public static void main(String[] args) {
		
		try
		{
			MyService5 service = new MyService5();
			Thread5A a = new Thread5A(service);
			a.start();
			Thread.sleep(1000);
			Thread5B b = new Thread5B(service);
			b.start();
			
		}
		catch(InterruptedException ex)
		{
			ex.printStackTrace();
		}
	}

}
