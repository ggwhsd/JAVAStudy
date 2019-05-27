package DesignPattern.FactoryPattern;

public class usePattern {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ShapeFactory factory = new ShapeFactory();
		Shape shape1 = factory.getShape("CIRCLE");
		shape1.draw();
		Shape shape2 = factory.getShape("SQUARE");
		shape2.draw();
	}

}
