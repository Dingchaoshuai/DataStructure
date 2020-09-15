package search;

public class InsertValueSearch {
	public static void main(String[] args) {
		int[] arr = new int[100];
		//生成1-100
		for (int i = 0; i < 100; i++) {
			arr[i] = i+1;
		}
		int index = insertValueSearch(arr, 0, arr.length - 1 , 59);
		System.out.println(index);
	}
	
	//编写插值查找算法
	/**
	 * 对于数据量大 ，关键字分布均匀 插值查找可能不二分快
	 * @param arr
	 * @param left 左边索引
	 * @param right 右边索引
	 * @param value
	 * @return -1 未找到
	 */
	public static int insertValueSearch(int[] arr,int left ,int right,int findvalue) {
		//findvalue < arr[0] || findvalue > arr[arr.length-1] 必须需要 否则得到的mid 可能越界
		if(left > right || findvalue < arr[0] || findvalue > arr[arr.length-1]) {
			return -1;
		}
		int mid = left + (right - left)*(findvalue - arr[left])/(arr[right] - arr[left]);
		int midValue  = arr[mid];
		if(findvalue > midValue) {
			return insertValueSearch(arr, mid + 1, right, findvalue);
		}else if( findvalue < midValue) {
			return insertValueSearch(arr, left, mid - 1, findvalue);
		}else {
			return mid;
		}
			
	}
}
