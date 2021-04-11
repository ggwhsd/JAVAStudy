package DesignPattern.VisitorPattern;

public class ElementA implements Element{

	
	@Override
	public void accept(Visitor visitor) {
		
		visitor.visitElementA(this);
	}

}
