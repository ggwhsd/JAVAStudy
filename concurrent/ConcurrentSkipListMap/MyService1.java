package ConcurrentSkipListMap;

import java.util.concurrent.ConcurrentSkipListMap;

public class MyService1 {
	/*
	 * ConcurrentSkipListMap 支持更高的并发。ConcurrentSkipListMap 的存取时间是log（N），和线程数几乎无关
	   数据需要实现Comparable接口，以便顺序。
	 */
	public ConcurrentSkipListMap<Userinfo, String> map = new ConcurrentSkipListMap();
	public MyService1()
	{
		Userinfo userinfo1 = new Userinfo(1,"username1");
		Userinfo userinfo3 = new Userinfo(3,"username3");
		Userinfo userinfo5 = new Userinfo(5,"username5");
		Userinfo userinfo4 = new Userinfo(4,"username4");
		Userinfo userinfo2 = new Userinfo(2,"username2");
		map.put(userinfo1, "value1");
		map.put(userinfo2, "value2");
		map.put(userinfo3, "value3");
		map.put(userinfo4, "value4");
		map.put(userinfo5, "value5");
	}
}
