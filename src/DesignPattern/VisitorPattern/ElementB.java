package DesignPattern.VisitorPattern;

public class ElementB implements Element {

	@Override
	public void accept(Visitor visitor) {
		
		operation();
		visitor.visitElementB(this);
		
	}
	
	private void operation()
	{
		//doing some thing in elementB
	}
	
	
}
