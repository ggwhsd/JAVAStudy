package DesignPattern.Facade;

public class Memory {
	private int seq;
	public Memory(int i)
	{
		seq = i;
	}
	public void Start()
	{
		System.out.println("memory"+seq+"����");
	}
	public void Shutdown()
	{
		System.out.println("memory"+seq+"�ر�");
	}
}
