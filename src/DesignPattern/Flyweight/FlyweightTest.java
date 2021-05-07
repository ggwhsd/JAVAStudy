package DesignPattern.Flyweight;

/*
 * 就是线程池的模式
 */
public class FlyweightTest {

	public static void main(String[] args) {
		FlyweightFactory factory = new FlyweightFactory();
		factory.GetFlyweight("A").OutInput(1);
		factory.GetFlyweight("A").OutInput(1);
		System.out.println(factory.getCount());
		
		factory.GetFlyweight("B").OutInput(1);
		System.out.println(factory.getCount());

	}

}
