package baseAPI;

public class useRuntime {

	public static void main(String[] args) {
		
		Runtime run = Runtime.getRuntime();
		System.out.println("����ڴ棺"+run.maxMemory()/1024/1024/1024+"G");
		System.out.println("cpu numbers:"+run.availableProcessors());
		String str = "dd";
		for(int i=0; i<10000;i++)
		{
			str="e"+i;
		}
		System.out.println("��ǰ���ڴ棺"+run.totalMemory()/1024+"K");
		System.out.println("��ǰ�����ڴ棺" + run.freeMemory()/1024+"K");
		System.out.println("******�ͷ��ڴ�******");
		run.gc();
		System.out.println("��ǰ���ڴ棺"+run.totalMemory()/1024+"K");
		System.out.println("��ǰ�����ڴ棺" + run.freeMemory()/1024+"K");
		
		try {
			System.out.println("�����ⲿ����");
			run.exec("notepad.exe");
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		System.out.println("��ǰ���ڴ棺"+run.totalMemory()/1024+"K");
		System.out.println("��ǰ�����ڴ棺" + run.freeMemory()/1024+"K");
		
		
	}

}
