package cn.bupt.queue;

public class SequenceQueue2 {
	
	private int maxSize;
	private Object[] queue;
	private int top;
	private int end;
	private int size;
	public SequenceQueue2(int maxSize){
		
		top=end=size=0;
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
			end=end==maxSize?0:end;
			size++;
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
			Object o=queue[top++];
			top=top==maxSize?0:top;
			size--;
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
				return queue[top];
			}
		
		
	}
	
	
	public boolean isEmpty(){
		
		
		return size==0;
	}
	
	public boolean isFull(){
		return size==maxSize;
	}
	
	
	

}
