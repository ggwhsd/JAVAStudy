package DesignPattern.Decorator;

public class Decorator implements Sourceable {

	private Sourceable source;  
	public Decorator(Sourceable source)
	{
		super();  
		this.source = source;
	}
	@Override
	public void method(int i) {
		
		source.method(1);  
		System.out.println("before decorator!");  
		source.method(i);  
		System.out.println("after decorator!");  
	}

}
