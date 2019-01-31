package SingletonStudy;

/* 懒汉 + 同步 模式: 多线程安全，唯一的不好就是在于每次只能一个线程访问getinstance，因此不适合高并发的场景下频繁使用。
 * 
 */
public final class Singleton03 {
	private byte[] data = new byte[1024];
	private static Singleton03 instance = null;
	private Singleton03()
	{
		
	}
	public static synchronized Singleton03 getInstance()
	{
		if(null == instance)
			instance = new Singleton03();
		return instance;
	}
	public void print()
	{
		System.out.println(this.getClass().getName());
	}
	public static void main(String[] args) {
		

	}

}
