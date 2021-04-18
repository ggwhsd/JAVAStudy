package DesignPattern.MediatorPattern;

public class MediatorTest {

	/*
	 * �н���ģʽ��һ����������ģʽ��Ӧ�÷�Χ�ܹ㣬��������ģʽ�����ֱ�ӵ�����˵���������ض�л���ṹҲ�����ˣ�
	 * ���Ƕ���һЩ���ù�����Լ򵥵�������ԣ����ַ�ʽ���ԺܺõĽ���
	 * ͬʱҲ���Ժܶ�õ�ͳһ����ҵ���߼������緿���н顢������������������ȶ������ơ�
	 * 
	 * �н���ģʽ�У�����ҵ���߼����ַ������н����ϡ�
	 * ������һ������ģʽ������һ��һ�ĵ��ù�ϵ�����ǽ����ò����ȹ�ϵ�������Command�࣬������ֱ�ӵ��ã�����Ľ��
	 * ����ҵ���߼�����receiver��
	 * 
	 * */
	public static void main(String[] args) {
		//�����û�
		User solder = new SolderUser(1);
		User solder2 = new SolderUser(2);
		User buyer = new BuyerUser(3);
		User buyer2 = new BuyerUser(4);
		//�����н�
		IMediator mediator = new HouseMediator();
		//ע�ᵽ�м���
		mediator.register(solder);
		mediator.register(solder2);
		mediator.register(buyer);
		mediator.register(buyer2);
		//�û�������Ϣ
		solder.send(solder.getUserId()+" have a house : 10w RMB total.");
		buyer.send(buyer.getUserId() + " need a house : below 10w RMB total");
	}

}
