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
	
	/* ǳ���� */  
	//��������Cloneable������ʹ��clone()������
	public Object clone() throws CloneNotSupportedException {  
		Prototype proto = (Prototype) super.clone();  
		return proto;  
	}
	
	/* ��� */  
	public Object deepClone() throws IOException, ClassNotFoundException
	{
		 /* д�뵱ǰ����Ķ������� */  
		//ֻ��������Serializable�ӿڣ����´��������ȷ���С�
		//serialVersionUID����ȷ����ǰ��İ汾Ψһ�ԣ�����������Ŀ�ж��õ�����࣬����ȷ�������ͬ�������޷����������С�
		ByteArrayOutputStream bos = new ByteArrayOutputStream();
		ObjectOutputStream oos = new ObjectOutputStream(bos);  
		oos.writeObject(this);  
		
		/* �������������������¶��� */  
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
