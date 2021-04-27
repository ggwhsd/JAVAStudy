package DesignPattern.Facade;

public class Disk {
	private int seq;
	public Disk(int i)
	{
		seq = i;
	}
	public void Start()
	{
		System.out.println("disk " + seq + "Æô¶¯");
	}
	public void Shutdown()
	{
		System.out.println("disk " + seq + "¹Ø±Õ");
	}
}
