package SingletonStudy;

/*
 * 懒汉模式：在初始化时不会创建instance，只有在getinstance使用时才会创建。不支持多线程安全。
 */
public final class Singleton02 {
	private byte[] data = new byte[1024];
	private static Singleton02 instance;
	private Singleton02()
	{
		
	}
	public static Singleton02 getInstance()
	{
		if(null == instance)
			instance = new Singleton02();
		return instance;
	}
	public void print()
	{
		System.out.println(this.getClass().getName());
	}
	public static void main(String[] args) {
		
		Singleton02.getInstance().print();
	}

}
