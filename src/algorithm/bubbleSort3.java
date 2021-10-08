package algorithm;

import java.util.Arrays;

//优化2： 当数列的左半部分都小于右边部分这种类似情况时，每次排序，左边元素互相冒泡下，右部分也互相冒泡，
//      当出现某次交换元素只在中间某个位置时，则该位置右侧都已经无需再遍历排序。   比如，如下数据，第一轮排序，但是实际上从4开始都是有序的，这一段无需遍历冒泡了。   3,0,2,1,4,5,6
public class bubbleSort3 {

	//最后一次交换位置，就是无顺序数列，其后都都有顺序的
	public static void sort(int array[])
	{
		int tmp = 0;
		int runCount = 0; 
		boolean isSortSwap = false;
		
		int sortBorder = array.length - 1;
		int lastSwapIndex = 0;
		for(int i = 0;i < array.length-1; i++)
		{
			isSortSwap = false;
			for(int j = 0; j< sortBorder;j++)
			{
				if(array[j]>array[j+1])
				{
					isSortSwap = true;
					tmp=array[j];
					array[j] = array[j+1];
					array[j+1] = tmp;
					lastSwapIndex = j;
				}
				runCount++;
			}
			
			sortBorder = lastSwapIndex;
			
			if(isSortSwap==false)
			{
				break;
			}
		}
		System.out.println("runCount=" + runCount);
	}
	
	public static void main(String[] args) {
		int[] array = new int[] {3,0,2,1,4,5,6};
		bubbleSort3.sort(array);
		System.out.println(Arrays.toString(array));
	}

}
