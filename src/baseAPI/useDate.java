package baseAPI;
import java.util.* ;	// ������Ҫ�Ĺ��߰�
import java.text.* ;	// ����SimpleDateFormat���ڵİ�
class mmm{		// �Ժ�ֱ��ͨ������Ϳ���ȡ������ʱ��
	private SimpleDateFormat sdf = null ;	// ����SimpleDateFormat����
	public String getDate(){		// �õ�����һ�����ڣ���ʽΪ��yyyy-MM-dd HH:mm:ss.SSS
		this.sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS") ;
		return this.sdf.format(new Date()) ;// ����ǰ���ڽ��и�ʽ������
	}
	public String getDateComplete(){		// �õ�����һ�����ڣ���ʽΪ��yyyy��MM��dd�� HHʱmm��ss��SSS����
		this.sdf = new SimpleDateFormat("yyyy��MM��dd��HHʱmm��ss��SSS����") ;
		return this.sdf.format(new Date()) ;// ����ǰ���ڽ��и�ʽ������
	}
	public String getTimeStamp(){		// �õ�����һ��ʱ���
		this.sdf = new SimpleDateFormat("yyyyMMddHHmmssSSS") ;
		return this.sdf.format(new Date()) ;// ����ǰ���ڽ��и�ʽ������
	}
};




public class useDate{
	public static void main(String args[]){
		mmm dt = new mmm() ;
		System.out.println("ϵͳ���ڣ�"+dt.getDate()) ;
		System.out.println("�������ڣ�"+dt.getDateComplete()) ;
		System.out.println("ʱ�����"+dt.getTimeStamp()) ;
		
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
};