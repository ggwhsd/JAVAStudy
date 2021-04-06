package DesignPattern.SigletonPattern;


/*
 * 饿汉模式,可以保证多个线程下的唯一实例�?
 */
public final class Singleton01 {

	private byte[] data = new byte[1024];
	private static Singleton01 instance = new Singleton01();
	private Singleton01() {};
	public static Singleton01 getInstance()
	{
		return instance;
	}
	public void print()
	{
		System.out.println(this.getClass().getName());
	}
	public static void main(String[] args) {
		Singleton01.getInstance().print();;

	}

}
