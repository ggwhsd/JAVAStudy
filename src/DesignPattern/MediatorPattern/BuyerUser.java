package DesignPattern.MediatorPattern;

public class BuyerUser extends User {

	public BuyerUser(int id)
	{
		isBuyer = true;
		userId = id;
	}
	@Override
	public void receive(String msg) {
		System.out.println("我是买家 Id="+userId+"，我收到了中介发来的卖家的信息:"+msg);
		//do something
		
	}

	@Override
	public void send(String msg) {
		System.out.println("我是买家 Id=" + userId + "，我发送了消息给中介:"+msg);
		mediator.relay(this, msg);
	}

}
