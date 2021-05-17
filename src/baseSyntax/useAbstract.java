package baseSyntax;

//抽象类的使用，复用功能。
abstract class Person {
	public Person()
	{
		System.out.println("construct person");
	}
	public void run1(){};
	public void run2(){};
	public abstract void abstractRun1();
}

class Chinese extends Person {
	public Chinese()
	{
		System.out.println("construct Chinese");
		
	}
	//多态
	public void run1(){ 
		System.out.println("Chinese run1");
	}

	public void abstractRun1(){
		System.out.println("chinese abstractRun1");
	}
}

public class useAbstract {

	public static void main(String[] args) {
		
		Person p = new Chinese();
		p.run1();
		p.run2();
		p.abstractRun1();
		
	}

}
