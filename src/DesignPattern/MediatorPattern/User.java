package DesignPattern.MediatorPattern;

public abstract class User {
	private IMediator mediator;
	public void setMediator(IMediator mediator)
	{
		this.mediator = mediator;
	}
	
	public abstract void receive(String msg);
	
	public abstract void send(String msg);
	
}
