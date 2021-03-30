package test;
import java.lang.reflect.Method;
import java.util.HashSet;
import java.util.Set;

import gugw.Description;
import gugw.Name;
public class TestAnnotation {

	public static void main(String[] args) {
		
		//��ȡע��Description���ֶ�
		String CLASS_NAME = "gugw.JavaEyer";
		Class test = null;
		try {
			test = Class.forName(CLASS_NAME);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Method[] method = test.getMethods();
		//������Ϣ���ж��Ƿ���ע��
		boolean flag = test.isAnnotationPresent(Description.class);
		if (flag) {
			//��ȡע�����
            Description des = (Description) test
                    .getAnnotation(Description.class);
            System.out.println("����:" + des.value());
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
            System.out.println("����������:" + name.community());
        }
	}

}
