package DesignPattern.FactoryPattern;

public class ShapeFactory_MultiMedod {
	
	public Shape getCirle()
	{
		return new Cicle();
	}
	public Shape getRectangle()
	{
		return new Rectangle();
	}
	public Shape getSquare()
	{
		return new Square();
	}
	
	
}
