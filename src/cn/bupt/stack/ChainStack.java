package cn.bupt.stack;

public class ChainStack {
	
	class Node{
		private Object data;
		private Node next;
	}
	
	private Node top;
	private int size;
	
	public ChainStack() {
		top=new Node();
		size=0;
	}
	
	public void push(Object o){
		
		Node node=new Node();
		node.data=o;
		node.next=top.next;
		top.next=node;
		size++;
	}
	
	public Object pop(){
		if(top.next==null){
			try {
				throw new Exception("栈为空");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			return null;
		}else{
			size--;
			Node node=top.next;
			top.next=node.next;
			return node.data;
		}
	}
	

	public Object peek(){
		if(top.next==null){
			try {
				throw new Exception("栈为空");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return null;
		}else{
			Node node=top.next;
			return node.data;
		}
	}
	
	public boolean isEmpty(){
		return top.next==null;
	}
	
	public int size(){
		return this.size;
	}

}
