package a3;

import java.io.UnsupportedEncodingException;

public class TrimString {
	//��ȡn���ַ�,����Ϊ����Ӣ���ַ�
	private int trimGBK(byte[] buf,int n)
	{
		int num  =0 ;
		boolean bChineseFirstHalf = false;
		for(int i =0; i<n; i++)
		{
			if(buf[i]<0&&!bChineseFirstHalf)
			{
				bChineseFirstHalf = true;
			}
			else
			{
				num++;
				bChineseFirstHalf = false;
			}
		}
		return num;
	}
	
	public void GetStringByN(String input, int n) throws UnsupportedEncodingException
	{
		int num = trimGBK(input.getBytes("GBK"),n);
		System.out.println(input.substring(0,num));
	}
}
