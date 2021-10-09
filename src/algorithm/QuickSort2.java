package algorithm;

import java.util.Arrays;

public class QuickSort2 {

	public static int runCount = 0; 
	public static void sort(int[] array)
	{
		quickSort(array, 0,array.length-1);
		System.out.println("runCount=" + runCount);
	}
	//双边循环
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
	//从小打到排序，基准pivot的元素左边都要小于pivot，右边都要大于pivot
	//返回分治之后的位置
	//一个循环：将所有小于基准的元素都放到基准左边。
	private static int partition(int []array, int startIndex, int endIndex)
	{
		int pivot = array[startIndex];
		//所有位于小于等于mark位置的值都是小于pivot的。
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
		
		//基准元素和mark位置元素调换，从而，所有位于小于等于mark位置的值都是小于等于pivot的。
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
