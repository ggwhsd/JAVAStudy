package DesignPattern.AdapterInterfaces;

///���ַ�ʽ�ǵ��ӿڷ����϶࣬����ÿ������ֻ���õ����м����ӿڣ����Խ�����г����࣬����ÿ�μ̳�ʵ�ָó����ֻ࣬Ҫ��д�Լ���Ҫ�Ľӿڼ��ɡ�
public class AdapterTest {

	public static void main(String[] args) {
		ISourceable s = new SourceSub1();
		s.method1();
		ISourceable s2 = new SourceSub2();
		s2.method1();
		

	}

}
