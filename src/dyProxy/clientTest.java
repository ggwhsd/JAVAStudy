package dyProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

//动态代理类的实现方式：对原有业务类没有任何影响。
public class clientTest {
	public static void  main(String[] args)
	{
		
		RealSubject subject = new RealSubject();
		//创建一个对应的代理类，实现具体的代理功能
		InvocationHandler ih = new ProxySubject(subject);
		
		Class<?> clazz = subject.getClass();
		//创建动态代理对象，并将其转换到具体类的接口上，然后通过调用接口方法，就可以看到效果了。 
		Subject sj = (Subject)Proxy.newProxyInstance(clazz.getClassLoader(), clazz.getInterfaces(), ih);
		
		sj.request();
		sj.show();
		
	}
}
