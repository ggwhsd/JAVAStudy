package DesignPattern.Adapter;

public class AdapterTestOne {

	public static void main(String[] args) {
		ITarget t = new TargetAdapter();
		t.Method();

		
	}

}
