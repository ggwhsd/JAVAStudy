package baseAPI;

import java.io.UnsupportedEncodingException;

class TrimString {
	//截取n个字符,汉字为两个英文字符
	private int trimGBK(byte[] buf,int n)
	{
		int num  =0 ;
		boolean bChineseFirstHalf = false;
		for(int i =0; i<n; i++)
		{//汉字需要取两个字符
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
			bytes = "汉字".getBytes("GBK");
			String result = new String(bytes,0,bytes.length,"GBK");
		} catch (UnsupportedEncodingException e) {


			e.printStackTrace();
		}
		
	}
	public static void main(String[] args) {
		TrimString ts =new TrimString();
		try {
			ts.GetStringByN("中国China", 6);
		} catch (UnsupportedEncodingException e) {
			
			e.printStackTrace();
		}

	}

}
