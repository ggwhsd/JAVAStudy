package algorithm;

import java.util.Arrays;

//�Ż�1������ǰ�沿���Ѿ���������ݣ�ʵ����ֻ�к�����Ҫð�ݣ���ĳһ��ð��ʱ����û�н������κ�һ�����ݣ��Ϳ�����ǰ��������
public class bubbleSort2 {

	//��С�����������1,2,3,4,5, ... 
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
