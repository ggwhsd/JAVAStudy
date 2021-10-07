package algorithm;

import java.lang.reflect.Array;
import java.util.Arrays;

/*
 * ������������/С�ѵ�ʵ��
 */
public class SmallHeap {
	
	//�ϸ��������������ݣ��������ݷŵ����Ȼ����������丸�ڵ���бȽϣ���С�ڸ������ϸ�������λ�á�
	public static void upAdjust(int[] arr)
	{
		//��ȡ�������һ��Ԫ�أ����²��������
		int childIndex = arr.length - 1;
		int temp = arr[childIndex];
		//�����������ĸ��ڵ���㹫ʽ��
		int parentIndex = (childIndex - 1)/2;
	    while(childIndex > 0 && temp < arr[parentIndex])
	    {
	    	//�²���������븸�ڵ�Ƚϣ���С�ڸ��ڵ㣬���ӽڵ��ϸ���
	    	arr[childIndex] = arr[parentIndex];
	    	childIndex=  parentIndex;
	    	parentIndex = (childIndex-1)/2;
	    }
	    //���²�������ݲ��뵽��ȷ��λ��
	    arr[childIndex] = temp;
	}
	
	//�³�����:ɾ���Ѷ������ݺ󣬽����һ��Ԫ�طŵ��Ѷ���Ȼ�����ӽڵ�Ƚϣ������ڣ������ӽڵ㽻�����൱���³���
	public static void downAdjust(int[] arr, int parentIndex, int length)
	{
		//��ȡ��������
		int temp = arr[parentIndex];
		//���ӽڵ�
		int childIndex = 2*parentIndex + 1;
		while(childIndex < length)
		{
			if(childIndex+1<length && arr[childIndex + 1] <arr[childIndex])
			{
				//���ҽڵ㣬����С����ڵ㣬�򸸽ڵ㽫���ҽڵ�Ƚϴ�С
				childIndex++;
			}
			if(temp <= arr[childIndex])
			{
				//���ڵ��Ѿ�ʱ��С���ˣ�ֱ������ѭ��
				break;
			}
			else
			{
				arr[parentIndex] = arr[childIndex];
				parentIndex = childIndex;
				childIndex = 2*parentIndex + 1;
			}
		}
		arr[parentIndex] = temp;
	}
	
	public static void buildHeap(int[] arr)
	{
		//�����з�Ҷ�ӽڵ㿪ʼ�³�����
		for(int i = (arr.length - 1 - 1)/2; i >=0; i--)
		{
			downAdjust(arr,i,arr.length);
		}
	}
	
	public static void main(String[] args) {
		int[] array = new int[] {1,3,2,6,5,7,8,9,10,0};
		upAdjust(array);
		System.out.println(Arrays.toString(array));
		array = new int[] {7,1,3,10,5,2,8,9,6};
		buildHeap(array);
		System.out.println(Arrays.toString(array));
	}
}
