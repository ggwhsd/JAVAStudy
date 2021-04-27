package DesignPattern.Decorator;

public class Decorator2 implements Sourceable {

	private Sourceable source;  
	public Decorator2(Sourceable source)
	{
		super();  
		this.source = source;
	}
	@Override
	public void method(int i) {
		
		System.out.println("before decorator2!");  
		source.method(i);  
		System.out.println("after decorator2!");  
	}

}
