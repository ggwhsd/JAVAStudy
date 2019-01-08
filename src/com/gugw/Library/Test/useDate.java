package com.gugw.Library.Test;
import java.util.* ;	// 导入需要的工具包
import java.text.* ;	// 导入SimpleDateFormat所在的包
class mmm{		// 以后直接通过此类就可以取得日期时间
	private SimpleDateFormat sdf = null ;	// 声明SimpleDateFormat对象
	public String getDate(){		// 得到的是一个日期：格式为：yyyy-MM-dd HH:mm:ss.SSS
		this.sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS") ;
		return this.sdf.format(new Date()) ;// 将当前日期进行格式化操作
	}
	public String getDateComplete(){		// 得到的是一个日期：格式为：yyyy年MM月dd日 HH时mm分ss秒SSS毫秒
		this.sdf = new SimpleDateFormat("yyyy年MM月dd日HH时mm分ss秒SSS毫秒") ;
		return this.sdf.format(new Date()) ;// 将当前日期进行格式化操作
	}
	public String getTimeStamp(){		// 得到的是一个时间戳
		this.sdf = new SimpleDateFormat("yyyyMMddHHmmssSSS") ;
		return this.sdf.format(new Date()) ;// 将当前日期进行格式化操作
	}
};




public class useDate{
	public static void main(String args[]){
		mmm dt = new mmm() ;
		System.out.println("系统日期："+dt.getDate()) ;
		System.out.println("中文日期："+dt.getDateComplete()) ;
		System.out.println("时间戳："+dt.getTimeStamp()) ;
		
		Calendar calendar = new GregorianCalendar();
		StringBuffer strb= new StringBuffer();
		strb.append(calendar.get(Calendar.YEAR));
		strb.append("-"+(calendar.get(Calendar.MONTH)+1));
		strb.append("-"+calendar.get(Calendar.DAY_OF_MONTH));
		strb.append(" "+calendar.get(Calendar.HOUR_OF_DAY));
		strb.append(":" +calendar.get(Calendar.MINUTE));
		strb.append(":"+calendar.get(Calendar.SECOND));
		strb.append(":"+calendar.get(Calendar.MILLISECOND));
		System.out.println(strb);
		
		Random rd = new Random();
		
		System.out.println(rd.nextInt(100));
		
		
		NumberFormat nf = null;
		nf = NumberFormat.getInstance();
		System.out.println("格式化后："+nf.format(10000000));
		System.out.println("格式化后:"+nf.format(1000.345));
		
	}
};