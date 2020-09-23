package sort;

import java.util.Arrays;

public class MergeSort {

	public static void main(String[] args) {
		int[] arr = {8,4,5,7,1,3,6,2};
		int[] temp = new int[arr.length];
		mergeSort(arr, 0, arr.length-1, temp);
		System.out.println(Arrays.toString(arr));
	}
	
	//分+合方法
	public static void mergeSort(int[] arr,int left,int right,int[] temp) {
		if(left < right) {
			int mid = (left + right) / 2;
			//向左递归分解
			mergeSort(arr, left, mid, temp);
			//向右递归分解
			mergeSort(arr, mid+1, right, temp);
			//到合并 
			merge(arr, left, mid, right, temp);
		}
	}
	
	//合并的方法
	/**
	 * 
	 * @param arr 原始数组
	 * @param left 左边有序序列的初始索引
	 * @param mid 中间索引
	 * @param right 右边索引
	 * @param temp 中转数组
	 */
	public static void merge(int[] arr,int left,int mid ,int right, int[] temp) {
		int i = left;// 初始化i，左边有序序列的初始索引
		int j = mid + 1;//`初始化j，右边有序序列的初始索引
		int t = 0;
		
		//（一）
		//·先把左右两边（有序）的数组按照规则填充道temp数组
		//·直到有一边为空
		while( i <= mid && j <= right ) {
			//·左边序列的当前元素小于等于右边序列的当前元素
			//·将左边 的元素拷贝到temp
			//i++，t++
			if(arr[i] <= arr[j]) {
				temp[t++] = arr[i++];
				//i +=1;
				//t +=1; 
			}else {
				temp[t++] = arr[j++];
				//j +=1;
				//t +=1;
			}
		}
		
		
		//(二)
		//·把还有剩余的数组填充到temp
		while(i <=mid) {//·说明左边还剩有元素
			temp[t++] = arr[i++];
			//t +=1;
			//i +=1;
		}
		
		while(j <=right) {//·说明右边还剩有元素
			temp[t++] = arr[j++];
			//t +=1;
			//j +=1;
		}
		
		//（三）
		//·将temp数组拷贝到arr
//		t = 0;
//		int tempLeft = left;
//		while (tempLeft <= right) {
//			arr[tempLeft] = temp[t];
//			 t +=1;
//			 tempLeft +=1;
//		}
		int k =0;
		for(int templeft = left; templeft <= right; templeft++) {
			arr[templeft] = temp[k++];
		}
	}

}
