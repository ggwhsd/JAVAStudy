package tools;

public class OSTools {
	private  String OSVersion;
	private  String OSName;
	private  String OSArch;
	private static OSTools OSTools;
	
	public  String getOSVersion() {
		return OSVersion;
	}

	public  String getOSName() {
		return OSName;
	}

	public  String getOSArch() {
		return OSArch;
	}

	public static OSTools Instance()
	{
		OSTools = new OSTools();
		return OSTools;
		
	}
	
	public OSTools()
	{
		getOSInformation();
	}
	
	public  void getOSInformation(){
		 OSName=System.getProperty("os.name");
		 OSArch=System.getProperty("os.arch");
		 OSVersion=System.getProperty("os.version");

	}
	
}
