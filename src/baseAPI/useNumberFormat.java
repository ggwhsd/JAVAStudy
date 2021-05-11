package baseAPI;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Locale;

public class useNumberFormat {

	public static void main(String[] args) {
		NumberFormat nf = null;
		nf = NumberFormat.getInstance();
		System.out.println("��ʽ����"+nf.format(10000000));
		System.out.println("��ʽ����:"+nf.format(1000.345));
		nf.setMinimumIntegerDigits(2); //������������2λ��������0����
		System.out.println("��ʽ����:"+nf.format(1.345));
		nf.setMaximumIntegerDigits(3); //���������������3λ���ӵ�λ��ʼ
		System.out.println("��ʽ����:"+nf.format(123456.345));
		
		nf = NumberFormat.getInstance(); //���¿�ʼ��ʽ
		nf.setMinimumFractionDigits(1); //С����������1λ����Ĭ�����С��λ��3λ���
		System.out.println("��ʽ����:"+nf.format(123456.345));
		nf.setMinimumFractionDigits(5);
		System.out.println("��ʽ����:"+nf.format(123456.345));
		
		
		nf = NumberFormat.getNumberInstance(Locale.US);
		System.out.println("��ʽ����:"+nf.format(123456.345));
		nf = NumberFormat.getNumberInstance(Locale.GERMAN);
		System.out.println("��ʽ����:"+nf.format(123456.345));
		
		//ָ����ʽ��ʽ����NumberFormat��ֱ��
		DecimalFormat df = new DecimalFormat("0000.000");
		System.out.println("��ʽ����:"+df.format(123456.12));
		df = new DecimalFormat("#"); //����ʾС��,��������
		System.out.println("��ʽ����:"+df.format(123456.12));
		df = new DecimalFormat(".#"); //����ʾ������1λС������������
		System.out.println("��ʽ����:"+df.format(123456.123));
		df = new DecimalFormat(".##"); //����ʾ������2λС������������
		System.out.println("��ʽ����:"+df.format(123456.123));
		df = new DecimalFormat("0000,0000.00000");//ע�⡰,�����ܷ���С������
		System.out.println("��ʽ����:"+df.format(123456.123));
		
		//���Ҹ�ʽ
		nf = NumberFormat.getCurrencyInstance();
		System.out.println("��ʽ����:"+nf.format(123456.345));
		nf = NumberFormat.getCurrencyInstance(Locale.US);
		System.out.println("��ʽ����:"+nf.format(123456.345));
		//�ٷֱ�
		nf=NumberFormat.getPercentInstance();
		nf.setMinimumFractionDigits(2);
		System.out.println("��ʽ����:"+nf.format(1.345));
	}

}
