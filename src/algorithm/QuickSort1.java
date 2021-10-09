package algorithm;

import java.util.Arrays;

public class QuickSort1 {

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
	//左右两个循环
	private static int partition(int []array, int startIndex, int endIndex)
	{
		int pivot = array[startIndex];
		int left = startIndex;
		int right = endIndex;
		
		while(left != right)
		{
			while(left<right && array[right]>=pivot)
			{
				right--;
				runCount++;
			}
			while(left<right && array[left]<=pivot)
			{
				left++;
				runCount++;
			}
			if(left<right) {
				int tmp = array[left];
				array[left] = array[right];
				array[right] = tmp;
			}
		}
		
		//此时 left == right，将left位置的值和基准调换后，则当前数组中，left位置为基准值，在其左边都小于等于，在其右边都大于等于
		array[startIndex] =array[left];
		array[left]=pivot;
		return left;
		
	}
	
	public static void main(String[] args) {
		int[] array = new int[] {3,0,2,1,4,5,6};
		QuickSort1.sort(array);
		System.out.println(Arrays.toString(array));
	}

}
