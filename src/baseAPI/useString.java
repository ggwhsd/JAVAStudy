package baseAPI;

import java.io.UnsupportedEncodingException;

class TrimString {
	//��ȡn���ַ�,����Ϊ����Ӣ���ַ�
	private int trimGBK(byte[] buf,int n)
	{
		int num  =0 ;
		boolean bChineseFirstHalf = false;
		for(int i =0; i<n; i++)
		{//������Ҫȡ�����ַ�
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

public class useString {

	public static void StringEncode()
	{
		byte[] bytes;
		try {
			bytes = "����".getBytes("GBK");
			String result = new String(bytes,0,bytes.length,"GBK");
		} catch (UnsupportedEncodingException e) {


			e.printStackTrace();
		}
		
	}
	public static void main(String[] args) {
		TrimString ts =new TrimString();
		try {
			ts.GetStringByN("�й�China", 6);
		} catch (UnsupportedEncodingException e) {
			
			e.printStackTrace();
		}

	}

}
