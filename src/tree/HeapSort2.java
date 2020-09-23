package tree;

import java.util.Arrays;

public class HeapSort2 {
	public static void main(String[] args) {
		int[] arr = {4,6,8,5,9,123,2,-12,-13};
		heapSort(arr);
	}
	
	public static void heapSort(int[] arr) {
		//·构建大顶堆
		for(int i = arr.length / 2 - 1; i >= 0; i-- ) {
			adjustHeap(arr, i, arr.length);
		}
		
		//·交换堆顶和末尾元素
		int temp = 0;
		for(int j = arr.length -1 ; j>0 ;j--) {
			//·交换
			temp = arr[j];
			arr[j] =arr[0];
			arr[0] =temp;
			adjustHeap(arr, 0, j);
		}
		System.out.println(Arrays.toString(arr));
	}
	
	public static void adjustHeap(int[] arr, int i, int len) {
		//·左子节点
		int left = 2 * i + 1;
		//·右子节点
		int right = 2 * i + 2;
		//·默认当前节点值最大
		int largestIndex = i;
		if(left < len && arr[left] > arr[largestIndex]) {
			largestIndex = left;
		}
		if(right < len && arr[right] > arr[largestIndex]) {
			largestIndex = right;
		}
		
		if(largestIndex != i) {
			//·交换
			int temp = arr[i];
			arr[i] = arr[largestIndex];
			arr[largestIndex] = temp;
			//·交换之后 子节点值变了 继续调整
			adjustHeap(arr, largestIndex, len);
		}
	}
}
