package DesignPattern.VisitorPattern;

public interface Visitor {
	//通过方法名来区分不同的访问逻辑。
	void visitElementA(Element concreteElementA);

	void visitElementB(Element concreteElementB);
}
