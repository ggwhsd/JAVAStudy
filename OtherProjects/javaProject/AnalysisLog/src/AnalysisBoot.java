import tools.OSTools;

public class AnalysisBoot {

	public static void main(String[] args) {
		
		
		//�жϲ���ϵͳ
		if(OSTools.Instance().getOSName().contains("Windows"))
		{
			FileChooser fc = new FileChooser();
		}else
		{
			System.out.println("Linux");
		}
		
	
	}

}
