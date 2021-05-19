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
		//若相等，则表示最后一次递归结束，开始回调。
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
