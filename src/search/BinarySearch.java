package search;

import java.util.ArrayList;
import java.util.List;

/**
 * 二分查找：前提是数组是有序的
 * @author DC
 *
 */
public class BinarySearch {

	public static void main(String[] args) {
		int[] arr = {1,8,89,89,89,100,123};
		//无重复
		//int resIndex = binarySearch(arr, 0, arr.length-1, 89);
		//System.out.println(resIndex);
		//有重复
		List<Integer> resList = binarySearch2(arr, 0, arr.length-1, 89);
		System.out.println(resList);
	}
	
	
	public static int binarySearch(int[] arr,int left,int right,int findValue){
		int mid = (left + right) /2 ;
		int midValue = arr[mid];
		//没有找到 
		if(left > right) {
			return -1;
		}
		if(findValue > midValue) {//向右递归
			return binarySearch(arr, mid+1, right, findValue);
		}else if(findValue < midValue) {
			return binarySearch(arr, left, mid-1, findValue);
		}else {
			return mid;
		}
	}
	
	//有重复的数字 找到所有下标
	//思路：
	//1.在找到mid时 不要马上返回
	//2. 向mid左边扫描，找到数值 加入集合
	//3. 向右边扫描，加入集合
	public static ArrayList<Integer> binarySearch2(int[] arr,int left,int right,int findValue){
		int mid = (left + right) /2 ;
		int midValue = arr[mid];
		//没有找到 
		if(left > right) {
			return null;
		}
		if(findValue > midValue) {//向右递归
			return binarySearch2(arr, mid+1, right, findValue);
		}else if(findValue < midValue) {
			return binarySearch2(arr, left, mid-1, findValue);
		}else {
			ArrayList<Integer> list = new ArrayList<Integer>();
			int temp = mid - 1; 
			//向左扫描
			while(true) {
				if(temp < 0 || arr[temp] != findValue) {//左边没有满足的值 退出
					break;
				}
				list.add(temp);
				temp -=1;
			}
			list.add(mid);
			
			//向右扫描
			temp = mid + 1;
			while(true) {
				if(temp > arr.length-1 || arr[temp] != findValue) {//右边没有满足的值 退出
					break;
				}
				list.add(temp);
				temp +=1;
			}
			
			return list;
		}
	}
}
