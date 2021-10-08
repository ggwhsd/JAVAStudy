package algorithm;

import java.lang.reflect.Array;
import java.util.Arrays;

// 最基础的冒泡排序
public class bubbleSort1 {

	//从小到大进行排序，1,2,3,4,5, ... 
	public static void sort(int array[])
	{
		int tmp = 0;
		int runCount = 0;
		for(int i = 0;i < array.length-1; i++)
		{
			for(int j = 0; j< array.length-1 - i;j++)
			{
				if(array[j]>array[j+1])
				{
					tmp=array[j];
					array[j] = array[j+1];
					array[j+1] = tmp;
					
				}
				runCount++;
			}
		}
		System.out.println("runCount=" + runCount);
	}
	public static void main(String[] args) {
		int[] array = new int[] {3,0,2,1,4,5,6};
		bubbleSort1.sort(array);
		System.out.println(Arrays.toString(array));
	}

}
