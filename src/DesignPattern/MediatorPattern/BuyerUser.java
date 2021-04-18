package DesignPattern.MediatorPattern;

public class BuyerUser extends User {

	public BuyerUser(int id)
	{
		isBuyer = true;
		userId = id;
	}
	@Override
	public void receive(String msg) {
		System.out.println("������� Id="+userId+"�����յ����н鷢�������ҵ���Ϣ:"+msg);
		//do something
		
	}

	@Override
	public void send(String msg) {
		System.out.println("������� Id=" + userId + "���ҷ�������Ϣ���н�:"+msg);
		mediator.relay(this, msg);
	}

}
