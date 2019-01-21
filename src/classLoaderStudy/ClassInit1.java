package classLoaderStudy;

/*
 * 类的主动使用，会第一次调用类的初始化。
 * 主动使用有6个主要场景。
 */

/*
 * 1.通过调用静态变量会导致类的初始化。 但是若是静态常量，则不会。
 */
class Init01
{
	//静态代码块，另外可以看下java中四种初始化方式的顺序：静态方法、静态代码块、构造函数，静态变量。
	static
	{
		System.out.println("init01 inited");
	}
	public static int x =1;
	public final static int c = 1;
}
/*
 * 2.调用静态方法，会导致类的初始化过程
 */
class Init02
{
	static 
	{
		System.out.println("init02 inited");
	}
	public static void test()
	{
		System.out.println("Init 02 test()");
	}
}
/*
 * 3.调用class.forName
 */
class Init03
{
	//会初始化Init01
	public static void classForName()
	{
		try {
			Class.forName("classLoaderStudy.Init01");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
}

/*4. 调用子类会导致父类初始化，但是如果只是通过子类调用父内的静态方法后者变量，则不会导致子类初始化。
 * 
 */
class Init04_parent
{
	static 
	{
		
		System.out.println("Init04_parent");
	}
	public static int y = 1;
}

class Init04_child extends Init04_parent
{
	static 
	{
		System.out.println("Init04_child");
	}
	public static int z = 2;
}

/*5.调用main方法的类也会被初始化
 * 
 */
public class ClassInit1 {

	static
	{
		System.out.println("init05 ");
	}
	public static void main(String[] args) {
		//System.out.print(Init01.c);    //init05   1
		//System.out.print(Init01.x);   //init05   init01 inited 1
		//Init02.test();  //init05  init02 inited  init 02 test()
		//Init03.classForName();  //init05 init01 inited
		//System.out.print(Init04_child.y);    //init05 Init04_parent 1
		//System.out.print(Init04_child.z);  //init05 Init04_parent Init04_child 2
		init06.newTest();   //init05 init01 inited
	}

}
/*
 * 6.调用 new关键字，必然会进行类的初始化，但是数组除外。
 */
class init06
{
	public static void newTest()
	{
		Init01  init01= new Init01();
		
	}
}