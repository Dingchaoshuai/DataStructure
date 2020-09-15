package stack;

public class ArrayStackDemo {
	private void mian() {
		// TODO Auto-generated method stub
		
	}
}
class ArrayStack{
	private int maxSize;
	private int[] stack;
	private int top = -1;
	
	public ArrayStack(int maxSize) {
		this.maxSize = maxSize;
		stack = new int[maxSize];
	}
	public boolean isFull() {
		return top == maxSize - 1;
	}
	
	public boolean isEmpty() {
		return top == -1;
	}
	
	public void push(int value) {
		if(isFull()) {
			System.out.println("满");
			return;
		}
		top++;
		stack[top] = value;
	}
	
	public int pop() {
		if(isEmpty()) {
			throw new RuntimeException("栈空");
		}
		int value  = stack[top];
		top--;
		return value;
	}
	//从栈顶开始显示
	public void list() {
		if(isEmpty()) {
			System.out.println("空");
			return ;
		}
		
		for(int i = top; i >= 0; i--) {
			System.out.println(stack[i]);
		}
	}
}

