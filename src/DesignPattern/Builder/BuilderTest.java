package DesignPattern.Builder;

public class BuilderTest {

	/*
	 * 建造者主要目的是方便频繁创建复杂对象，如果一个对象很简单，不要使用建造者，如果一个或者多个对象里面设计配置项很多，而且会有各种分支判断，这种复杂的对象，才需要使用使用创建者模式机型简化。
	   当对象简单时，它可工厂模式基本一样。
	   设计模式，本质上是一种设计思维，实现方式无需具体某种方式，只要满足设计思维即可。
	 */
	public static void main(String[] args) {
		ComputerBuilder cb = new CustomComputerBuilder();
		
		ComputerProduct cp =cb.cpu("h")
		.mem("32g")
		.gpu(true)
		.hardDisk("1T")
		.Build();
		System.out.println(cp.toString());
		
		
		cb = new HighComputerBuilder();
		cp = cb.Build();
		System.out.println(cp.toString());

	}

}
