package DesignPattern.Decorator;

public class DecoratorTest {

	public static void main(String[] args) {
		Sourceable s = new Source();
		Decorator d1 = new Decorator(s);
		Decorator2 d2 = new Decorator2(d1);
		s= d2;
		s.method(1);

	}

}
