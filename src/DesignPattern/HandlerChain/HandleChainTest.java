package DesignPattern.HandlerChain;

public class HandleChainTest {

	public static void main(String[] args) {
		MyHandler h1 = new MyHandler("h1");
		MyHandler h2 = new MyHandler("h2");
		h2.setHandler(h1);
		
		h2.operator();

	}

}
