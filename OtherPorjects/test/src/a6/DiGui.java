package a6;

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
		if(myCount == count)
			System.out.println("=================");
		System.out.println(n);

	}
}
