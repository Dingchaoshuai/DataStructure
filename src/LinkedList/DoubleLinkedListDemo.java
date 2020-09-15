package LinkedList;

public class DoubleLinkedListDemo {

}
class DoubleLinkedList{
	private HeroNode2 head = new HeroNode2(0, "");
	//添加
	public void add(HeroNode2 node) {
		//需要一个辅助节点
		HeroNode2 temp = head;
		//遍历链表找到最后
		while(true) {
			if(temp.next == null) {
				break;
			}
			temp = temp.next;
		}
		//退出循环后  temp指向链表最后
		temp.next = node;
		node.pre = temp;
	}
	
	
	//显示链表
		public void show() {
			//先判断链表是否为空
			if(head.next == null) {
				System.out.println("空");
				return ;
			}
			//因为头节点不能动，因此用一个辅助变量
			HeroNode2 temp = head.next;
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
class HeroNode2{
	public int no;
	public String name;
	public HeroNode2 next;
	public HeroNode2 pre;
	public HeroNode2(int no, String name) {
		super();
		this.no = no;
		this.name = name;
	}
	@Override
	public String toString() {
		return "HeroNode2 [no=" + no + ", name=" + name + "]";
	}
	
	
	
}