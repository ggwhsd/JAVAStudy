package ConcurrentSkipset;

import java.util.concurrent.ConcurrentSkipListSet;
/*
 * ConcurrentSkipListSet���̰߳�ȫ������ļ��ϡ�
   ConcurrentSkipListSet��TreeSet�����Ƕ�������ļ��ϡ�
	���� ��
		��һ��TreeSet�Ƿ��̰߳�ȫ�ģ���ConcurrentSkipListSet���̰߳�ȫ�ġ�
		�ڶ���ConcurrentSkipListSet��ͨ��ConcurrentSkipListMapʵ�ֵģ���TreeSet��ͨ��TreeMapʵ�ֵġ�
    Userinfo ��Ҫ����equals�����ж��Ƿ���ȣ�hashcode�������hash���㣬��ȻҲ������Ĭ�ϵ�hashcode��
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
