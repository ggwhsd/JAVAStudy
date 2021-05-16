package classLoaderStudy;

import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Method;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class MyClassLoader extends ClassLoader{

	
	private final static Path DEFAULT_CLASS_DIR = Paths.get("E:", "classloader1");
	
	private final Path classDir;
	
	public MyClassLoader()
	{
		super();
		this.classDir = DEFAULT_CLASS_DIR;
		
	}
	public MyClassLoader(String classDir)
	{
		super();
		this.classDir = Paths.get(classDir);
	}
	
	public MyClassLoader(String classDir,ClassLoader parent)
	{
		super(parent);
		this.classDir = Paths.get(classDir);
	}
	
	///方法1：从文件中读取字节流
	private byte[] readClassBytes(String name)
	throws ClassNotFoundException
	{
		String classPath = name.replace(".", "/");
		Path classFullPath = classDir.resolve(Paths.get(classPath+".class"));
		if(!classFullPath.toFile().exists())
		{
			throw new ClassNotFoundException("The Class "+name+" not found");
		}
		try(ByteArrayOutputStream baos = new ByteArrayOutputStream())
		{
			Files.copy(classFullPath, baos);
			return baos.toByteArray();
		}
		catch(IOException e)
		{
			throw new ClassNotFoundException("Load the class "+  name +" occur error.",e);
		}
	}
	
	///方法2：从文件流读取到字节流中
		private byte[] getClassData(String path) {
	        try (InputStream ins = new FileInputStream(path);
	             ByteArrayOutputStream baos = new ByteArrayOutputStream()
	        ) {

	            int bufferSize = 4096;
	            byte[] buffer = new byte[bufferSize];
	            int bytesNumRead = 0;
	            while ((bytesNumRead = ins.read(buffer)) != -1) {
	                baos.write(buffer, 0, bytesNumRead);
	            }
	            return baos.toByteArray();
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	        return null;
	    }
	
	@Override
	/*
	 * (non-Javadoc)
	 * @see java.lang.ClassLoader#findClass(java.lang.String)
	 * 必须要重写这个类
	 */
	protected Class<?> findClass(String name) throws ClassNotFoundException
	{
		byte[] classBytes = this.readClassBytes(name);
		if(null == classBytes || classBytes.length == 0)
		{
			throw new ClassNotFoundException("can not load the class ");
		}
		return this.defineClass(name, classBytes, 0,classBytes.length);
	}
	
	@Override
	public String toString()
	{
		return "My ClassLoader";
	}
	public static void main(String[] args) {
		
		
		
		MyClassLoader classLoader = new MyClassLoader();
		Class<?> aClass  =null;
		try {
		    aClass = classLoader.loadClass("classLoaderStudy.ClassLoaderHello");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		System.out.println(aClass.getClassLoader());
		try {
			Object helloWorld = aClass.newInstance();
			System.out.println(helloWorld);
			Method welcomeMethod = aClass.getMethod("welcome");
			String result = (String) welcomeMethod.invoke(helloWorld);
			System.out.println(result);
			
		} catch (InstantiationException e) {
		
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			
			e.printStackTrace();
		}catch (Exception e)
		{
			e.printStackTrace();
		}
		
	}

}
