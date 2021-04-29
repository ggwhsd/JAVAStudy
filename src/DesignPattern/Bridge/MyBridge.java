package DesignPattern.Bridge;

public class MyBridge  extends Bridge {
	public void method(){  
		//Birdeg可以变化，Source也可以变量，两者变化可以做出各种组合和调用。但是对使用者保持Bridge方法不变。
		System.out.println("Brige method call");
		getSource().method();  
	}
}
