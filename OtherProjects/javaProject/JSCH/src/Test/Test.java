package Test;
import java.lang.reflect.Field;

class demoBean1
{
	public String str1;
	public int int1;
	public boolean bool1;
	public demoBean1(String a, int b, boolean c)
	{
		str1 = a;
		int1 = b;
		bool1 = c;
	}
	
};
	

public class Test {
	public static void demo1()
	{
		demoBean1 db1 = new demoBean1("1",32,false);
		Field field1 = null;
		Field[] fields = db1.getClass().getFields();
		try {
			field1 = db1.getClass().getField("str1");
			System.out.println("field1 str1="+field1.get(db1));
			
			field1 = db1.getClass().getField("int1");
			System.out.println("field2 int1="+field1.getInt(db1));
			
			for(Field field : fields)
			{
				if(field.getType() == String.class)
				{
					String oldValue = (String)field.get(db1);
					String newValue = oldValue.replace('1','2');
					field.set(db1, newValue);
				}
				if(field.getType()== int.class)
				{
					int oldValue = (int)field.get(db1);
					int newValue = 23;
					field.set(db1, newValue);
				}
			}
			
			field1 = db1.getClass().getField("str1");
			System.out.println("field1 str1="+field1.get(db1));
			
			field1 = db1.getClass().getField("int1");
			System.out.println("field2 int1="+field1.getInt(db1));
			
			
		}
		catch(Exception e)
		{
			System.out.println("exception="+e.getMessage());
		}
		
	}

	
	public static void demo2_1(long value)
	{
		System.out.println(value);
	}
	public static void demo2_2()
	{
		demo2_1(1);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		demo2_2();
		
	}

}
