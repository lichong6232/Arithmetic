package cn.bupt.stack;

public class SequenceStack {
	
	private int maxSize;
	private Object[] stack;
	private int top;
	public SequenceStack(int maxSize) {
		super();
		top=-1;
		this.maxSize = maxSize;
		stack=new Object[this.maxSize];
	}
	
	public void push(Object o){
		if(top==maxSize-1){
			try {
				throw new Exception("栈已满，不可以插入数据");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else{
			stack[++top]=o;
		}
		
	}
	
	public boolean isEmpty(){
	
		return top==-1;
	}
	
	public boolean isFull(){
		return top==maxSize-1;
	}
	
	public Object pop(){
		if(top==-1){
			try {
				throw new Exception("当前栈为空，不可以进行删除栈顶元素的操作");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return null;
		}else{
			return stack[top--];
		}
		
	}
	
	public int size(){
		return top+1;
	}
	
	public Object peek(){
		
		if(top==-1){
			try {
				throw new Exception("当前栈为空");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return null;
		}else{
			return stack[top];
		}
	}
	
	
	
	
	
	

}
