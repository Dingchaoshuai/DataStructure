package sort;

import java.util.Arrays;

public class InsertSort {
	public static void main(String[] args) {
		int[] arr= {101,34,9,1};
		insertSort(arr);
	}
	
	public static void insertSort(int[] arr) {
		/*//第一轮
		//{101,34,119,1}--》{34，101，119，1}
		//定义待插入的数
		int insertVal = arr[1];
		int insertIndex = 1 - 1;//即arr[1]前面的数的下标
		//给insertVal找到插入位置
		//1.insertIndex >=0保证在给insertVal找插入位置，不越界
		//2.insertVal<arr[insertIndex] ,待插入的数还没找到位置
		//3.将arr[insertIndex]后移
		while(insertIndex >=0 && insertVal <arr[insertIndex]) {
			arr[insertIndex + 1]  = arr[insertIndex];
			insertIndex--;
		}
		//退出while循环时，说明找到插入位置insertIndex+1
		arr[insertIndex + 1] = insertVal;
		*/
		
		
		//使用for循环
		for(int i = 1;i< arr.length;i++) {
			int insertVal = arr[i];
			int insertIndex = i - 1;
			while(insertIndex >=0 && insertVal <arr[insertIndex]) {
				arr[insertIndex + 1]  = arr[insertIndex];
				insertIndex--;
			}
			arr[insertIndex + 1] = insertVal;
			System.out.println(Arrays.toString(arr));
		}
	} 
}
