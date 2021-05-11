package baseAPI;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Locale;

public class useNumberFormat {

	public static void main(String[] args) {
		NumberFormat nf = null;
		nf = NumberFormat.getInstance();
		System.out.println("格式化后："+nf.format(10000000));
		System.out.println("格式化后:"+nf.format(1000.345));
		nf.setMinimumIntegerDigits(2); //保留整数最少2位，不足以0补充
		System.out.println("格式化后:"+nf.format(1.345));
		nf.setMaximumIntegerDigits(3); //保留整数部分最多3位，从低位开始
		System.out.println("格式化后:"+nf.format(123456.345));
		
		nf = NumberFormat.getInstance(); //重新开始格式
		nf.setMinimumFractionDigits(1); //小数部分最少1位，按默认最大小数位数3位输出
		System.out.println("格式化后:"+nf.format(123456.345));
		nf.setMinimumFractionDigits(5);
		System.out.println("格式化后:"+nf.format(123456.345));
		
		
		nf = NumberFormat.getNumberInstance(Locale.US);
		System.out.println("格式化后:"+nf.format(123456.345));
		nf = NumberFormat.getNumberInstance(Locale.GERMAN);
		System.out.println("格式化后:"+nf.format(123456.345));
		
		//指定格式形式，比NumberFormat更直接
		DecimalFormat df = new DecimalFormat("0000.000");
		System.out.println("格式化后:"+df.format(123456.12));
		df = new DecimalFormat("#"); //不显示小数,四舍五入
		System.out.println("格式化后:"+df.format(123456.12));
		df = new DecimalFormat(".#"); //不显示整数，1位小数，四舍五入
		System.out.println("格式化后:"+df.format(123456.123));
		df = new DecimalFormat(".##"); //不显示整数，2位小数，四舍五入
		System.out.println("格式化后:"+df.format(123456.123));
		df = new DecimalFormat("0000,0000.00000");//注意“,”不能放在小数部分
		System.out.println("格式化后:"+df.format(123456.123));
		
		//货币格式
		nf = NumberFormat.getCurrencyInstance();
		System.out.println("格式化后:"+nf.format(123456.345));
		nf = NumberFormat.getCurrencyInstance(Locale.US);
		System.out.println("格式化后:"+nf.format(123456.345));
		//百分比
		nf=NumberFormat.getPercentInstance();
		nf.setMinimumFractionDigits(2);
		System.out.println("格式化后:"+nf.format(1.345));
	}

}
