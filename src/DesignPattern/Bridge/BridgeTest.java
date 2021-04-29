package DesignPattern.Bridge;

public class BridgeTest {

	/*
	 * Brige可以不同的MyBridge，Sourceable可以不同的实现，Brige由Sourceable组合而成，Bridge和Sourceable的具体继承或者实现都可以分别进行变化，这就是桥接模式，重点强调两边都可以变化。
	 */
	public static void main(String[] args) {
		
		Sourceable source1 = new SourceSub1();  
		Bridge bridge = new MyBridge();  
		bridge.setSource(source1);  
		bridge.method();  
		
		Sourceable source2 = new SourceSub2();  
		bridge.setSource(source2);  
		bridge.method();  
	}

}
