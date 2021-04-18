package DesignPattern.MediatorPattern;

import java.util.ArrayList;
import java.util.List;

//房屋中介
public class HouseMediator implements IMediator{
//此处示例，就两个类对象，可以扩展很多
	private List<User> landlords; //  房东
	private List<User> tenants; // 在找房的人
	public HouseMediator()
	{
		landlords = new ArrayList<User>();
		tenants = new ArrayList<User>();
	}
	//注册房东或者房客
		public void register(User user)
		{
			if(user.isBuyer()==true)
			{
				tenants.add(user);
				user.setMediator(this);
			}
			else
			{
				landlords.add(user);
				user.setMediator(this);
			}
		}
		
		public void relay(User user, String msg)
		{
			if(user.isBuyer()==true)
			{//转发买家发送的信息
				for(User solder : landlords)
				{
					solder.receive(msg);
				}
			}
			else
			{//转发房东发送的信息
				for(User buyer : tenants)
				{
					buyer.receive(msg);
				}
			}
		}
}
