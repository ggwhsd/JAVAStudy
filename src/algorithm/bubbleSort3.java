package algorithm;

import java.util.Arrays;

//�Ż�2�� �����е���벿�ֶ�С���ұ߲��������������ʱ��ÿ���������Ԫ�ػ���ð���£��Ҳ���Ҳ����ð�ݣ�
//      ������ĳ�ν���Ԫ��ֻ���м�ĳ��λ��ʱ�����λ���Ҳ඼�Ѿ������ٱ�������   ���磬�������ݣ���һ�����򣬵���ʵ���ϴ�4��ʼ��������ģ���һ���������ð���ˡ�   3,0,2,1,4,5,6
public class bubbleSort3 {

	//���һ�ν���λ�ã�������˳�����У���󶼶���˳���
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
