package logStudy;
import org.apache.log4j.Logger;

public class useLog4J {
	public static Logger logger1 = Logger.getLogger(useLog4J.class);
	
	public static void main(String[] args) {	
		int i =100;
		while(i>0) {
		 logger1.debug("这是一条测试log的数据，级别应该是debug");
		 logger1.debug("这是一条测试log的数据，级别应该是debug");
		 logger1.info("这是一条测试log的数据，级别info");
		 logger1.info("这是一条测试log的数据，级别info");
		 logger1.info("这是一条测试log的数据，级别info");
		 logger1.debug("这是一条测试log的数据，级别应该是debug");
		 logger1.warn("这是一条测试log的数据，级别应该是warn");
		 i--;
		}
	}

}
