package baseAPI;

public class useStringBuffer {

	public static void print(StringBuffer strBuff)
	{
		System.out.println(strBuff);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		StringBuffer strBuff = new StringBuffer("hello");
		strBuff.replace(0, strBuff.length(), "world");
		print(strBuff);
	}

}
