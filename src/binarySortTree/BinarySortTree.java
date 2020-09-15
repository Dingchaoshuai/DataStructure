package binarySortTree;

public class BinarySortTree {

	public static void main(String[] args) {
		int[] arr= {7,3,10,12,5,1,9};
		BST bst = new BST();
		//循环把节点加入树
		for(int i =0;i<arr.length;i++) {
			bst.add(new Node(arr[i]));
		}
		System.out.println("中序");
		bst.infixOrder();
		
		bst.delNode(12);
		System.out.println("删除2");
		bst.infixOrder();
	}

}
//创建二叉排序树
class BST{
	private Node root;
	//查找要删除的节点
	public Node search(int value) {
		if(root ==null) {
			return null;
		}else {
			return root.search(value);
		}
	}
	
	/**
	 * 返回以node为根节点的二叉排序树的最小的节点
	 * 删除node为根节点的二叉排序树的最小节点
	 * @param node 传入的节点当作二叉排序树的根节点
	 * @return 返回以node为根节点的二叉排序树的最小的节点
	 */
	public int delRightTreeMin(Node node) {
		Node target = node;
		//循环查找左子节点，就会找到最小值
		while(target.leftNode != null) {
			target = target.leftNode;
		}
		//循环结束后 target指向最小节点
		delNode(target.value);
		return target.value;
	}
	
	//查找父节点
	public Node searchParent(int value) {
		if(root ==null) {
			return null;
		}else {
			Node node = root.searchParent(value);
			return node;
		}
	}
	//添加节点
	public void add(Node node){
		if(root == null) {
			root = node;
		}else{
			root.add(node);
		}
	}
	
	//删除叶子节点
	public void delNode(int value) {
		if(root == null) {
			return ;
		}else {
			Node targetNode = search(value);
			if(targetNode == null) {
				//没有要删除的节点
				return ;
			}
			//BST只有一个几点
			if(root.leftNode == null && root.rightNode == null) {
				root = null;
				return;
			}
			
			Node parent = searchParent(value);
			
			//如果要删除的节点是叶子节点
			if(targetNode.leftNode == null && targetNode.rightNode == null) {
				//判断targetNode是父节点的左子节点还是右子节点
				if(parent.leftNode != null && parent.leftNode.value == value) {
					//左
					parent.leftNode = null;
				}else if(parent.rightNode != null && parent.rightNode.value == value) {
					parent.rightNode = null;
				}
			}else if(targetNode.leftNode != null && targetNode.rightNode != null) {
				//有两颗子树
				int minVal = delRightTreeMin(targetNode.rightNode);
				targetNode.value = minVal;
			}else {
				//只有一颗子树
				//如果要删除的节点有左子节点
				if(targetNode.leftNode != null) {
					if(parent != null) {
						
						if(parent.leftNode.value == value) {
							//如果targetNode是parent 的左子节点
							parent.leftNode = targetNode.leftNode;
						}else {
							//如果targetNode是parent 的右子节点
							parent.rightNode = targetNode.leftNode;
						}
					}else {
						root = targetNode.leftNode;
					}
					//如果要删除的节点有右子节点
				}else {
					if(parent != null) {
						
						if(parent.leftNode.value == value) {
							//如果targetNode是parent 的左子节点
							parent.leftNode = targetNode.rightNode;
						}else {
							//如果targetNode是parent 的右子节点
							parent.rightNode = targetNode.rightNode;
						}
					}else {
						root = targetNode.rightNode;
					}
				}
			}
		}
	}
	//中序遍历
	public void infixOrder() {
		if(root != null){
			root.indixOrder();
		}else {
			System.out.println("空");
		}
	}
	
	
	
}
class Node{
	int value;
	Node leftNode;
	Node rightNode;
	public Node(int value) {
		super();
		this.value = value;
	}
	/**
	 * 查找要删除的节点
	 * @param value 需要删除的值
	 * @return 找到返回该节点，未找到返回null
	 */
	public Node search(int value) {
		if(value == this.value) {//找到
			return this;
		} else if(value < this.value) {//查找到的值 小于当前节点，向左子树递归查找
			//左子节点为空
			if(this.leftNode == null) {
				return null;
			}
			return this.leftNode.search(value);
			
		}else {//查找到的值 大于当前节点，向左子树递归查找
			if(this.rightNode == null) {
				return null;
			}
			return this.rightNode.search(value);
		}
		
	}
	/**
	 * 
	 * @param value
	 * @return 要删除节点的父节点
	 */
	public Node searchParent(int value) {
		if((this.leftNode != null && this.leftNode.value == value ) || (this.rightNode != null && this.rightNode.value == value )) {
			return this;
		}else {
			////如果查找的值小于当前节点的值，并且当前节点的左子节点不为空
			if(value < this.value && this.leftNode != null) {
				return this.leftNode.searchParent(value);//向左递归查找
			}else if(value >= this.value && this.rightNode !=null) {//向右递归查找
					return this.rightNode.searchParent(value);
			}else {
				return null;
			}
		}
	}
	
	@Override
	public String toString() {
		return "Node [value=" + value + "]";
	}


	//添加节点的方法 需要满足二叉排序树要求
	public void add(Node node) {
		if(node == null) {
			return ;
		}
		//判断传入节点的value 和当前根节点的大小关系
		if(node.value < this.value) {
			if(this.leftNode == null) {
				this.leftNode = node;
			}else {
				//向左子树递归添加
				this.leftNode.add(node);
			}
		}else {
			if(this.rightNode == null) {
				this.rightNode = node;
			}else {
				//向右子树递归添加
				this.rightNode.add(node);
			}
		}
	}
	
	//中序遍历
	public void indixOrder() {
		if(this.leftNode != null) {
			this.leftNode.indixOrder();
		}
		System.out.println(this);
		if(this.rightNode != null) {
			this.rightNode.indixOrder();
		}
	}

}