package ConcurrentHashMap;

public class test {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		MyService1 service = new MyService1();
		Thread1A a = new Thread1A(service);
		a.start();
	}

}
