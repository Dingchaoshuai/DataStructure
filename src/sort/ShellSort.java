package sort;

public class ShellSort {
	public static void main(String[] args) {
		int[] arr = {8,9,1,7,2,3,5,4,0};
	}
	public static void ShellSort(int arr[]) {
		
		//第一轮：将10个数据分成5组
		/*int temp = 0;
		for(int i =5;i<arr.length;i++) {
			//遍历各组中所有的 元素，步长5
			for(int j = i-5;j >= 0;j-=5) {
				if(arr[j] > arr[j+5]) {
					//如果当前元素大于同组的那个数，则交换
					temp = arr[j];
					arr[j] = arr[j+5];
					arr[j+5] = temp;
				}
			}
		}
		*/
		//交换法
		for(int gap = arr.length/2;gap > 0;gap /=2 ) {
			int temp = 0;
			for(int i =gap;i<arr.length;i++) {
				//遍历各组中所有的 元素，步长gap
				for(int j = i-gap;j >= 0;j-=gap) {
					if(arr[j] > arr[j+gap]) {
						//如果当前元素大于同组的那个数，则交换
						temp = arr[j];
						arr[j] = arr[j+gap];
						arr[j+gap] = temp;
					}
				}
			}
		}
	}
	//移动法
	public static void ShellSort2(int[] arr) {
		
		for(int gap = arr.length/2;gap > 0;gap /=2 ) {
			//对第gap个元素，逐个对其所在的组进行直接插入排序
			for(int i =gap;i < arr.length;i++) {
				int j =i;
				int temp = arr[j];
				if(arr[j] < arr[j-gap]) {
					while(j-gap >=0 && temp < arr[j-gap]) {
						//移动
						arr[j] = arr[j-gap];
						j -= gap;
					}
					//退出循环后，就给temp找到位置
					arr[j] = temp;
				}
			}
		}
	}
}
