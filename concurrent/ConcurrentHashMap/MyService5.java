package ConcurrentHashMap;

import java.util.concurrent.ConcurrentHashMap;

public class MyService5 {

	public ConcurrentHashMap map = new ConcurrentHashMap();
	public MyService5()
	{
		for (int i = 0; i< 5; i++)
		{
			map.put("key"+(i+1), "value"+(i+1));
		}
	}
}
