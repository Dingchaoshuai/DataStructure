package LinkedList;

import java.util.Stack;

public class SingleLinkedListDemo {
	public static void main(String[] args) {
		//先创建几个节点
		HeroNode heroNode1 = new HeroNode(1, "Tom");
		HeroNode heroNode2 = new HeroNode(2, "Jerry");
		HeroNode heroNode3 = new HeroNode(3, "Lucy");
		HeroNode heroNode4 = new HeroNode(4, "Smith");
		
		singleLinkedList singleLinkedList = new singleLinkedList();
//		singleLinkedList.add(heroNode1);
//		singleLinkedList.add(heroNode2);
//		singleLinkedList.add(heroNode3);
//		singleLinkedList.add(heroNode4);
		singleLinkedList.add2(heroNode4);
		singleLinkedList.add2(heroNode3);
		singleLinkedList.add2(heroNode2);
		singleLinkedList.add2(heroNode1);
		System.out.println("原来");
		singleLinkedList.show();
		//System.out.println("反转");
		//singleLinkedList.reverseList(singleLinkedList.getHead());
		//singleLinkedList.show();
		System.out.println("逆序打印");
		singleLinkedList.reversePrint(singleLinkedList.getHead());
	}
}
//定义一个singlerLinkedList
class singleLinkedList{
	//初始化一个头节点
	private HeroNode head = new HeroNode(0, "");
	public HeroNode getHead() {
		return head;
	}

	public void setHead(HeroNode head) {
		this.head = head;
	}
	
	
	//使用栈 逆序打印链表
	public static void reversePrint(HeroNode head) {
		//递归
		//if(head != null) {
		//	reversePrint(head.next);
		//	System.out.println(head);
		//}
		//栈
		//创建一个栈 将各个节点压入栈
		if(head.next == null) {
			return ;
		}
		Stack<HeroNode> stack = new Stack<HeroNode>();
		HeroNode  cur = head.next;
		while(cur != null) {
			stack.push(cur);
			cur = cur.next;
		}
		//打印
		while(stack.size() > 0) {
			System.out.println(stack.pop());
		}
		
	}
	//反转链表
	public static void reverseList(HeroNode head) {
		//如果当前链表为空 或者只有一个节点 直接返回
		if(head.next == null || head.next.next == null ) {
			return ;
		}
		
		HeroNode cur = head.next;//当前节点
		HeroNode next = null;//当前的下一个
		HeroNode reverseHead = new HeroNode(0, "");
		//遍历原来的链表
		//每遍历一个链表 就将其取出放在新链表的最前端
		while(cur != null) {
			next = cur.next;//先保存下一个节点
			cur.next = reverseHead.next;//将cur的下一个节点指向 的链表最前端
			reverseHead.next = cur;//将cur连接到心的链表上
			cur = next;//cur后移
		}
		
		head.next = reverseHead.next;
	}
	
	//添加 考虑编号顺序
	public  void add2(HeroNode node) {
		//辅助节点
		HeroNode temp = head;
		boolean flag = false;//标示编号是否存在
		while(true) {
			if(temp.next == null) {
				break;
			}
			if(temp.next.no > node.no) {
				break;
			}else if(temp.next.no == node.no) {//编号存在
				flag = true;
				break;
			}
			temp = temp.next;
		}
		//判断flag
		if(flag) {
			System.out.println("编号存在");
		}else {
			node.next = temp.next;
			temp.next = node;
		}
		
	}
	//添加
	//不考虑编号顺序时 找到当前链表最后一个节点 这个节点的next指向心得节点
	public void add(HeroNode node) {
		//需要一个辅助节点
		HeroNode temp = head;
		//遍历链表找到最后
		while(true) {
			if(temp.next == null) {
				break;
			}
			temp = temp.next;
		}
		//退出循环后  temp指向链表最后
		temp.next = node;
	}
	
	//显示链表
	public void show() {
		//先判断链表是否为空
		if(head.next == null) {
			System.out.println("空");
			return ;
		}
		//因为头节点不能动，因此用一个辅助变量
		HeroNode temp = head.next;
		while(true){
			//判断是否为空
			if(temp == null) {
				break;
			}
			System.out.println(temp);
			temp = temp.next;
		}
	}
}
//定义node
class HeroNode{
	public int no;
	public String name;
	public HeroNode next;
	public HeroNode(int no, String name) {
		super();
		this.no = no;
		this.name = name;
	}
	@Override
	public String toString() {
		return "HeroNode [no=" + no + ", name=" + name + "]";
	}
	
	
	
}