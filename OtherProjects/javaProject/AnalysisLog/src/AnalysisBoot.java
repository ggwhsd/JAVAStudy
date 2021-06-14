import tools.OSTools;

public class AnalysisBoot {

	public static void main(String[] args) {
		
		
		//ÅÐ¶Ï²Ù×÷ÏµÍ³
		if(OSTools.Instance().getOSName().contains("Windows"))
		{
			FileChooser fc = new FileChooser();
		}else
		{
			System.out.println("Linux");
		}
		
	
	}

}
