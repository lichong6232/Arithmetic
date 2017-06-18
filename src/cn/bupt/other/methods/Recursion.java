package cn.bupt.other.methods;

import java.io.ObjectInputStream.GetField;
import java.util.ArrayList;
import java.util.List;

import cn.bupt.queue.ChainQueue;

public class Recursion {

	public static List<String> doAnagrama(ChainQueue queue){
		List<String> result=new ArrayList<String>();
		if(queue.size()==1){
			result.add(queue.peek()+"");
			return result;
		}else{
			for(int i=0;i<queue.size();i++){
				String s=queue.pop()+"";
				List<String> other=doAnagrama(queue);
				for(int j=0;j<other.size();j++){
					result.add(s+other.get(j));
				}
				queue.push(s);
			}
			
			
			return result;
		}
		
	}
	
	public static void main(String[] args) {
		ChainQueue queue=new ChainQueue();
		queue.push("l");
		queue.push("i");
		queue.push("c");
		queue.push("h");
		queue.push("o");
		queue.push("n");
		queue.push("g");
		List<String> result= doAnagrama(queue);
		int i=1;
		if(result!=null){
			for(String s:result){
				System.out.println((i++)+":"+s);
			}
		}
	}
}
