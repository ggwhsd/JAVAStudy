package DesignPattern.MediatorPattern;

import java.util.ArrayList;
import java.util.List;

//�����н�
public class HouseMediator implements IMediator{
//�˴�ʾ��������������󣬿�����չ�ܶ�
	private List<User> landlords; //  ����
	private List<User> tenants; // ���ҷ�����
	public HouseMediator()
	{
		landlords = new ArrayList<User>();
		tenants = new ArrayList<User>();
	}
	//ע�᷿�����߷���
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
			{//ת����ҷ��͵���Ϣ
				for(User solder : landlords)
				{
					solder.receive(msg);
				}
			}
			else
			{//ת���������͵���Ϣ
				for(User buyer : tenants)
				{
					buyer.receive(msg);
				}
			}
		}
}
