 package tree;

import tree.BinaryTree;
import tree.HeroNode;

public class BinaryTreeDemo {
	public static void main(String[] args) {
		//先创建二叉树
		BinaryTree binaryTree = new BinaryTree();
		//创建需要的节点
		HeroNode root = new HeroNode(1, "Tom");
		HeroNode node2 = new HeroNode(2, "Jerry");
		HeroNode node3 = new HeroNode(3, "Smith");
		HeroNode node4 = new HeroNode(4, "Obama");
		
		//先手动创建二叉树
		root.setLeft(node2);
		root.setRight(node3);
		node3.setRight(node4);
		binaryTree.setRoot(root);
		//测试前序
		/*System.out.println("前序遍历");//1234
		binaryTree.preOrder();
		
		System.out.println("中序遍历");//2134
		binaryTree.infixOrder();
		
		System.out.println("后序遍历");//2431
		binaryTree.postOrder();*/
		
		/*测试查找
		System.out.println("前序遍历查找");
		HeroNode node = binaryTree.preOrderSearch(6);
		if(node != null) {
			System.out.println(node);
		}else {
			System.out.println("未找到");
		}*/
		
		//测试删除
		System.out.println("删除前");
		binaryTree.preOrder();
		binaryTree.delNode(3);
		System.out.println("删除后");
		binaryTree.preOrder();
	}
}

//构建树
class BinaryTree{
	private HeroNode root;
	public void setRoot(HeroNode root) {
		this.root = root;
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

//节点
class HeroNode{
	private int no;
	private String name;
	private HeroNode left;
	private HeroNode right;
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