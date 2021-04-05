package a4;

public class BTree {
	private Node root = new Node();
	public BTree()
	{
		int [] data = new int[20];
		for(int i = 0; i<data.length; i++)
		{
			data[i] = (int )(Math.random()*100) + 1;
			System.out.print(data[i]+",");
		}
		System.out.println();
		root.value = data[0];
		for(int i = 1; i<data.length; i++)
		{
			root.store(data[i]);
		}
		
		
	}
	
	
	public void Find(int value)
	{
		System.out.println("ÕÒµ½Êý¾Ý£º"+root.find(value));
		
	}
	public void PreList()
	{
		root.preList();
	}
	public void MiddList()
	{
		root.middleList();
	}
	public void AfterList()
	{
		root.afterList();
	}
}
