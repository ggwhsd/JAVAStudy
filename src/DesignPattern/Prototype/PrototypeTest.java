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
		System.out.println("未使用深复制，所以p1和p2虽然是两个对象，但是属性确实使用同一个引用");
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
		System.out.println("p3使用深复制，所以p3是一个全新的基于p1"
				+ "复制的对象，属性是一个新的引用");

	}

}
