package DesignPattern.MediatorPattern;

//�н��߽ӿ�,�е���������������·��
public interface IMediator {
	//ע�᷿�����߷���
	public void register(User user);
	//ת��������Ϣ
	public void relay(User user, String msg);
}
