package DesignPattern.Flyweight;

import java.util.HashMap;
import java.util.Map;

/*
 * �൱��һ���������ӣ�SpecificFlyweight�൱��һ����������е�ʹ�ö���
 */
public class FlyweightFactory {
	public Map<String, SpecificFlyweight> keyValuePairs = new HashMap<String, SpecificFlyweight>();
	public SpecificFlyweight GetFlyweight(String Key) 
    {
        SpecificFlyweight specific = null;
        if (!keyValuePairs.containsKey(Key))
        {
            System.out.println("��ʱδ������Key");
            keyValuePairs.put(Key, new SpecificFlyweight(Key));
            specific =keyValuePairs.get(Key);
            System.out.println("���ѱ����Key"); 
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
