package ConcurrentHashMap;

public class testhasmap {

	/*
	 * HashMap���̰߳�ȫ��ͬʱ���������߳̾ͻ�������ݲ�һ�����⡣���ո�����һ����10000������ʱ����9999����ʱ������������
	 */
	public static void main(String[] args) {
		
		MyServicehashMap service = new MyServicehashMap();
		
		Thread1A a = new Thread1A(service);
		Thread1B b = new Thread1B(service);
		
		a.start();
		b.start();
		
		try
		{
			Thread.sleep(1000);
		}
		catch(InterruptedException e)
		{
			
		}
		System.out.println(service.map.size());
	}

}
