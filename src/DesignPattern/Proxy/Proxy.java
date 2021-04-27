package DesignPattern.Proxy;

public class Proxy implements Sourceable{
	private Source source;  
	public Proxy()
	{
		source = new Source();
	}
	@Override
	public void method() {
		System.out.println("before proxy!");  
		source.method();
		System.out.println("after proxy!");  
	}
	
}
