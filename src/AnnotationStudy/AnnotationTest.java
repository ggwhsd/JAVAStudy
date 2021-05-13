package AnnotationStudy;

import java.lang.reflect.Method;
import java.util.HashSet;
import java.util.Set;


public class AnnotationTest {

	public static void main(String[] args) {
		
		//��ȡע��Description���ֶ�
		String CLASS_NAME = "AnnotationStudy.CaseJava";
		Class test = null;
		try {
			test = Class.forName(CLASS_NAME);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		Method[] method = test.getMethods();
		//������Ϣ���ж��Ƿ���ĳ��ע��
		boolean flag = test.isAnnotationPresent(Description.class);
		if (flag) {
			//��ȡע�����
            Description des = (Description) test.getAnnotation(Description.class);
            System.out.println("ע��Description������:" + des.value());
            System.out.println("-----------------");
        }
		Set<Method> set = new HashSet<Method>();
		for (int i = 0; i < method.length; i++) {
			//��ȡ�෽����Ϣ���ж��Ƿ���ע��
			boolean otherFlag = method[i].isAnnotationPresent(Name.class);
			if (otherFlag)
                set.add(method[i]);	
		}
		for (Method m : set) {
			//�ӷ����ϻ�ȡע�����
            Name name = m.getAnnotation(Name.class);
            System.out.println(name.originate());
            System.out.println("������;:" + name.community());
        }
		
	}

}
