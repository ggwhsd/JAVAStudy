package baseAPI;

class Person
{
	private String name;
	private int age;
	public Person(String name, int age)
	{	
		this.name = name;
		this.age = age;
		
	}
	
	public String toString()
	{
		return "����" + this.name + "����"+ this.age;
	}
	
	public void finalize() throws Throwable
	{
		System.out.println("�����ͷ�");
	}
};
	
public class useSystem {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Person p = new Person("tom",9);
		System.out.println(p.toString());
		p = null;
		System.gc();
	}

}
