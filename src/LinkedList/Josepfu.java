package LinkedList;

/**
 * 约瑟夫问题
 * @param args
 */
public class Josepfu {
	public static void main(String[] args) {
		CircleLinkedList list = new CircleLinkedList();
		list.addBoy(5);
		list.show();
		
		list.countBoy(1, 2, 5);
	}
}

//创建环形链表
class CircleLinkedList{
	//创建first节点
	private Boy first = null;
	//添加
	public void addBoy(int nums) {
		if(nums < 1) {
			System.out.println("错误");
			return; 
		}
		
		Boy curBoy = null;//辅助变量
		for(int i = 1; i <= nums; i++) {
			//根据编号创建节点
			Boy boy = new Boy(i);
			//第一个 
			if(i == 1) {
				first = boy;
				first.setNext(first);//构成环
				curBoy = first;
			}else {
				curBoy.setNext(boy);
				boy.setNext(first);
				curBoy = boy;
			}
			
		}
	}
	
	//遍历
	public void show() {
		if(first == null) {
			System.out.println("空");
			return;
		}
		
		Boy curBoy = first;
		while(true) {
			System.out.println("小孩" + curBoy.getNo());
			if(curBoy.getNext() == first) {//说明已经遍历完
				break;
			}
			curBoy = curBoy.getNext();
		}
	}
	
	//根据用户输入 计算输出顺序
	/**
	 * 
	 * @param startNo 表示从第几个开始数
	 * @param countNum 表示数几下
	 * @param nums 小孩总共数量
	 */
	public void countBoy(int startNo, int countNum, int nums) {
		if(first ==null || startNo < 1 || startNo > nums) {
			System.out.println("输入错误");
			return ;
		}
		Boy helper = first;
		//将helper指向最后
		while(true) {
			if(helper.getNext() == first) {
				break;
			}
			helper = helper.getNext();
		}
		//报数前 将helper first移动 k-1次
		for(int j = 1; j < startNo; j++) {
			first = first.getNext();
			helper = helper.getNext();
		}
		
		//开始报数 移动m-1次
		while(true) {
			if(helper == first) {
				break;
			}
			
			//让first 和 helper移动
			for(int j = 1; j < countNum; j++) {
				first = first.getNext();
				helper = helper.getNext();
			}
			System.out.println(" 小孩" + first.getNo());
			first = first.getNext();
			helper.setNext(first);
		}
		System.out.println(" 最后小孩" + first.getNo());
	}
}

class  Boy{
	private int no;
	private Boy next;
	public Boy(int no) {
		this.no = no;
	}
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public Boy getNext() {
		return next;
	}
	public void setNext(Boy next) {
		this.next = next;
	}
}