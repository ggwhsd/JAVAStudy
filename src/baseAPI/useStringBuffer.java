package baseAPI;

public class useStringBuffer {

	public static void print(StringBuffer strBuff)
	{
		System.out.println(strBuff);
	}
	public static void main(String[] args) {
		
		StringBuffer strBuff = new StringBuffer("hello");

		strBuff.replace(0, strBuff.length(), "world");
		print(strBuff);
		int len = "xxxxxxxxxxxxxxxxxxx".length();
		
		long begin = System.currentTimeMillis();
		for(int i =0;i<10000000;i++)
		{
			strBuff.append("xxxxxxxxxxxxxxxxxxx");
			strBuff.setLength(0);
		}
		long end = System.currentTimeMillis();
		System.out.println("清空数据的方式:setLength(0):" + (end - begin));
		print(strBuff);
		begin = System.currentTimeMillis();
		for(int i =0;i<10000000;i++)
		{
			strBuff.append("xxxxxxxxxxxxxxxxxxx");
			strBuff.delete(0, strBuff.length());
			//strBuff.delete(0, len);
		}
		end = System.currentTimeMillis();
		System.out.println("清空数据的方式:delete(0,len):" + (end - begin));
		print(strBuff);
		
		begin = System.currentTimeMillis();
		for(int i =0;i<10000000;i++)
		{
			strBuff.append("xxxxxxxxxxxxxxxxxxx");
			strBuff = new StringBuffer("");
		}
		end = System.currentTimeMillis();
		System.out.println("清空数据的方式:new StringBuffer(\"\"):" + (end - begin));
		print(strBuff);
	}

}
