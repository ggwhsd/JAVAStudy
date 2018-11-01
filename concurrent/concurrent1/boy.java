package concurrent1;

public class boy extends Thread{
	private toy mytoy;
	public boy(toy t)
	{
		mytoy = t;
	}
	public void run()
	{
		super.run();
		
		mytoy.write();
		mytoy.showHello();
		mytoy.paint();
		
	}
	
}
