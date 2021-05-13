package classLoader;

import java.lang.reflect.InvocationTargetException;

public class LoaderTest {

	public String ShowHello()
	{
		return "hello";
	}
	public static void main(String[] args) {
		
		System.out.println(System.getProperty("java.ext.dirs"));
		System.out.println(ClassLoader.getSystemClassLoader());
		System.out.println(LoaderTest.class.getClassLoader());
		System.out.println(ClassLoader.getSystemClassLoader().getParent());
		System.out.println(ClassLoader.getSystemClassLoader().getParent().getParent());
		System.out.println(System.getProperty("java.class.path"));
		
		//case 01 ��//ʹ��ϵͳ��appclassloader�࣬����Ӧ�ó����µ��ļ���������ʱ��̬�����һ�����ļ������ֲ���Ҫ������������������ʹ�����ַ�����
		ClassLoader loader = LoaderTest.class.getClassLoader();
		try {
            
            Class testClass = loader.loadClass("classLoader.LoaderTest");

            System.out.println(testClass.getClassLoader());
            // ת��Ϊ��Ӧ���ʵ��
            LoaderTest testInstance = (LoaderTest) testClass.newInstance();
            // ���÷���
            System.out.println("hello = "+testInstance.ShowHello());
            
            
            
            
        }catch (Exception e){
            e.printStackTrace();
        }
		
		//case 02 �� ָ���Զ��������������ص���
		int icount=0;
		while(true) {
			icount++;
			try {
				Thread.sleep(1000);
				System.out.println("�ȼ����� "+icount);
			} catch (InterruptedException e1) {
				
				e1.printStackTrace();
			}
        MyClassLoader classLoader = new MyClassLoader();
        try {
        	Class test = classLoader.loadClass("Test");
			try {
				classLoader.loadClass("Test").getMethod("test").invoke(test.newInstance());
			} catch (InstantiationException e) {
				
				e.printStackTrace();
			}
		} catch (IllegalAccessException e) {
			
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			
			e.printStackTrace();
		} catch (SecurityException e) {
			
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			
			e.printStackTrace();
		}
		}
	}

}
