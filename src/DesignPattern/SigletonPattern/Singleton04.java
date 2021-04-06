package DesignPattern.SigletonPattern;

/*
 * double check : 原理跟懒�?+同步模式差不多，只是synchronized不放在方法上，�?�是放在具体代码块中，使得可以多个线程同时访问�??
 */
public final class Singleton04 {

	private byte[] data = new byte[1024];
	private static Singleton04 instance = null;
	private Singleton04()
	{
		
	}
	public static Singleton04 getInstance()
	{
		if(null == instance)
			synchronized(Singleton04.class)
			{
				if(null == instance)
					instance = new Singleton04();
			}
		return instance;
	}
	public void print()
	{
		System.out.println(this.getClass().getName());
	}
	public static void main(String[] args) {
		

	}

}
