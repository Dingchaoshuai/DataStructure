package test;

public class A extends B {
	static {
		System.out.println("A静态块");
	}
	{
		System.out.println("A构造块");
	}
	public A() {
		System.out.println("A构造函数");
	}
	public static void main(String[] args) {
		System.out.println("main方法");
		A a = new A();
		System.out.println();
		B b = new B();
	}
}
class B{
	static {
		System.out.println("B静态块");
	}
	{
		System.out.println("B构造块");
	}
	public B() {
		System.out.println("B构造函数");
	}
}