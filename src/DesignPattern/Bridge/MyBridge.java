package DesignPattern.Bridge;

public class MyBridge  extends Bridge {
	public void method(){  
		//Birdeg���Ա仯��SourceҲ���Ա��������߱仯��������������Ϻ͵��á����Ƕ�ʹ���߱���Bridge�������䡣
		System.out.println("Brige method call");
		getSource().method();  
	}
}
