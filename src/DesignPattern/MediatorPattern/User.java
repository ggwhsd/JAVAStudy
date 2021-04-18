package DesignPattern.MediatorPattern;

public abstract class User {
	protected IMediator mediator;
	protected boolean isBuyer;
	protected int userId;
	
	public void setMediator(IMediator mediator)
	{
		this.mediator = mediator;
	}
	public void setUserType(boolean isBuyer)
	{
		this.isBuyer = isBuyer;
	}
	public int getUserId()
	{
		return userId;
	}
	public boolean isBuyer()
	{
		return isBuyer;
	}
	
	public abstract void receive(String msg);
	
	public abstract void send(String msg);
	
}
