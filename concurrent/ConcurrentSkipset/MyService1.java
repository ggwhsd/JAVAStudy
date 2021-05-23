package ConcurrentSkipset;

import java.util.concurrent.ConcurrentSkipListSet;
/*
 * ConcurrentSkipListSet是线程安全的有序的集合。
   ConcurrentSkipListSet和TreeSet，它们都是有序的集合。
	区别 ：
		第一，TreeSet是非线程安全的，而ConcurrentSkipListSet是线程安全的。
		第二，ConcurrentSkipListSet是通过ConcurrentSkipListMap实现的，而TreeSet是通过TreeMap实现的。
    Userinfo 需要重载equals方便判断是否相等，hashcode方便进行hash计算，当然也可以用默认的hashcode。
 */
public class MyService1 {
	public ConcurrentSkipListSet<Userinfo> map = new ConcurrentSkipListSet();
	
	public MyService1(){
		Userinfo userinfo1 = new Userinfo(1,"username1");
		Userinfo userinfo3 = new Userinfo(3,"username3");
		Userinfo userinfo5 = new Userinfo(5,"username5");
		Userinfo userinfo4 = new Userinfo(4,"username4");
		Userinfo userinfo2 = new Userinfo(1,"username2");
		map.add(userinfo1);
		map.add(userinfo2);
		map.add(userinfo3);
		map.add(userinfo4);
		map.add(userinfo5);
		
	}
	
}
