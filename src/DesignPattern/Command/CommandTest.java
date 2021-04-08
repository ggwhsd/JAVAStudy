package DesignPattern.Command;

public class CommandTest {

	public static void main(String[] args)
	{
		//耦合，没多一层抽象或者隔离，耦合就少一份，但是复杂度就多一份。
		Receiver receiver = new Receiver();  
		Command cmd = new MyCommand(receiver);
		Invoker invoker = new Invoker(cmd);
		invoker.action();
	}
}
