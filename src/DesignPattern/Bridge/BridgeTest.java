package DesignPattern.Bridge;

public class BridgeTest {

	/*
	 * Brige���Բ�ͬ��MyBridge��Sourceable���Բ�ͬ��ʵ�֣�Brige��Sourceable��϶��ɣ�Bridge��Sourceable�ľ���̳л���ʵ�ֶ����Էֱ���б仯��������Ž�ģʽ���ص�ǿ�����߶����Ա仯��
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
