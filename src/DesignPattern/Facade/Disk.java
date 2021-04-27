package DesignPattern.Facade;

public class Disk {
	private int seq;
	public Disk(int i)
	{
		seq = i;
	}
	public void Start()
	{
		System.out.println("disk " + seq + "����");
	}
	public void Shutdown()
	{
		System.out.println("disk " + seq + "�ر�");
	}
}
