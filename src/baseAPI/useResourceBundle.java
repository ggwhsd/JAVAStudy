package baseAPI;

import java.util.ResourceBundle;
import java.text.MessageFormat;
import java.util.Locale;

public class useResourceBundle {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Locale zhLoc = new Locale("zh1","CN2");		
		ResourceBundle rb = ResourceBundle.getBundle("Message",zhLoc);
		System.out.println("���ݣ�"+rb.getString("info"));
		String str1="���ݣ�"+rb.getString("info");
		System.out.println(MessageFormat.format(str1, " hero","hero1"));
		
        Locale zhLoc1 = new Locale("zh","CN");
		rb = ResourceBundle.getBundle("Message",zhLoc1);
		System.out.println("���ݣ�"+rb.getString("info"));
		str1="���ݣ�"+rb.getString("info");
		System.out.println(MessageFormat.format(str1, " Ӣ��","Ӣ��1"));
		
		
	}

}
