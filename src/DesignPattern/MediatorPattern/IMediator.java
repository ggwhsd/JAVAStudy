package DesignPattern.MediatorPattern;

//中介者接口,有点类似容器，或者路由
public interface IMediator {
	//注册房东或者房客
	public void register(User user);
	//转发房东信息
	public void relay(User user, String msg);
}
