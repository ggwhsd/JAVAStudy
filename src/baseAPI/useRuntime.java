package baseAPI;

public class useRuntime {

	public static void main(String[] args) {
		
		Runtime run = Runtime.getRuntime();
		System.out.println("最大内存："+run.maxMemory()/1024/1024/1024+"G");
		System.out.println("cpu numbers:"+run.availableProcessors());
		String str = "dd";
		for(int i=0; i<10000;i++)
		{
			str="e"+i;
		}
		System.out.println("当前总内存："+run.totalMemory()/1024+"K");
		System.out.println("当前空闲内存：" + run.freeMemory()/1024+"K");
		System.out.println("******释放内存******");
		run.gc();
		System.out.println("当前总内存："+run.totalMemory()/1024+"K");
		System.out.println("当前空闲内存：" + run.freeMemory()/1024+"K");
		
		try {
			System.out.println("调用外部程序");
			run.exec("notepad.exe");
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		System.out.println("当前总内存："+run.totalMemory()/1024+"K");
		System.out.println("当前空闲内存：" + run.freeMemory()/1024+"K");
		
		
	}

}
