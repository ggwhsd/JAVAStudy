package baseSyntax;

abstract class Person {
	public Person()
	{
		System.out.println("person");
	}
	public void run1(){};
	public void run2(){};
	public abstract void abstractRun1();
}

class Chinese extends Person {
	public Chinese()
	{
		System.out.println("xx");
		
	}
	public void run1(){}

	public void abstractRun1(){
		System.out.println("chinese");
	}
}

public class useAbstract {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Person p = new Chinese();
		p.run1();
		p.run2();
		p.abstractRun1();
		
	}

}
