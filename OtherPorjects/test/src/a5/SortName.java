package a5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeSet;


class User
{
	public String name;
	public Integer value;
	public User(String name, Integer value)
	{
		this.name = name;
		this.value = value;
	}
	
	@Override
	public boolean equals(Object obj)
	{
		boolean result = super.equals(obj);
		return result;
	}
	
	
}

public class SortName {


	public void Deal() throws FileNotFoundException
	{
		Map results = new HashMap();
		FileInputStream ips = new FileInputStream("NameList.txt");
		BufferedReader in=null;
		try {
			in = new BufferedReader(new InputStreamReader(ips,"utf-8"));
		} catch (UnsupportedEncodingException e1) {
		
			e1.printStackTrace();
		}
		String line =null;
		try {
			while((line=in.readLine())!=null)
			{
				calc(line,results);
			}
			sort(results);
		}
		catch(IOException e)
		{
			
		}
	}
	
	public void sort(Map results)
	{
		TreeSet sortedResults = new TreeSet(new Comparator() {
			public int compare(Object o1, Object o2)
			{
				User user1 = (User)o1;
				User user2 = (User)o2;
				if(user1.value<user2.value)
				{
					return -1;
				}
				else if(user1.value > user2.value)
				{
					return 1;
				}
				else
				{
					return user1.name.compareTo(user2.name);
				}
			}
		});
		
		Iterator iterator= results.keySet().iterator();
		while(iterator.hasNext())
		{
			String name = (String)iterator.next();
			Integer value =(Integer)results.get(name);
			if(value >= 1)
			{
				sortedResults.add(new User(name,value));
			}
		}
		printResults(sortedResults);
	}
	
	private void printResults(TreeSet sortedResults)
	{
		Iterator iterator = sortedResults.iterator();
		while(iterator.hasNext())
		{
		User user = (User)iterator.next();
		System.out.println(user.name +":" + user.value);
		}
				
	}
	
	private void calc(String line,Map map)
	{
		if(!"".equals(line.trim()))
		{
			String [] results = line.split(",");
			if(results.length==3)
			{
				String name = results[1];
				Integer value = (Integer)map.get(name);
				if(value==null) value=0;
				map.put(name, value+1);
				
			}
		}
			
			
	}
}
