package HuffmanCode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HuffmanCode {
	public static void main(String[] args) {
		String str = "i like like like java do you like a java";
		byte[] contentBytes = str.getBytes();
		System.out.println(contentBytes.length);
		
		List<Node> nodes = getNodes(contentBytes);
		System.out.println(nodes);
		
		//测试huffman树
		Node root = createHuffmanTree(nodes);
		root.preOrder();
	}
	private static List<Node> getNodes(byte[] bytes){
		//1.创建一个ArrayList
		ArrayList<Node> nodes = new ArrayList<Node>();
		
		//遍历 bytes 使用map存储每一个byte出现的次数 
		HashMap<Byte, Integer> counts = new HashMap<Byte, Integer>();
		for(byte b :bytes) {
			Integer count = counts.get(b);//尝试从map中获取该字母
			if(count == null) {//如果map中没有该字母
				counts.put(b,1);
			}else {
				counts.put(b,count + 1 );
			}
		}
		
		//把map中每一个键值对 转换为一个node对象，并加入到nodes集合中
		for (Map.Entry<Byte, Integer> entry : counts.entrySet()) {
			nodes.add(new Node(entry.getKey(),entry.getValue()));
		}
		return nodes;
	}
	
	//构建huffman树
	private  static Node createHuffmanTree(List<Node> nodes) {
		while(nodes.size() > 1) {
			Collections.sort(nodes);
			Node leftNode = nodes.get(0);
			Node rightNode = nodes.get(1);
			//创建一个新的父节点 没有权值
			Node parent = new Node(null,leftNode.weight + rightNode.weight);
			parent.left = leftNode;
			parent.right = rightNode;
			
			//移除
			nodes.remove(leftNode);
			nodes.remove(rightNode);
			
			//添加parent
			nodes.add(parent);
		}
		
		//返回最后的节点 
		return nodes.get(0);
	}
	
	public static void preOrder(Node root) {
		if(root !=null) {
			root.preOrder();
		}else {
			System.out.println("空");
		}
	}
}
//创建节点
class Node implements Comparable<Node>{
	Byte data;//存放数据本身
	int weight;//权值，出现的次数
	Node left;
	Node right;
	public Node(Byte data, int weight) {
		super();
		this.data = data;
		this.weight = weight;
	}
	@Override
	public String toString() {
		return "Node [data=" + data + ", weight=" + weight + "]";
	}
	@Override
	public int compareTo(Node o) {
		// TODO Auto-generated method stub
		return this.weight - o.weight;
	}
	
	//前序遍历
	public void preOrder() {
		System.out.println(this);
		if(this.left != null) {
			this.left.preOrder();
		}
		if(this.right != null){
			this.right.preOrder();
		}
	}
	
}