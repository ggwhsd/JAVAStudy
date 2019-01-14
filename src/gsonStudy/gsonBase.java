package gsonStudy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
class numberSpecial 
{

	int i;
	double j;
	//该注解可以使得实际输出的字段名为Address，
	@SerializedName("Address")  
	String str;
	
	boolean flag;
	public numberSpecial(int a, double b,String c,boolean d)
	{
		i = a;
		j = b;
		str = c;
		flag =d;
	}
	
}
public class gsonBase {

	/**
	 * json字符串转换为常见类型：int double String boolean
	 */
	public static void testfromJson()
	{
		Gson gson = new Gson();
	
		int number1 = gson.fromJson("999", int.class);
		double number2 = gson.fromJson("99.99", double.class);
		boolean number3 = gson.fromJson("true", boolean.class);
		String str = gson.fromJson("helloworld", String.class);
		numberSpecial number  = gson.fromJson("{\"i\":1,\"j\":2.2,\"Address\":\"test\",\"flag\":true}", numberSpecial.class);
	}
	/**
	 * POJO类转换为json
	 */
	public static void testObjectToJson()
	{
		Gson gson = new Gson();
		
		numberSpecial number = new numberSpecial(1,2.2,"test",true);
		String result = gson.toJson(number);
		System.out.println(result);
		
		numberSpecial number2 = gson.fromJson(result, numberSpecial.class);
		System.out.println(number2.i+" "+number2.j+" "+number2.str+" "+number.flag);
	}
	/**
	 * json格式的字符串，转换为数组
	 */
	public static void testArrayFromJson()
	{
		Gson gson = new Gson();
		String jsonArray = "[\"USD\",\"CNY\",\"GBP\"]";
		String [] strings = gson.fromJson(jsonArray, String[].class);
		for(int i=0; i< strings.length; i++)
		{
			System.out.println(strings[i]);
		}
	}
	/**
	 * 将list和map集合对象，转换为json格式的字符串。
	 */
	public static void toListJSON()
	{
		 List<numberSpecial> list = new ArrayList<>();
		 Map<String,numberSpecial> map = new HashMap<>();
		 numberSpecial number = new numberSpecial(3,3.3,"List",true);
		 list.add(number);
		 map.put("test1", number);
		 numberSpecial number2 = new numberSpecial(3,3.3,"List",true);
		 number2.i=4;
		 list.add(number2);
		 map.put("test2", number2);
		
		 
		Gson gson = new Gson();
		 System.out.println("List  json" + gson.toJson(list));
	     System.out.println("map json" + gson.toJson(map));
	     
	}
	/**
	 * 将json格式的字符串，转换为list和map集合对象。
	 * */
	public static void fromListJSON()
	{
		String jsonStr = "[{\"i\":3,\"j\":3.3,\"Address\":\"List\",\"flag\":true},{\"i\":4,\"j\":3.3,\"Address\":\"List\",\"flag\":true}]";
		Gson gson = new Gson();
		List<numberSpecial> list = gson.fromJson(jsonStr, new TypeToken<ArrayList<numberSpecial>>(){}.getType());
		for(int i=0; i< list.size(); i++)
		{
			numberSpecial number2 = list.get(i);
			System.out.println(number2.i+" "+number2.j+" "+number2.str+" "+number2.flag);
		}
	}
	public static void main(String[] args) {
		testfromJson();
		testObjectToJson();
		testArrayFromJson();
		toListJSON();
		fromListJSON();
	}

}
