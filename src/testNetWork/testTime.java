package testNetWork;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class testTime {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 // ��ȷ������
        // ��ȡ��ǰʱ���
        System.out.println(System.currentTimeMillis());
        System.out.println(Calendar.getInstance().getTimeInMillis());
        System.out.println(new Date().getTime());

        // ��ȷ����
        // ��ȡ��ǰʱ���
        System.out.println(System.currentTimeMillis() / 1000);
        System.out.println(Calendar.getInstance().getTimeInMillis() / 1000);
        System.out.println(new Date().getTime() / 1000);

        // ��ȷ������
        // ��ȡָ����ʽ��ʱ��
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss:SSS");
        // ����ַ���
        System.out.println(df.format(new Date()));
        // ��ȡָ��ʱ��Date���󣬲�����ʱ�����ֻ�ܾ�ȷ����
        System.out.println(new Date(1510369871));
        df.getCalendar();
        // ��ȡָ��ʱ���ʱ���
        try {
            System.out.println(new SimpleDateFormat("yyyy/MM/dd HH:mm:ss:SSS").parse("2017/11/11 11:11:11:111").getTime());
        } catch (ParseException e) {
            e.printStackTrace();
        }
	}

}
