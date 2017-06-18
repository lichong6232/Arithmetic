package cn.bupt.other.methods;

import java.util.ArrayList;
import java.util.List;

public class KMP {
	
	
	public static void main(String[] args) {
		/*String s="BBC ABCDAB ABCDABCDABDE";
		String p="ABCDABD";
		int index=getIndex(s,p);
		System.out.println(index);*/
		String s="aaa";
		String p="aa";
		List<Integer> result=getIndexList(s, p);
		System.out.println(result);
		
	}
	
	public static List<Integer> getIndexList(String s,String pattern){
		List<Integer> result=new ArrayList<Integer>();
		int next[]=getNext(pattern);
		int sLength=s.length();
		int pLength=pattern.length();
		char c[]=s.toCharArray();
		char p[]=pattern.toCharArray();
		int i=0,j=0;
		while(i<sLength&&j<pLength){
			
			if(j==-1 || c[i]==p[j]){
				++i;
				++j;
			}else{
				j=next[j];
			}
			
			if(j==pLength){
				result.add(i-j);
				i=i-j+1;
				j=0;
			}
		}
		
		return result;
	}
	
	public static int getIndex(String s,String pattern){
		int next[]=getNext(pattern);
		int sLength=s.length();
		int pLength=pattern.length();
		char c[]=s.toCharArray();
		char p[]=pattern.toCharArray();
		int i=0,j=0;
		while(i<sLength&&j<pLength){
			
			if(j==-1 || c[i]==p[j]){
				++i;
				++j;
			}else{
				j=next[j];
			}
		}
		if(j==pLength){
			return i-j;
		}else{
			return -1;
		}
		
	}
	
	public static int[] getNext(String s){
		int sLength=s.length();
		int next[]=new int[sLength];
		char p[]=s.toCharArray();
		next[0]=-1;
		int k=-1;
		int j=0;
		while(j<sLength-1){
			if(k==-1||p[j]==p[k]){
				++j;
				++k;
				next[j]=k;
			}else{
				k=next[k];
			}
		}
		
		return next;
	}

}
