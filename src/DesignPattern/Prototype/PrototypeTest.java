package DesignPattern.Prototype;

import java.io.IOException;

public class PrototypeTest {

	public static void main(String[] args) {
		Prototype p1 = new Prototype();
		
		p1.setString("aaa");
		Prototype p2 =null;
		try {
			p2 = (Prototype)p1.clone();
		} catch (CloneNotSupportedException e) {
			
			e.printStackTrace();
		}
		p1.setString("bbb");
		System.out.println(p1.getString());
		System.out.println(p2.getString());
		System.out.println("δʹ����ƣ�����p1��p2��Ȼ���������󣬵�������ȷʵʹ��ͬһ������");
		Prototype p3 =null;

		try {
			p3= (Prototype)p1.deepClone();
		} catch (ClassNotFoundException e) {
			
			e.printStackTrace();
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		
		p1.setString("ccc");
		System.out.println(p1.getString());
		System.out.println(p2.getString());
		System.out.println(p3.getString());
		System.out.println("p3ʹ����ƣ�����p3��һ��ȫ�µĻ���p1"
				+ "���ƵĶ���������һ���µ�����");

	}

}
