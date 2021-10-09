package algorithm;

import java.util.Arrays;

public class QuickSort2 {

	public static int runCount = 0; 
	public static void sort(int[] array)
	{
		quickSort(array, 0,array.length-1);
		System.out.println("runCount=" + runCount);
	}
	//˫��ѭ��
	private static void quickSort(int[] array, int startIndex, int endIndex)
	{
		if(startIndex>= endIndex)
		{
			return;
		}
		
		int pivotIndex = partition(array, startIndex, endIndex);
		quickSort(array,startIndex, pivotIndex - 1);
		quickSort(array,pivotIndex+1, endIndex);
	}
	//��С�����򣬻�׼pivot��Ԫ����߶�ҪС��pivot���ұ߶�Ҫ����pivot
	//���ط���֮���λ��
	//һ��ѭ����������С�ڻ�׼��Ԫ�ض��ŵ���׼��ߡ�
	private static int partition(int []array, int startIndex, int endIndex)
	{
		int pivot = array[startIndex];
		//����λ��С�ڵ���markλ�õ�ֵ����С��pivot�ġ�
		int mark = startIndex;
		
		for(int index= startIndex+1; index<endIndex;index++)
		{
				if(array[index]>pivot)
				{
					//nothing to do
				}
				else
				{
					mark++;
					int tmp = array[mark];
					array[mark] = array[index];
					array[index] = tmp;
				}
				runCount++;
		}
		
		//��׼Ԫ�غ�markλ��Ԫ�ص������Ӷ�������λ��С�ڵ���markλ�õ�ֵ����С�ڵ���pivot�ġ�
		array[startIndex]=array[mark];
		array[mark]=pivot;
		return mark;
		
		
		
	}
	
	public static void main(String[] args) {
		int[] array = new int[] {3,0,2,1,4,5,6};
		QuickSort2.sort(array);
		System.out.println(Arrays.toString(array));
	}

}
