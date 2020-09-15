package tree.threaded;
/**
 * 线索二叉树
 * @author DC
 *
 */
public class ThreadedBinaryTreeDemo {

	public static void main(String[] args) {
		HeroNode root= new HeroNode(1, "tom");
		HeroNode node2= new HeroNode(3, "jack");
		HeroNode node3= new HeroNode(6, "smith");
		HeroNode node4= new HeroNode(8, "mary");
		HeroNode node5= new HeroNode(10, "king");
		HeroNode node6= new HeroNode(14, "dim");
		
		//创建二叉树
		root.setLeft(node2);
		root.setRight(node3);
		node2.setLeft(node4);
		node2.setRight(node5);
		node3.setLeft(node6);
		
		//测试线索化
		BinaryTree binaryTree = new BinaryTree();
		binaryTree.setRoot(root);
		binaryTree.threadedNodes();
		
		//测试 以10为例
		/*
		HeroNode left = node5.getLeft();
		System.out.println(left);
		HeroNode right = node5.getRight();
		System.out.println(right);
		*/
		//使用线索化的方式遍历线索化二叉树
		binaryTree.threadedList();
	}

}
//构建树 实现类线索化功能
class BinaryTree{
	private HeroNode root;
	
	//为了实现线索化，需要创建一个指向当前节点的前驱节点的指针
	//pre总是保留前一个节点
	private HeroNode pre = null;
	public void setRoot(HeroNode root) {
		this.root = root;
	}
	public void threadedNodes() {
		this.threadedNodes(root);
	}
	//遍历线索化二叉树的方法
	public void threadedList() {
		//定义一个变量，存储当前遍历的节点从root开始
		HeroNode node = root;
		while( node != null) {
			//循环找到lefttype ==1 的节点，
			//后面随着遍历而变化，因为当lefttype ==1 时，说明该节点是按照线索化处理后的节点
			while(node.getLeftType() == 0) {
				node = node.getLeft();
			}
			
			//退出后 找到节点打印
			System.out.println(node);
			
			//如果当前节点的右指针指向的是后节点 
			while(node.getRightType() ==1) {
				node = node.getRight();
				System.out.println(node);
			}
			//退出后，表示右指针指向右子树
			node  = node.getRight();
		}
	}
	//编写中序线索化方法/
	/**
	 * 
	 * @param node 当前需要线索化的节点
	 */
	public void threadedNodes(HeroNode node) {
		//如果node =null 不需要线索化
		if(node == null) {
			return ;
		}
		//(一)线索化左子树
		threadedNodes(node.getLeft());
		//(二)线索化当前节点
		//1.处理当前节点的前驱节点
		if(node.getLeft() == null) {
			//让当前节点的左指针指向前驱节点
			node.setLeft(pre);
			node.setLeftType(1);
		}
		//2.处理后继节点
		if(pre != null && pre.getRight()== null) {
			//让前驱节点的右指针指向当前节点
			pre.setRight(node);
			pre.setRightType(1);;
		}
		//!!!! 每处理一个节点后 ，让当前节点是下一个节点的前驱节点
		pre = node;
		//(三)线索化右子树
		threadedNodes(node.getRight());
	}
	//整个树的前序遍历
	public void preOrder() {
		if(this.root != null) {
			this.root.preOrder();
		}else {
			System.out.println("空");
		}
	}
	//中
	public void infixOrder() {
		if(this.root != null) {
			this.root.infixOrder();
		}else {
			System.out.println("空");
		}
	}
	//后
	public void postOrder() {
		if(this.root != null) {
			this.root.postOrder();
		}else {
			System.out.println("空");
		}
	}
	//查找
	public HeroNode preOrderSearch(int no) {
		if(this.root != null) {
			HeroNode node = this.root.preOrderSearch(no);
			return node;
		}else {
			return null;
		}
	}
	//删除
	public void delNode(int no) {
		if(root != null) {
			if(root.getNo() == no) {//root节点就是要删除 的节点
				root =null;
			}else {
				root.delNode(no);
			}
		}else {
			System.out.println("空树");
		}
	}
}
class HeroNode{
	private int no;
	private String name;
	private HeroNode left;
	private HeroNode right;
	//0:表示指向左子树，1:表示指向前驱节点
	private int leftType;
	private int rightType;
	public int getLeftType() {
		return leftType;
	}
	public void setLeftType(int leftType) {
		this.leftType = leftType;
	}
	public int getRightType() {
		return rightType;
	}
	public void setRightType(int rightType) {
		this.rightType = rightType;
	}

	public HeroNode(int no, String name) {
		super();
		this.no = no;
		this.name = name;
	}
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public HeroNode getLeft() {
		return left;
	}
	public void setLeft(HeroNode left) {
		this.left = left;
	}
	public HeroNode getRight() {
		return right;
	}
	public void setRight(HeroNode right) {
		this.right = right;
	}
	@Override
	public String toString() {
		return "HeroNode [no=" + no + ", name=" + name + "]";
	}
	
	
	//编写前序遍历的方法
	public void preOrder() {
		//先输出父节点
		System.out.println(this);
		//向左子树递归前序遍历
		if(this.left != null) {
			this.left.preOrder();
		}
		if(this.right != null) {
			this.right.preOrder();
		}
	}
	//中序
	public void infixOrder() {
		//递归向左子树中序遍历
		if(this.left != null) {
			this.left.infixOrder();
		}
		//输出父节点
		System.out.println(this);
		//递归向右子树中序遍历
		if(this.right != null) {
			this.right.infixOrder();
		}
	}
	//后序
	public void postOrder() {
		//左
		if(this.left != null){
			this.left.postOrder();
		}
		//右
		if(this.right != null) {
			this.right.postOrder();
		}
		//父节点
		System.out.println(this);
	}
	/**
	 * 
	 * @param no
	 * @return 找到返回node 没有找到返回null
	 */
	//前序遍历查找
	public HeroNode preOrderSearch(int no) {
		//比较当前节点
		if(this.no == no) {
			return this;
		}
		
		//1.判断当前节点的左子节点是否为空，如果不为空，则递归查找
		//2.找到则返回
		HeroNode resHeroNode = null;
		if(this.left != null) {
			resHeroNode = this.left.preOrderSearch(no);
		}
		
		if(resHeroNode != null) {//说明左边找到
			return resHeroNode;
		}
		
		//向右
		if(this.right != null) {
			resHeroNode = this.right.preOrderSearch(no);
		}
		return resHeroNode;
	}
	
	//递归删除节点
	//1.如果是叶子节点就删除该节点
	//2.如果是非叶子节点就删除该子树
	//思路
	/* 
	 * 1.因为树是单向的，所以是判断当前节点的子节点是否需要被删除，而不是判断当前节点
	 * 2.如果当前节点左子节点不为空，并且左子节点就是要删除的节点，就将this.left =null,并返回
	 * 3.如果当前节点右子节点不为空，并且右子节点就是要删除的节点，就将this.right =null,并返回
	 * 4.如果23步没有删除节点，就需要向左子树递归删除
	 * 5.如果4没有删除节点，就需要向右子树递归删除
	 * 
	 */
	public void delNode(int no) {
		//左2
		if(this.left != null && this.left.no == no) {
			this.left =null;
			return ;
		}
		
		//右3
		if(this.right != null && this.right.no == no) {
			this.right =null;
			return ;
		}
		//4 向左递归
		if(this.left != null) {
			this.left.delNode(no);
		}
		//5.向右递归
		if(this.right != null) {
			this.right.delNode(no);
		}
	}
}