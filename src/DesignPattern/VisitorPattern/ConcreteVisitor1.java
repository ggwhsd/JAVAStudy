package DesignPattern.VisitorPattern;

public class ConcreteVisitor1 implements Visitor {

	@Override
	public void visitElementA(Element concreteElementA) {
		System.out.println(concreteElementA.getClass().getName() + " 被 " + this.getClass().getName() + " 访问");
		
	}

	@Override
	public void visitElementB(Element concreteElementB) {

		System.out.println(concreteElementB.getClass().getName() + " 被 " + this.getClass().getName() + " 访问");
		
		
	}

}
