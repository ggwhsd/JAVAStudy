package DesignPattern.AdapterInterfaces;

///这种方式是当接口方法较多，但是每次适配只会用到其中几个接口，所以将其进行抽象类，这样每次继承实现该抽象类，只要填写自己想要的接口即可。
public class AdapterTest {

	public static void main(String[] args) {
		ISourceable s = new SourceSub1();
		s.method1();
		ISourceable s2 = new SourceSub2();
		s2.method1();
		

	}

}
