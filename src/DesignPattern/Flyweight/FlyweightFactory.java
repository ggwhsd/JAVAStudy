package DesignPattern.Flyweight;

import java.util.HashMap;
import java.util.Map;

/*
 * 相当于一个容器池子，SpecificFlyweight相当于一个具体池子中的使用对象。
 */
public class FlyweightFactory {
	public Map<String, SpecificFlyweight> keyValuePairs = new HashMap<String, SpecificFlyweight>();
	public SpecificFlyweight GetFlyweight(String Key) 
    {
        SpecificFlyweight specific = null;
        if (!keyValuePairs.containsKey(Key))
        {
            System.out.println("暂时未遇见该Key");
            keyValuePairs.put(Key, new SpecificFlyweight(Key));
            specific =keyValuePairs.get(Key);
            System.out.println("现已保存该Key"); 
        }
        else
        {
             specific =keyValuePairs.get(Key);
        }
        return specific;
    }
	public int getCount()
	{
		return keyValuePairs.keySet().size();
	}
}
