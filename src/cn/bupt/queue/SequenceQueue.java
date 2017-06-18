package cn.bupt.queue;

public class SequenceQueue {
	
	private int maxSize;
	private Object[] queue;
	private int top;
	private int end;
	private int tag;
	public SequenceQueue(int maxSize){
		tag=0;
		top=end=0;
		this.maxSize=maxSize;
		queue=new Object[maxSize];
	}
	
	
	
	public void push(Object o){
		if(isFull()){
			try {
				throw new Exception("队列已满");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else{
			queue[end++]=o;
			tag=1;
			end=end==maxSize?0:end;
		}
		
	}
	
	public Object pop(){
		
		if(isEmpty()){
			try {
				throw new Exception("队列为空");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return null;
		}else{
			
			tag=0;
			Object o=queue[top++];
			top=top==maxSize?0:top;
			return o;
		}
		
		
	}
	
	public Object peek(){
			
			if(isEmpty()){
				try {
					throw new Exception("队列为空");
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				return null;
			}else{
				
				tag=0;
				return queue[top];
			}
		
		
	}
	
	
	public boolean isEmpty(){
		
		
		return top==end&&tag==0;
	}
	
	public boolean isFull(){
		return top==end&&tag==1;
	}
	
	
	

}
