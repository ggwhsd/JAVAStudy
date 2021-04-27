package DesignPattern.Facade;

public class CPU {
	private int seq;
	public CPU(int i)
	{
		seq = i;
	}
	
	public void Start()
	{
		System.out.println("cpu"+ seq +"Æô¶¯");
	}
	public void Shutdown()
	{
		System.out.println("cpu"+ seq +"¹Ø±Õ");
	}
}


