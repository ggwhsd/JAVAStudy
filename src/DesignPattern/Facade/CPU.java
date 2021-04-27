package DesignPattern.Facade;

public class CPU {
	private int seq;
	public CPU(int i)
	{
		seq = i;
	}
	
	public void Start()
	{
		System.out.println("cpu"+ seq +"����");
	}
	public void Shutdown()
	{
		System.out.println("cpu"+ seq +"�ر�");
	}
}


