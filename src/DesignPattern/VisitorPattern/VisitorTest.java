package DesignPattern.VisitorPattern;

public class VisitorTest {

	public static void main(String[] args) {
		Context c = new Context();
		c.attach(new ElementA());
		c.attach(new ElementB());
		c.accept(new ConcreteVisitor1());
		
	}

}
