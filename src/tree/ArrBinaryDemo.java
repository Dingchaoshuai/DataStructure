package tree;
/**
 * 以数组形式存储树(完全二叉树)
 * @author DC
 *
 */
public class ArrBinaryDemo {
	public static void main(String[] args) {
		int[] arr = {1,2,3,4,5,6,7};
		ArrBinaryTree arrBinaryTree = new ArrBinaryTree(arr);
		arrBinaryTree.preOrder(0);
	}
}
class ArrBinaryTree{
	private int[] arr;//存储数据节点的数组

	public ArrBinaryTree(int[] arr) {
		super();
		this.arr = arr;
	}
	//编写一个方法，完成顺序存储二叉树的前序遍历
	/**
	 * 
	 * @param index 表示数组下标
	 */
	public void preOrder(int index) {
		//如果数组为空，或者length=0
		if(arr ==null || arr.length == 0) {
			System.out.println("数组为空");
			return;
		}
		//输出当前元素
		System.out.println(arr[index]);
		//向左递归
		if((index * 2 +1) < arr.length) {
			preOrder(2 * index + 1 );
		}
		
		//向右递归
		if((index * 2 + 2 ) < arr.length) {
			preOrder(2 * index +2);
		}
	}
}
