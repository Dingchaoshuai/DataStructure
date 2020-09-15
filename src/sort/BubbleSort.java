package sort;

import java.util.Arrays;

/**
 * 冒泡排序：两两比较相邻的记录，如果逆序则交换，直到没有交换为止
 * 	1. 一共进行数组大小-1次的循环
 * 	2.每一趟排序的次数在逐渐减少
 * 	3.如果发现在某趟排序中，没有发生一次交换，可以提前结束排序
 *  时间复杂度 O(n^2)
 * @author DC
 *
 */
public class BubbleSort {
	public static void main(String[] args) {
		int arr[] = {3,9,-1,10,-2};
		
		//过程 从小到大
		int temp = 0;
		//优化：定义一个标识变量,
		boolean flag = false;
		for(int i = 0;i < arr.length-1 ; i++) {
			
			for(int j = 0;j < arr.length-1-i ;j++) {
				if(arr[j]>arr[j+1]) {
					//进行了交换 设置flag=true
					flag=true;
					temp = arr[j];
					arr[j] = arr[j+1];
					arr[j+1] = temp;
				}
			}
			if(!flag) {
				break;
			}else {
				flag = false;//重置flag
			}
		}
		System.out.println(Arrays.toString(arr));
	}
}
