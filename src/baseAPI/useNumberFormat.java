package baseAPI;

import java.text.NumberFormat;

public class useNumberFormat {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		NumberFormat nf = null;
		nf = NumberFormat.getInstance();
		System.out.println("格式化后："+nf.format(10000000));
		System.out.println("格式化后:"+nf.format(1000.345));
	}

}
