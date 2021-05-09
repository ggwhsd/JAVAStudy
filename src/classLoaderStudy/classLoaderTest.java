package classLoaderStudy;

/*
 * jvm中内置的三大classloader的加载路径。
 * 三者顺序：1. Bootstrap CLassloder
		  2. Extention ClassLoader
          3. AppClassLoader
          默认所有的客户自己开发的类都是通过appClassLoader加载管理，如果自己想定制化加载，可以自己开发应用加载类作为补充。
 */
public class classLoaderTest {

	public static void bootStrapStudy()
	{
		System.out.println("***bootstrap ClassLoader");
		System.out.println(String.class.getClassLoader());
		System.out.println(System.getProperty("sun.boot.class.path"));
		System.out.println();
	}
	public static void extStudy()
	{
		System.out.println("***ext ClassLoader");
		System.out.println(System.getProperty("java.ext.dirs"));
		System.out.println();
	}
	public static void ApplicationStudy()
	{
		System.out.println("***app ClassLoader");
		System.out.println(System.getProperty("java.class.path"));
		System.out.println(classLoaderTest.class.getClassLoader());
		System.out.println();
	}
	public static void main(String[] args) {
		bootStrapStudy();
		extStudy();
		ApplicationStudy();
	}

}
