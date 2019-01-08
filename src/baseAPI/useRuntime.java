package baseAPI;

public class useRuntime {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Runtime run = Runtime.getRuntime();
		System.out.println(run.maxMemory()/1024/1024/1024+"G");

		String str = "dd";
		
		for(int i=0; i<10000;i++)
		{
			str="e"+i;
		}
		System.out.println(run.totalMemory()/1024+"K");
		System.out.println(run.freeMemory()/1024+"K");
		run.gc();
		System.out.println(run.totalMemory()/1024+"K");
		System.out.println(run.freeMemory()/1024+"K");
		
		try {
			run.exec("notepad.exe");
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		System.out.println(run.freeMemory()/1024+"K");
	}

}
