package algorithm;

import java.util.Arrays;

//�Ż�3�� ��β������ ÿ�δ�������ð��һ��֮����һ��ʱ����������з���ð�ݡ� ��� 1,2,3,4,5,0,8�������ݡ�
public class bubbleSort4 {

	
	public static void sort(int[] array)
	{
		int runCount = 0; 
		int tmp = 0;
		for(int i =0; i< array.length; i++)
		{
			boolean isSorted = true;
			for(int j = i; j<array.length -1 - i; j++)
			{
				if(array[j]>array[j+1])
				{
					tmp = array[j];
					array[j]=array[j+1];
					array[j+1]=tmp;
					isSorted = false;
				}
				runCount++;
			}
			if(isSorted)
				break;
			isSorted = true;
			for(int j =array.length - 1 - i; j>i;j--)
			{
				if(array[j]< array[j-1])
				{
					tmp = array[j];
					array[j]= array[j-1];
					array[j-1] = tmp;
					isSorted = false;
				}
			}
			if(isSorted)
				break;
		}
		System.out.println("runCount=" + runCount);
	}
	
	public static void main(String[] args) {
		
		int[] array = new int[] {3,0,2,1,4,5,6};
		bubbleSort4.sort(array);
		System.out.println(Arrays.toString(array));
	}

}
