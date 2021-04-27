package DesignPattern.Facade;

//外观模式，主要是将多个子系统功能统一为简单的调用接口，类似于门户网站
public class FacadeTest {

	public static void main(String[] args) {
		Computer c = new Computer(2,3,3);
		c.Start();
		c.Shutdown();
		c.StartCPU();
		c.ShutdownCPU();

	}

}
