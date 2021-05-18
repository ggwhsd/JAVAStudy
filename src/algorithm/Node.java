package algorithm;

public class Node {
	public int value;
	public Node left;
	public Node right;
	
	public void store(int value)
	{
		if (value < this.value)
		{
			if(left == null)
			{
				left = new Node();
				left.value = value;
			}
			else
			{
				left.store(value);
			}
		}
		
		else if(value > this.value)
		{
			if (right == null)
			{
				right = new Node();
				right.value = value;
			}
			else
			{
				right.store(value);
			}
		}
	}
	
	public boolean find(int value)
	{
		System.out.println("happen" +this.value);
		if(value == this.value)
		{
			return true;
		}
		else if(value > this.value)
		{
			if(right ==null) return false;
			return right.find(value);
		}
		else
		{
			if(left ==null) return false;
			return left.find(value);
		}
	}
	//œ»–Ú±È¿˙
	public void preList()
	{
		System.out.print(this.value+ ",");
		if(left!=null)left.preList();
		if(right!=null) right.preList();
	}
	
	public void middleList()
	{
		if(left!=null)left.middleList();
		System.out.print(this.value+ ",");
		if(right!=null) right.middleList();
	}
	
	public void afterList()
	{
		
		if(left!=null)left.afterList();
		if(right!=null) right.afterList();
		System.out.print(this.value+ ",");
	}
	
}
