package DesignPattern.MediatorPattern;

public class SolderUser extends User{

	public SolderUser(int id)
	{
		isBuyer = false;
		userId = id;
	}
	@Override
	public void receive(String msg) {
		System.out.println("我是卖家 Id="+userId+"，我收到了中介发来的买家的信息:"+msg);
		
		
	}

	@Override
	public void send(String msg) {
		System.out.println("我是卖家 Id="+userId+"，我发送了消息给中介:"+msg);
		mediator.relay(this, msg);
	}

}
