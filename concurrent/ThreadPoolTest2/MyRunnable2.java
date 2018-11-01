package ThreadPoolTest2;
public class MyRunnable2 implements Runnable {
	public void run(){
		System.out.println(Thread.currentThread().getName() + " " + System.currentTimeMillis());
		String abc = null;
		//此处有异常，而且未使用try进行处理，将会直接抛出到线程类中
		abc.indexOf(0);
		System.out.println(Thread.currentThread().getName() + " " + System.currentTimeMillis());
	}
}
