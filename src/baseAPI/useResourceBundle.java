package baseAPI;

import java.util.ResourceBundle;
import java.text.MessageFormat;
import java.util.Locale;

public class useResourceBundle {
//���ݲ�ͬ���ԣ�ѡ��ͬ�����������ļ�
//MessageFormatר�����ڴ������������ļ��е�ռλ��
	public static void main(String[] args) {
		
		Locale zhLoc = new Locale("en","CA");		
		ResourceBundle rb = ResourceBundle.getBundle("Message",zhLoc);
		System.out.println("���ݣ�"+rb.getString("info"));
		String str1="���ݣ�"+rb.getString("info");
		System.out.println(MessageFormat.format(str1, " one","two"));
		
        Locale zhLoc1 = new Locale("zh","CN");
		rb = ResourceBundle.getBundle("Message",zhLoc1);
		System.out.println("���ݣ�"+rb.getString("info"));
		str1="���ݣ�"+rb.getString("info");
		System.out.println(MessageFormat.format(str1, "һ","��"));
		
		System.out.println(MessageFormat.format("format({0})", "First"));
		String str = String.format("format(%s) ", "First");
		System.out.println(str);
	}

}
