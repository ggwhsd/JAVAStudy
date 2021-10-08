package algorithm;

import java.util.Arrays;

public class PriorityQueue {

	private int[] array;
	
	private int size;
	
	public PriorityQueue()
	{
		array = new int[32];
		size = 0;
	}
	
	public void enQueue(int key) {
		if(size >= array.length)
		{
			resize();
		}
		array[size++]= key;
		upAdjust();
	}
	
	public int deQueue() throws Exception
	{
		if(size <=0)
		{
			throw new Exception("the queue is empty !");
		}
		int head = array[0];
		array[0] = array[--size];
		downAdjust();
		return head;
		
	}
	
	private void upAdjust() {
		//获取数组最后一个元素，即新插入的数据
				int childIndex = size - 1;
				int temp = array[childIndex];
				//完美二叉树的父节点计算公式。
				int parentIndex = (childIndex - 1)/2;
			    while(childIndex > 0 && temp < array[parentIndex])
			    {
			    	//新插入的数据与父节点比较，若小于父节点，则将子节点上浮。
			    	array[childIndex] = array[parentIndex];
			    	childIndex=  parentIndex;
			    	parentIndex = (childIndex-1)/2;
			    }
			    //将新插入的数据插入到正确的位子
			    array[childIndex] = temp;
	}
	
	private void downAdjust() {
		//获取顶的数据
		int parentIndex = 0;
		int temp = array[parentIndex];
		//左子节点
		int childIndex = 1;
		while(childIndex < size)
		{
			if(childIndex+1<size && array[childIndex + 1] <array[childIndex])
			{
				//有右节点，并且小于左节点，则父节点将与右节点比较大小
				childIndex++;
			}
			if(temp <= array[childIndex])
			{
				//父节点已经时最小的了，直接跳出循环
				break;
			}
			else
			{
				array[parentIndex] = array[childIndex];
				parentIndex = childIndex;
				childIndex = 2*parentIndex + 1;
			}
		}
		array[parentIndex] = temp;
	}
	
	private void resize()
	{
		int newSize = this.size * 2;
		this.array = Arrays.copyOf(this.array, newSize);
	}
	
	
	
	public static void main(String[] args) throws Exception {
		PriorityQueue pQueue = new PriorityQueue();
		pQueue.enQueue(3);
		pQueue.enQueue(5);
		pQueue.enQueue(10);
		pQueue.enQueue(2);
		pQueue.enQueue(7);
		System.out.println("deQueue:"+ pQueue.deQueue());
		System.out.println("deQueue:"+pQueue.deQueue());

	}

}
