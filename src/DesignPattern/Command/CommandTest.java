package DesignPattern.Command;

public class CommandTest {

	public static void main(String[] args)
	{
		//��ϣ�û��һ�������߸��룬��Ͼ���һ�ݣ����Ǹ��ӶȾͶ�һ�ݡ�
		Receiver receiver = new Receiver();  
		Command cmd = new MyCommand(receiver);
		Invoker invoker = new Invoker(cmd);
		invoker.action();
	}
}
