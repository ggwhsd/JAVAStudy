package algorithm;

import java.util.Arrays;

//优化1：对于前面部分已经有序的数据，实际上只有后面需要冒泡，当某一轮冒泡时，若没有交换过任何一个数据，就可以提前结束排序。
public class bubbleSort2 {

	//从小到大进行排序，1,2,3,4,5, ... 
		public static void sort(int array[])
		{
			int tmp = 0;
			int runCount = 0; 
			boolean isSortSwap = false;
			for(int i = 0;i < array.length-1; i++)
			{
				isSortSwap = false;
				for(int j = 0; j< array.length-1 - i;j++)
				{
					if(array[j]>array[j+1])
					{
						isSortSwap = true;
						tmp=array[j];
						array[j] = array[j+1];
						array[j+1] = tmp;
					}
					runCount++;
				}
				if(isSortSwap==false)
				{
					break;
				}
			}
			System.out.println("runCount=" + runCount);
		}
		public static void main(String[] args) {
			int[] array = new int[] {3,0,2,1,4,5,6};
			bubbleSort2.sort(array);
			System.out.println(Arrays.toString(array));
		}
}
