package cn.bupt.queue;

public class PrioritySequenceQueue{

	private int maxSize;
	private PriorityNode[] queue;
	private int top;
	private int end;
	private int tag;
	
	
	public PrioritySequenceQueue(int maxSize){
		tag=0;
		top=end=0;
		this.maxSize=maxSize;
		queue=new PriorityNode[maxSize];
	}
	
	public void push(PriorityNode o){
		if(isFull()){
			/*try {
				throw new Exception("队列已满");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}*/
//			end=end==0?maxSize:end;
			maxSize=2*maxSize;
			PriorityNode[] currentQueue=queue;
			queue=new PriorityNode[maxSize];
			int index=top;
			for(int i=0;i<currentQueue.length;i++){
				queue[i]=currentQueue[index];
				if(index++==maxSize-1){
					index=0;
				}
				
			}
			top=0;
			end=maxSize/2;
		}
		int temp=end;
		
		/*if(end<top){
			int nextTemp=temp-1;
			if(nextTemp<0){
				nextTemp=maxSize-1;
			}
			for(;temp<top&&queue[nextTemp].getKey()>o.getKey();temp--){
				nextTemp=temp-1;
				if(temp==0){
					nextTemp=maxSize-1;
				}
				if(temp<0){
					temp=maxSize-1;
				}
				queue[temp]=queue[nextTemp];
			}
		}else{
			for(;temp<top&&queue[temp-1].getKey()>o.getKey();temp--){
				queue[temp]=queue[temp-1];
			}
		}
		*/
		int nextTemp=temp-1;
		if(nextTemp<0){
			nextTemp=maxSize-1;
		}
		for(;temp!=top&&queue[nextTemp].getKey()>o.getKey();temp--){
			
			
			if(temp<0){
				temp=maxSize-1;
			}
			queue[temp]=queue[nextTemp];
			nextTemp--;
			if(nextTemp<0){
				nextTemp=maxSize-1;
			}
		}
		queue[temp]=o;
		end++;
		tag=1;
		end=end==maxSize?0:end;	
	}
	
	public PriorityNode pop(){
		
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
			PriorityNode o=queue[top++];
			top=top==maxSize?0:top;
			return o;
		}
		
		
	}
	
	public PriorityNode peek(){
			
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
