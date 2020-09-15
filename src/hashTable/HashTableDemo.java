package hashTable;

import java.util.Scanner;

/**
 * 一个公司 当有新员工来报道时，要求将该员工的信息加入（id,gender，age，name，address），当输入员工id时，要求查找到该员工的所有信息
 * 要求不使用数据库，速度越快越好
 * @author DC
 *
 */
public class HashTableDemo {

	public static void main(String[] args) {
		HashTable hashTable = new HashTable(7);
		
		//写个菜单
		String key = "";
		Scanner scanner = new Scanner(System.in);
		while(true) {
			System.out.println("add:");
			System.out.println("list:");
			System.out.println("exit:");
			key = scanner.next();
			switch (key) {
			case "add":
				System.out.println("输入id");
				int id  = scanner.nextInt();
				System.out.println("输入姓名");
				String name = scanner.next();
				//创建雇员
				Emp emp = new Emp(id,name);
				hashTable.add(emp);
				break;
			case "list":
				hashTable.list();
				break;
			case "exit":
				scanner.close();
				System.exit(0);
			case "find":
				System.out.println("请输入要查找的id");
				id = scanner.nextInt();
				hashTable.findEmpById(id);
				break;
			default:
				throw new IllegalArgumentException("Unexpected value: " + key);
			}
		}
	}
}
//创建hashtable
class HashTable {
	private EmpLinkedList[] empLinkedListArray;
	private int size;//表示共有多少条链表
	//构造器
	public HashTable(int size) {
		
		//初始化empLinkedListArray
		this.size = size;
		empLinkedListArray = new EmpLinkedList[size];
		//分别初始化 每一个链表 ！重要
		for (int i = 0; i < size; i++) {
			empLinkedListArray[i] = new EmpLinkedList();
			
		}
	}
	
	//添加员工
	public void add(Emp emp) {
		//根据员工id，得到该员工应当添加到哪条链表
		int empLinkedListNO = hashFun(emp.id);
		//将emp添加到对应的链表中
		empLinkedListArray[empLinkedListNO].add(emp);
	}
	
	//遍历所有链表
	public void list() {
		for (int i = 0; i < size; i++) {
			empLinkedListArray[i].list(i);
		}
	}
	
	//根据输入的id查找
	public void findEmpById(int id) {
		int empLinkedListNo = hashFun(id);
		Emp emp = empLinkedListArray[empLinkedListNo].findEmpById(empLinkedListNo);
		if(emp != null) {
			System.out.println("在第"+(empLinkedListNo+1)+"找到");
		}else {
			System.out.println("没有找到");
		}
	}
	
	//散列函数
	public int hashFun(int id) {
		return id % size;
	}
}

//表示雇员
class Emp{
	public int id;
	public String name;
	public Emp next;
	public Emp(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	@Override
	public String toString() {
		return "Emp [id=" + id + ", name=" + name + ", next=" + next + "]";
	}
	
	
}
//创建EmpLinkedList，表示链表
class EmpLinkedList{
	//头指针，直接指向第一个Emp
	private Emp head;
	
	//添加到链表 
	//1.假设添加到最后 id自增长
	public void add(Emp emp) {
		//如果是第一个雇员
		if(head == null) {
			head = emp;
			return ;
		}
		//如果不是第一个雇员，则使用辅助指针，帮助定位到最后
		Emp curEmp = head;
		while(true ) {
			if(curEmp.next == null) {//说明到链表最后
				break;
			}
			curEmp = curEmp.next;//后移
		}
		//退出时，将emp加入链表
		curEmp.next = emp;
 	}
	
	public void list(int no) {
		if(head == null) {
			System.out.println("第" +(no+1)+ "链表为空");
			return;
		}
		System.out.print("第" +(no+1)+ "链表信息为=>");
		Emp curEmp = head;
		while(true ) {
			System.out.print(curEmp.toString());
			if(curEmp.next == null ) {//
				break;
			}
			curEmp = curEmp.next;
		}
	}
	
	//查找雇员
	//找到返回emp 没找到返回null;
	public Emp findEmpById(int id) {
		if(head == null ) {
			System.out.println("链表为空");
			return null;
		}
		Emp curEmp = head;
		while(true) {
			if(curEmp.id == id) {//找到
				break;
			}
			if(curEmp.next ==null) {//遍历完都没要找到
				curEmp = null;
				break;
			}
			curEmp  = curEmp.next;
		}
		return curEmp;
	}
}