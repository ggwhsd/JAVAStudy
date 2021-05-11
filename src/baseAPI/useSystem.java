package baseAPI;


//调用垃圾回收，观看finalize()方法调用
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
		return "姓名" + this.name + "年龄"+ this.age;
	}
	
	public void finalize() throws Throwable
	{
		System.out.println("对象被释放");
	}
};
	
public class useSystem {

	public static void main(String[] args) {
		Person p = new Person("tom",9);
		System.out.println(p.toString());
		p = null;
		System.gc();
	}
}
