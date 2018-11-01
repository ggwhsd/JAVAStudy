package dyProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class ProxySubject implements InvocationHandler {

	private Object object;
	public ProxySubject(Object object){
		this.object = object;
		
	}
	public Object invoke(Object proxy, Method method, Object[] args)
	throws Throwable
	{
		System.out.println("pre do something");
		method.invoke(object, args);
		System.out.println("post do something");
		
		return null;
	}
}
