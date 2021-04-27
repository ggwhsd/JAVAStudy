package DesignPattern.Decorator;

public class Source implements Sourceable {

	private int total;
	@Override
	public void method(int i) {
		total+=i;
		System.out.println("now total = "+total);

	}
	
	

}
