package algorithm;

import java.util.Arrays;

public class HeapSort {
	public static int runCount = 0; 
	public static void sort(int[] array)
	{
		//����ѣ������з�Ҷ�ӽڵ㿪ʼ.  
		//��ڵ�   2*parentIndex+1 = childIndex, ��: 2*parentIndex +2 = childIndex
		//���� parentIndex = (childIndex-1)/2�������ͨ�������������ڵ�ĵ��ˡ�
		for(int i = (array.length-1-1)/2; i>=0; i--)
		{
			downAdjust(array,i,array.length);
		}
		for(int i =array.length-1; i>0; i--)
		{

			int temp = array[i];
			array[i]=array[0];
			array[0]= temp;
			downAdjust(array,0,i);
		}
		
		System.out.println("runCount=" + runCount);
	}
	//����Ϊ�󶥶ѵ��³�
	public static void downAdjust(int [] array, int parentIndex, int length)
	{
		int temp = array[parentIndex];
		int childIndex = 2*parentIndex +1;
		while(childIndex<length)
		{
			if(childIndex+1<length && array[childIndex+1]>array[childIndex])
			{
				childIndex++;
			}
			if(temp >= array[childIndex])
				break;
			array[parentIndex]=array[childIndex];
			parentIndex = childIndex;
			childIndex = 2*parentIndex +1;
			runCount++;
			
		}
		array[parentIndex]= temp;
	}
	
	
	
	public static void main(String[] args) {
		int[] array = new int[] {3,0,2,1,4,5,6};
		HeapSort.sort(array);
		System.out.println(Arrays.toString(array));
	}

}
