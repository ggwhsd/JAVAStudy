package DesignPattern.MediatorPattern;

public class MediatorTest {

	/*
	 * 中介者模式，一种星型网络模式，应用范围很广，但是这种模式相对于直接调用来说，代码量回多谢，结构也复杂了，
	 * 但是对于一些调用规则相对简单的情况而言，这种方式可以很好的解耦
	 * 同时也可以很多好的统一更新业务逻辑。比如房产中介、交易所撮合买卖订单等都很类似。
	 * 
	 * 中介者模式中，调用业务逻辑部分放在了中介者上。
	 * 另外有一个命令模式，其是一对一的调用关系。且是将调用参数等关系抽象成了Command类，减少了直接调用，变相的解耦。
	 * 但是业务逻辑是在receiver。
	 * 
	 * */
	public static void main(String[] args) {
		//创建用户
		User solder = new SolderUser(1);
		User solder2 = new SolderUser(2);
		User buyer = new BuyerUser(3);
		User buyer2 = new BuyerUser(4);
		//创建中介
		IMediator mediator = new HouseMediator();
		//注册到中间中
		mediator.register(solder);
		mediator.register(solder2);
		mediator.register(buyer);
		mediator.register(buyer2);
		//用户发送消息
		solder.send(solder.getUserId()+" have a house : 10w RMB total.");
		buyer.send(buyer.getUserId() + " need a house : below 10w RMB total");
	}

}
