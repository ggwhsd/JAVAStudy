package logStudy;
import org.apache.log4j.Logger;

public class useLog4J {
	public static Logger logger1 = Logger.getLogger(useLog4J.class);
	
	public static void main(String[] args) {	
		int i =100;
		while(i>0) {
		 logger1.debug("����һ������log�����ݣ�����Ӧ����debug");
		 logger1.debug("����һ������log�����ݣ�����Ӧ����debug");
		 logger1.info("����һ������log�����ݣ�����info");
		 logger1.info("����һ������log�����ݣ�����info");
		 logger1.info("����һ������log�����ݣ�����info");
		 logger1.debug("����һ������log�����ݣ�����Ӧ����debug");
		 logger1.warn("����һ������log�����ݣ�����Ӧ����warn");
		 i--;
		}
	}

}
