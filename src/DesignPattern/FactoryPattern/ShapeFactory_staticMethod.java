package DesignPattern.FactoryPattern;

public class ShapeFactory_staticMethod {
	public static Shape getCirle()
	{
		return new Cicle();
	}
	public static Shape getRectangle()
	{
		return new Rectangle();
	}
	public static Shape getSquare()
	{
		return new Square();
	}
	
}
