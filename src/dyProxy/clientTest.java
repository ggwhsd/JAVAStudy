package dyProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

//动态代理类的实现方式
public class clientTest {
	public static void  main(String[] args)
	{
		
		RealSubject subject = new RealSubject();
		
		InvocationHandler ih = new ProxySubject(subject);
		
		Class<?> clazz = subject.getClass();
		
		Subject sj = (Subject)Proxy.newProxyInstance(clazz.getClassLoader(), clazz.getInterfaces(), ih);
		
		sj.request();
		sj.show();
		
	}
}
