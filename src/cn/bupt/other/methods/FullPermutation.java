package cn.bupt.other.methods;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class FullPermutation {
	
	public static void main(String[] args) {
		int n=3;
		int a[]={1,2,3,4,5};
//		for(int i=1;i<=n;i++){
//			a[i-1]=i;
//		}
		Set<String> result=getPermulationDictionary(a);
//		System.out.println(result.size());
		for(String s:result){
			System.out.println(s);
		}
		
	}
	
	public static void out(int a[]){
		for(int i:a){
			System.out.println(i+",");
		}
		System.out.println();
	}
	
	public void getPermutation(List<String> words,String preffix,Set<String> result){
		
		if(words.isEmpty()){
			result.add(preffix);
		}else{
			for(int i=0;i<words.size();i++){
				List<String> temp=new LinkedList<String>(words);
				String s=preffix+temp.remove(i);
				getPermutation(temp, s, result);
			}
		}
		
	}
	
	public static void swap(int a[],int i,int j){
		if(i!=j){
			a[i]=a[i]^a[j];
			a[j]=a[i]^a[j];
			a[i]=a[i]^a[j];
		}
		
	}
	
	
	public static String getValue(int a[]){
		StringBuffer sb=new StringBuffer();
		for(int i:a){
			sb.append(i);
		}
		return sb.toString();
	}
	
	public static void reverse(int a[],int start){
		int i=start;
		int j=a.length-1;
		while(i<j){
			swap(a, i, j);
			++i;
			--j;
		}
		
	}
	
	public static int lastIndex(int a[],int currentIndex){
		int lastIndex=currentIndex+1;
		int nowValue=a[currentIndex];
		while(lastIndex<a.length&&a[lastIndex]>nowValue){
			lastIndex++;
		}
		return lastIndex-1;
	}
	
	public static Set<String> getPermulationDictionary(int a[]){
		
		Set<String> set=new HashSet<String>();
		set.add(getValue(a));
		int length=a.length;
		while(true){
			int i=length-1;
			for(;i>0;i--){
				if(a[i-1]<a[i]){
					break;
				}
			}
			if(i==0){
				return set;
			}
			System.out.println("i:"+i);
			int lastIndex=lastIndex(a, i-1);
			swap(a, i-1, lastIndex);
			reverse(a, i);
			set.add(getValue(a));
		}
		
	}
	

}
