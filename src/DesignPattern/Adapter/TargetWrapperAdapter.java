package DesignPattern.Adapter;


//��Ϸ�ʽ��ʵ�֣����ַ�ʽһ��ʹ�ù�����ʹ�ø��ࡣ
public class TargetWrapperAdapter implements ITarget {

	private Source s;
	public TargetWrapperAdapter(Source ss)
	{
		s = ss;
	}
	@Override
	public void Method() {
		s.OldMethod();

	}

}
