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
		//��ȡ�������һ��Ԫ�أ����²��������
				int childIndex = size - 1;
				int temp = array[childIndex];
				//�����������ĸ��ڵ���㹫ʽ��
				int parentIndex = (childIndex - 1)/2;
			    while(childIndex > 0 && temp < array[parentIndex])
			    {
			    	//�²���������븸�ڵ�Ƚϣ���С�ڸ��ڵ㣬���ӽڵ��ϸ���
			    	array[childIndex] = array[parentIndex];
			    	childIndex=  parentIndex;
			    	parentIndex = (childIndex-1)/2;
			    }
			    //���²�������ݲ��뵽��ȷ��λ��
			    array[childIndex] = temp;
	}
	
	private void downAdjust() {
		//��ȡ��������
		int parentIndex = 0;
		int temp = array[parentIndex];
		//���ӽڵ�
		int childIndex = 1;
		while(childIndex < size)
		{
			if(childIndex+1<size && array[childIndex + 1] <array[childIndex])
			{
				//���ҽڵ㣬����С����ڵ㣬�򸸽ڵ㽫���ҽڵ�Ƚϴ�С
				childIndex++;
			}
			if(temp <= array[childIndex])
			{
				//���ڵ��Ѿ�ʱ��С���ˣ�ֱ������ѭ��
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
