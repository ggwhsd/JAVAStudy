package ConcurrentHashMap;

public class testhashtable {

	/*
	 * hashtable���̰߳�ȫ�ģ�����hashmapһ���� 
	 */
	public static void main(String[] args) {
		
	MyServiceHashtable service = new MyServiceHashtable();
		
		Thread2A a = new Thread2A(service);
		Thread2B b = new Thread2B(service);
		
		a.start();
		b.start();
		try
		{
			Thread.sleep(5000);
		}
		catch(InterruptedException e)
		{
			
		}
		System.out.println(service.map.size());
		
	}

}
