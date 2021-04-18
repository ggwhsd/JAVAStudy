package DesignPattern.MediatorPattern;

public class SolderUser extends User{

	public SolderUser(int id)
	{
		isBuyer = false;
		userId = id;
	}
	@Override
	public void receive(String msg) {
		System.out.println("�������� Id="+userId+"�����յ����н鷢������ҵ���Ϣ:"+msg);
		
		
	}

	@Override
	public void send(String msg) {
		System.out.println("�������� Id="+userId+"���ҷ�������Ϣ���н�:"+msg);
		mediator.relay(this, msg);
	}

}
