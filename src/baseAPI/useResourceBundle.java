package baseAPI;

import java.util.ResourceBundle;
import java.text.MessageFormat;
import java.util.Locale;

public class useResourceBundle {
//根据不同语言，选择不同的语言配置文件
//MessageFormat专门用于处理语言配置文件中的占位符
	public static void main(String[] args) {
		
		Locale zhLoc = new Locale("en","CA");		
		ResourceBundle rb = ResourceBundle.getBundle("Message",zhLoc);
		System.out.println("内容："+rb.getString("info"));
		String str1="内容："+rb.getString("info");
		System.out.println(MessageFormat.format(str1, " one","two"));
		
        Locale zhLoc1 = new Locale("zh","CN");
		rb = ResourceBundle.getBundle("Message",zhLoc1);
		System.out.println("内容："+rb.getString("info"));
		str1="内容："+rb.getString("info");
		System.out.println(MessageFormat.format(str1, "一","二"));
		
		System.out.println(MessageFormat.format("format({0})", "First"));
		String str = String.format("format(%s) ", "First");
		System.out.println(str);
	}

}
