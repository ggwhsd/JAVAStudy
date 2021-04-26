package DesignPattern.Adapter;

///继承原始功能的类，并实现新的接口
public class TargetAdapter extends Source implements ITarget {

	@Override
	public void Method() {
		OldMethod();
	}

}
