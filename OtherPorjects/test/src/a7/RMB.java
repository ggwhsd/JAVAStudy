package a7;

public class RMB {
	private char[] data= new char[] {
			'Áã','Ò¼','·¡','Èþ','ËÁ','Îé','Â½','Æâ','°Æ','¾Á'
	};
	private char[] units = new char[] {
			'Ôª','Ê°','°Û','Çª','Íò','Ê°','°Û','Çª','ÒÚ'
	};
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
	
}
