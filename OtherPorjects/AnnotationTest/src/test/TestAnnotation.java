package test;
import java.lang.reflect.Method;
import java.util.HashSet;
import java.util.Set;

import gugw.Description;
import gugw.Name;
public class TestAnnotation {

	public static void main(String[] args) {
		
		//获取注解Description的字段
		String CLASS_NAME = "gugw.JavaEyer";
		Class test = null;
		try {
			test = Class.forName(CLASS_NAME);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Method[] method = test.getMethods();
		//从类信息上判断是否有注解
		boolean flag = test.isAnnotationPresent(Description.class);
		if (flag) {
			//获取注解对象
            Description des = (Description) test
                    .getAnnotation(Description.class);
            System.out.println("描述:" + des.value());
            System.out.println("-----------------");
        }
		
		
		Set<Method> set = new HashSet<Method>();
		for (int i = 0; i < method.length; i++) {
			//获取类方法信息，判断是否有注解
			boolean otherFlag = method[i].isAnnotationPresent(Name.class);
			if (otherFlag)
                set.add(method[i]);	
		}
		for (Method m : set) {
			//从方法上获取注解对象
            Name name = m.getAnnotation(Name.class);
            System.out.println(name.originate());
            System.out.println("创建的社区:" + name.community());
        }
	}

}
