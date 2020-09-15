package sort;

import java.util.Arrays;

/**
 * 1.选择排序一共有数组大小-1轮排序
 * 2.每一个排序又是一个循环，规则如下
 * 	2.1先假定当前的数是最小的
 * 	2.2然后和后面的数比较，如果发现有比当前数小（大），就重新确定最小数，并得到下标
 * 	2.3当遍历完时，得到本轮最小数和下标
 * 	2.4交换
 * @author DC
 *
 */
public class SimpleSelectionSort {
	public static void main(String[] args) {
		int[] arr= {101,34,119,1};
		selectSort(arr);
	}
	public static void selectSort(int arr[]) {
		
		//假定第一个数是最小值
		for(int i = 0;i < arr.length;i++) {
			int minIndex = i;
			int min = arr[minIndex];
			for(int j = i+1; j <arr.length; j++ ) {
				if(min>arr[j]) {//min不是最小数
					minIndex = j;
					min = arr[j];
				}
			}
			if(minIndex!=i) {
				arr[minIndex] = arr[i];
				arr[i] = min;
			}
			System.out.println("第"+(i+1)+"轮");
			System.out.println(Arrays.toString(arr));
		}
	}
	
}
