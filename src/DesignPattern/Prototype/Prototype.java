package DesignPattern.Prototype;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class Prototype implements Cloneable, Serializable{
	private static final long serialVersionUID = 1L;  
	private StringBuffer string;  
	private SerializableObject obj;  
	
	public Prototype()
	{
		string = new StringBuffer();
	}
	
	/* 浅复制 */  
	//必须声明Cloneable，才能使用clone()方法。
	public Object clone() throws CloneNotSupportedException {  
		Prototype proto = (Prototype) super.clone();  
		return proto;  
	}
	
	/* 深复制 */  
	public Object deepClone() throws IOException, ClassNotFoundException
	{
		 /* 写入当前对象的二进制流 */  
		//只有申明了Serializable接口，如下代码才能正确运行。
		//serialVersionUID用于确定当前类的版本唯一性，比如两个项目中都用到这个类，必须确保这个相同，否则无法正常反序列。
		ByteArrayOutputStream bos = new ByteArrayOutputStream();
		ObjectOutputStream oos = new ObjectOutputStream(bos);  
		oos.writeObject(this);  
		
		/* 读出二进制流产生的新对象 */  
		ByteArrayInputStream bis = new ByteArrayInputStream(bos.toByteArray()); 
		ObjectInputStream ois = new ObjectInputStream(bis); 
		return ois.readObject();  
	}
	
	public String getString() {  
		return string.toString();  
	}
	
	public void setString(String string) {  
		this.string.append(string);  
	}
	public SerializableObject getObj() {  
		return obj;  
	}
	public void setObj(SerializableObject obj) {  
		this.obj = obj;  
	}
	
}

class SerializableObject implements Serializable {  
	private static final long serialVersionUID = 1L;  
}
