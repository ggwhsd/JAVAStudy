package DesignPattern.Adapter;


//组合方式的实现，这种方式一般使用过程中使用更多。
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
