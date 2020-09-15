package HuffmanTree;

import java.util.ArrayList;
import java.util.Collections;

public class HuffmanTree {

	public static void main(String[] args) {
		int[] arr = {13,7,8,3,29,6,1};
		
		Node root = createHuffmanTree(arr);
		preOrder(root);
	}
	//创建huffman树的方法
	/**
	 * 
	 * @param arr
	 * @return 返回根节点
	 */
	public static Node createHuffmanTree(int[] arr) {
		//第一步为了操作方便
		//1.遍历arr数组
		//2.将arr的每个元素构成一个node
		//3.将node放入arraylist
		ArrayList<Node> nodes = new ArrayList<Node>();
		for(int value : arr) {
			nodes.add(new Node(value));
		}
		
		while(nodes.size() > 1) {//当nodes中只有一个节点时，说明处理完毕退出循环
			//排序从小到大
			Collections.sort(nodes);
			
			//取出根节点权值最小的两个二叉树节点
			Node leftNode = nodes.get(0);
			Node rightNode = nodes.get(1);
			Node parent =new Node(leftNode.value + rightNode.value);
			parent.left = leftNode;
			parent.right = rightNode;
			
			//从arraylist删除处理过的二叉树
			nodes.remove(leftNode);
			nodes.remove(rightNode);
			
			//将parent加入nodes
			nodes.add(parent);
			Collections.sort(nodes);
		}
		//返回huffman 的根
		return nodes.get(0);
	}
	
	//前序遍历的方法
	public static void preOrder(Node root) {
		if(root != null) {
			root.preOrder();
		}else {
			System.out.println("空树");
		}
	}

}
//创建节点类
//为了让node对象支持排序，需要实现comparable接口
class Node implements Comparable<Node>{
	int value;//节点权值
	Node left;//左子节点
	Node right;//右子节点
	public Node(int value) {
		this.value = value;
	}
	@Override
	public String toString() {
		return "Node [value=" + value + "]";
	}
	@Override
	public int compareTo(Node o) {
		// TODO Auto-generated method stub
		//表示从小到大
		return this.value - o.value;
	}
	
	//前序遍历
	public  void preOrder() {
		System.out.println(this);
		if(this.left != null) {
			this.left.preOrder();
		}
		if(this.right != null) {
			this.right.preOrder();
		}
	}
	
}