package algorithm;

public class DiGui {
	public void calcShow()
	{
		doubleNum(888);
	}
	int count = 0;
	private void doubleNum(int n)
	{
		count++;
		System.out.println(n);
		int myCount = count;
		if(n<10000)
		{
			
			doubleNum(n*2);
		}
		//����ȣ����ʾ���һ�εݹ��������ʼ�ص���
		if(myCount == count)
			System.out.println("=================");
		System.out.println(n);

	}
	
	public static void test()
	{
		DiGui dg = new DiGui();
		dg.calcShow();
	}
}
