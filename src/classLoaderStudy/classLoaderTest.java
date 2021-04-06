package classLoaderStudy;

/*
 * jvm中内置的三大classloader的加载路径。
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