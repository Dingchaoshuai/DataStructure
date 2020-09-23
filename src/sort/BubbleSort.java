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
		int arr[] = {6,4,7,5,1,3,2};
		
		//·过程 从小到大
		int temp = 0;
		//·优化：定义一个标识变量,
		boolean flag = false;
		//·记录最后依次交换的位置
		int tempPosition = 0;
		int len = arr.length-1;
		for(int i = 0;i < arr.length-1 ; i++) {
			
			for(int j = 0;j < len ;j++) {//·循环到最后一次交换的位置就行
				if(arr[j]<arr[j+1]) {
					//·进行了交换 设置flag=true
					flag=true;
					temp = arr[j];
					arr[j] = arr[j+1];
					arr[j+1] = temp;
					tempPosition = j;
				}
				System.out.print("第" + (i + 1) + "趟" + "第" + (j + 1) + "次结果");
				System.out.print(Arrays.toString(arr));
				System.out.println();
			}
			len = tempPosition;
			System.out.print("第"+ (i + 1) +"趟最终：");
			System.out.print(Arrays.toString(arr));
			System.out.println();
			if(!flag) {//·没有进行交换  说明已经有序
				
				break;
			}else {
				flag = false;//·重置flag
			}
		}
		System.out.println(Arrays.toString(arr));
	}
}
