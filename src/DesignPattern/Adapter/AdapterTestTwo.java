package DesignPattern.Adapter;

public class AdapterTestTwo {

	public static void main(String[] args) {
		Source s = new Source();
		ITarget t = new TargetWrapperAdapter(s);
		t.Method();

	}

}
