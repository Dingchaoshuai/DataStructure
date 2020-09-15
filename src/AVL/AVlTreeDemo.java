package AVL;


public class AVlTreeDemo {
	public static void main(String[] args) {
		//int[] arr = {4,3,6,5,7,8};
		int[] arr = {10,12,8,9,7,6};
		//创建一个avltree
		AVLTree avlTree = new AVLTree();
		for(int i = 0 ; i < arr.length ;i++ ) {
			avlTree.add(new Node(arr[i]));
		}
		
		
		//遍历
		System.out.println("中序");
		avlTree.infixOrder();
		
		
		System.out.println("平衡处理后 ");
		System.out.println("树的高度"+avlTree.getRoot().height());
		System.out.println("左子树的高度"+avlTree.getRoot().leftNode.height());
		System.out.println("右子树的高度"+avlTree.getRoot().rightNode.height());
		System.out.println("当前根节点"+avlTree.getRoot());
	}
}
class AVLTree{
	private Node root;
	//查找要删除的节点
	public Node search(int value) {
		if(root ==null) {
			return null;
		}else {
			return root.search(value);
		}
	}
	
	public Node getRoot() {
		// TODO Auto-generated method stub
		return root;
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
	
	
	//返回以该节点为根节点的树的高度
	public int height() {
		return Math.max(leftNode == null ? 0 : leftNode.height(),rightNode == null ? 0 : rightNode.height()) + 1;
	}
	
	//左旋转方法
	public  void leftRotate() {
		//1.以当前根节点创建新的节点，
		Node newNode = new Node(value);
		
		//2.把新的节点的左子树设置成当前节点的左子树
		newNode.leftNode = this.leftNode;
		
		//3.把新的节点的右子树设置为当前节点的右子树的左子树
		newNode.rightNode = this.rightNode.leftNode;
		
		//4.把当前节点的值替换成右子节点的值
		this.value = this.rightNode.value;
		
		//5.把当前节点的右子节点设置成当前节点的右右节点
		this.rightNode = this.rightNode.rightNode;
		
		//6.把当前节点的左子节点，设置成新的节点
		this.leftNode = newNode;
	}
	
	public void rightRotate() {
		//1.以当前根节点创建新的节点，
		Node newNode = new Node(value);
				
		//2.把新的节点的右子树设置成当前节点的右子树
		newNode.rightNode = this.rightNode;
				
		//3.把新的节点的左子树设置为过去节点的右子树的左子树
		newNode.leftNode = this.leftNode.rightNode;
			
		//4.把当前节点的值替换成左子节点的值
		this.value = this.leftNode.value;
		
		//5.把当前节点的右子节点设置成当前节点的右右节点
		this.leftNode = this.leftNode.leftNode;
				
		//6.把当前节点的左子节点，设置成新的节点
		this.rightNode = newNode;
	}
	public int leftHeight() {
		if(leftNode == null) {
			return 0;
		}
		return leftNode.height();
	}
	public int rightHeight() {
		if(rightNode == null) {
			return 0;
		}
		return rightNode.height();
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
		
		//当添加完一个节点后，（右子树高度-左子树高度>1）--->左旋转
		if(rightHeight() - leftHeight() > 1) {
			//如果当前节点的右子树的左子树高度大于右子树高度
			if(rightNode != null && rightNode.leftHeight() > rightNode.rightHeight()) {
				rightNode.leftRotate();
				
				leftRotate();
			}else {
				
				leftRotate();
			}
			return ;
		}
		
		//当添加完一个节点后，（左子树高度-右子树高度>1）--->右旋转
		if(rightHeight() - leftHeight() < -1) {
			//如当前节点的左子树的右子树高度大于它的左子树高度  需要先对当前节点的右子树左旋
			if(leftNode != null && leftNode.rightHeight() > leftNode.leftHeight()) {
				leftNode.leftRotate();
				//再对当前节点右旋
				rightRotate();
			}else {
				rightRotate();
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