package algorithm;

public class RMB {
	private char[] data= new char[] {
			'��','Ҽ','��','��','��','��','½','��','��','��'
	};
	private char[] units = new char[] {
			'Ԫ','ʰ','��','Ǫ','��','ʰ','��','Ǫ','��'
	};
	//������ת��������
	public String ConvertToString(int price)
	{
		StringBuilder sbf = new StringBuilder();
		int unitIndex = 0;
		while(price!=0)
		{
			sbf.insert(0, units[unitIndex++]);
			int number = price % 10;
			sbf.insert(0,data[number]);
			price /= 10;
		}
		return sbf.toString();
	}
	public static void main(String[] args) {
	{
		RMB rmb = new RMB();
		System.out.println(rmb.ConvertToString(123456));
	}
	
	
	}
}
