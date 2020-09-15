package tree;

import java.util.Arrays;

public class HeapSort {

	public static void main(String[] args) {
		//升序排列
		int[] arr = {4,6,8,5,9,123,2,-12,-13};
		headSort(arr);
 	}
	
	public static void headSort(int[] arr) {
		int temp = 0;
		System.out.println("堆排序");
		//分步
		//adjustHeap(arr, 1, arr.length);
		//System.out.println("第一次"+Arrays.toString(arr));
		
		//adjustHeap(arr, 0, arr.length);
		//System.out.println("第二次"+Arrays.toString(arr));
		
		//1.完整构建大顶堆
		for(int i = arr.length /2 - 1; i >= 0 ;i--) {
			adjustHeap(arr, i, arr.length);
		}
		
		//2.将对顶元素与末尾元素交换，将最大元素沉到数组末端
		//3.重新调整结构使其满足堆定义，然后继续交换堆顶元素与当前末尾元素，反复执行，直到整个序列有序
		for(int j = arr.length -1 ; j>0 ;j--) {
			//交换
			temp = arr[j];
			arr[j] =arr[0];
			arr[0] =temp;
			adjustHeap(arr, 0, j);
		}
		System.out.println(Arrays.toString(arr));
	}
	//将一个数组调整成一个大顶堆
	/**
	 * 功能：将以i节点为跟的子树调整为大顶堆
	 * @param arr 数组
	 * @param i 非叶子节点 在数组中的索引
	 * @param length 有多少个非叶子节点
	 */
	public static void adjustHeap(int[] arr,int i ,int length) {
		//取出当前元素的值
		int temp = arr[i];
		//开始调整
		//1.k 是 i节点的左子节点
		for(int k = i * 2 + 1;k < length; k = k * 2 + 1) {
			if( arr[k] < arr[k+1] && k + 1 < length ) {//左子节点的值小于右子节点
				k++;//指向右子节点
			}
			if(arr[k] > temp) {//子节点大于父节点
				arr[i] = arr[k];//将较大的值赋给父节点
				i = k;//i指向k 继续循环比较
			}else {
				break;
			}
		}
		//结束循环后 已经将以i为父节点的树调整完毕
		arr[i] = temp;//将temp的值放到调整后的位置
	}
}
