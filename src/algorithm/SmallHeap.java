package algorithm;

import java.lang.reflect.Array;
import java.util.Arrays;

/*
 * 用数组来做大/小堆的实现
 */
public class SmallHeap {
	
	//上浮操作：插入数据，将新数据放到最后，然后该数据与其父节点进行比较，若小于父，则上浮到父的位置。
	public static void upAdjust(int[] arr)
	{
		//获取数组最后一个元素，即新插入的数据
		int childIndex = arr.length - 1;
		int temp = arr[childIndex];
		//完美二叉树的父节点计算公式。
		int parentIndex = (childIndex - 1)/2;
	    while(childIndex > 0 && temp < arr[parentIndex])
	    {
	    	//新插入的数据与父节点比较，若小于父节点，则将子节点上浮。
	    	arr[childIndex] = arr[parentIndex];
	    	childIndex=  parentIndex;
	    	parentIndex = (childIndex-1)/2;
	    }
	    //将新插入的数据插入到正确的位子
	    arr[childIndex] = temp;
	}
	
	//下沉操作:删除堆顶的数据后，将最后一个元素放到堆顶，然后与子节点比较，若大于，则与子节点交换，相当于下沉。
	public static void downAdjust(int[] arr, int parentIndex, int length)
	{
		//获取顶的数据
		int temp = arr[parentIndex];
		//左子节点
		int childIndex = 2*parentIndex + 1;
		while(childIndex < length)
		{
			if(childIndex+1<length && arr[childIndex + 1] <arr[childIndex])
			{
				//有右节点，并且小于左节点，则父节点将与右节点比较大小
				childIndex++;
			}
			if(temp <= arr[childIndex])
			{
				//父节点已经时最小的了，直接跳出循环
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
		//从所有非叶子节点开始下沉操作
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
