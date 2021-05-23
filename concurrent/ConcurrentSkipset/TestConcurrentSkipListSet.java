package ConcurrentSkipset;

public class TestConcurrentSkipListSet {

	public static void main(String[] args) {
		
		MyService1 service = new MyService1();
		ThreadA a = new ThreadA(service);
		ThreadA b = new ThreadA(service);
		a.start();
		b.start();
	}

}
