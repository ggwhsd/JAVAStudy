package firstThreadStudy;

public class MtThread1 implements Runnable {
	@Override
	public void run()
	{
		System.out.println("run " + Thread.currentThread().isAlive());
	}
}
