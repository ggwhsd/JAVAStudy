package classLoader;

import java.lang.reflect.InvocationTargetException;

public class LoaderTest {

	public String ShowHello()
	{
		return "hello";
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(System.getProperty("java.ext.dirs"));
		System.out.println(ClassLoader.getSystemClassLoader());
		System.out.println(LoaderTest.class.getClassLoader());
		System.out.println(ClassLoader.getSystemClassLoader().getParent());
		System.out.println(ClassLoader.getSystemClassLoader().getParent().getParent());
		System.out.println(System.getProperty("java.class.path"));
		
		ClassLoader loader = LoaderTest.class.getClassLoader();
		try {
            //使用系统的appclassloader类，加载应用程序下的文件，比如有时候动态添加了一个类文件，但又不需要程序重新启动，可以使用这种方法。
            Class testClass = loader.loadClass("classLoader.LoaderTest");

            System.out.println(testClass.getClassLoader());
            // 转化为对应类的实例
            LoaderTest testInstance = (LoaderTest) testClass.newInstance();
            // 调用方法
            System.out.println("hello = "+testInstance.ShowHello());
            
            
            
            
        }catch (Exception e){
            e.printStackTrace();
        }
		
		// 指定类加载器加载调用
		int icount=0;
		while(true) {
			icount++;
			try {
				Thread.sleep(1000);
				System.out.println("热加载类 "+icount);
			} catch (InterruptedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
        MyClassLoader classLoader = new MyClassLoader();
        try {
        	Class test = classLoader.loadClass("Test");
			try {
				classLoader.loadClass("Test").getMethod("test").invoke(test.newInstance());
			} catch (InstantiationException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}
	}

}
