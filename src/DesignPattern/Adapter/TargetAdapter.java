package DesignPattern.Adapter;

///�̳�ԭʼ���ܵ��࣬��ʵ���µĽӿ�
public class TargetAdapter extends Source implements ITarget {

	@Override
	public void Method() {
		OldMethod();
	}

}
