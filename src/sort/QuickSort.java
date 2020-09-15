package sort;

import java.util.Arrays;

public class QuickSort {

	public static void main(String[] args) {
		int[] arr = {-9,78,0,23,-567,70,11,23,36524,123,56,-123,-23};
		quickSort(arr, 0, arr.length-1);
		System.out.println(Arrays.toString(arr));
	}
	public static void quickSort(int[] arr,int l ,int r) {
		if(l < r) {
			int i = l;
			int j = r;
			int x = arr[i];
			while(i < j) {
				//从右向左找到小于x 的数来填充arr[l]
				while(i < j && arr[j]>=x) {
					//找到 r-1
					j--;
				}
				//把找到的这个数填充道a[l]，先判断r--后l r是否相等
				if(i < j) {
					arr[i] = arr[j];
					i++;
				}
				
				while(i< j && arr[i] < x) {
					i++;
				}
				if(i < j) {
					arr[j] = arr[i];
					j--;
				}
			}
			arr[i]= x;
			quickSort(arr, l, i-1);
			quickSort(arr, i+1, r);
		}
	}
//https://blog.csdn.net/MoreWindows/article/details/6684558?utm_medium=distribute
//.pc_relevant.none-task-blog-BlogCommendFromMachineLearnPai2-2.channel_param&depth_1-utm_source=distribute
//.pc_relevant.none-task-blog-BlogCommendFromMachineLearnPai2-2.channel_param
}
