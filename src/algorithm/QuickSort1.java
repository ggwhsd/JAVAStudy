package algorithm;

import java.util.Arrays;

public class QuickSort1 {

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
	//��������ѭ��
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
		
		//��ʱ left == right����leftλ�õ�ֵ�ͻ�׼��������ǰ�����У�leftλ��Ϊ��׼ֵ��������߶�С�ڵ��ڣ������ұ߶����ڵ���
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
