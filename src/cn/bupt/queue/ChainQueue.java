package cn.bupt.queue;

public class ChainQueue {
	
	private class Node{
		private Object data;
		private Node next;
	}
	
	private Node top;
	private Node end;
	private int size;
	public ChainQueue(){
		top=new Node();
		end=top;
	}
	
	public void push(Object o){
		Node node=new Node();
		node.data=o;
		end.next=node;
		end=node;
		size++;
	}
	

	
	public Object pop(){
		if(top.next==null){
			try {
				throw new Exception("队列为空");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return null;
		}else{
			Node node =top.next;
			top.next=node.next;
			size--;
			return node.data;
			
		}
	}
	
	public Object peek(){
		if(top.next==null){
			try {
				throw new Exception("队列为空");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return null;
		}else{
			return top.next.data;
			
		}
	}
	
	public int size(){
		return this.size;
	}
	
	public boolean isEmpty(){
		return top.next==null;
	}
	

}
