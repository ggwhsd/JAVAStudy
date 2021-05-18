package algorithm;

public class BTree {
	private Node root = new Node();
	public BTree()
	{
		//随机生成20个节点元素
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
		System.out.println("找到数据："+root.find(value));
		
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
	
	private static void test()
	{
		BTree bt = new BTree();
		System.out.println();
		bt.PreList();
		System.out.println();
		bt.MiddList();
		System.out.println();
		bt.AfterList();
		System.out.println();
	}
}
