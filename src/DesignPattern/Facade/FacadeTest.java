package DesignPattern.Facade;

//���ģʽ����Ҫ�ǽ������ϵͳ����ͳһΪ�򵥵ĵ��ýӿڣ��������Ż���վ
public class FacadeTest {

	public static void main(String[] args) {
		Computer c = new Computer(2,3,3);
		c.Start();
		c.Shutdown();
		c.StartCPU();
		c.ShutdownCPU();

	}

}
