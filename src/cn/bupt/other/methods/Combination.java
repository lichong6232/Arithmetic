package cn.bupt.other.methods;

import java.util.HashSet;
import java.util.Set;

public class Combination {
	
	public static void main(String[] args) {
//		System.out.println(num2Binary(10, 4));
//		System.out.println((1<<3)-1);
		/*String word[]={"A","B","C","D","E","F","G","H","I","J","k","L","M","N","O","P","Q","R"};
		String result[]=getCombination(word);*/
		/*for(int i=0;i<result.length;i++){
			System.out.println(result[i]);
		}*/
		/*System.out.println(result.length);
		for(String s:result){
			System.out.println(s);
		}*/
		
		Set<String> set=getMFromN(3,5);
		System.out.println(set.size());
	
		
	}
	
	public static void move(int a[],int tag){
		int sum=0;
		for(int i=0;i<tag;i++){
			if(a[i]==1){
				++sum;
			}
		}
		
		for(int i=0;i<tag;i++){
			if(i<sum){
				a[i]=1;
			}else{
				a[i]=0;
			}
		}
		
	}
	
	public static String getValue(int a[]){
		StringBuffer sb=new StringBuffer();
		for(int i:a){
			sb.append(i);
		}
		return sb.toString();
	}
	
	public static Set<String> getMFromN(int m,int n){
		Set<String> set=new HashSet<String>();
		int temp[]=new int[n];
		for(int i=0;i<m;i++){
			temp[i]=1;
		}
		
		while(true){
			
			set.add(getValue(temp));
			
			boolean tempTag=false;
			int i=0;
			for(;i<n-1;i++){
				if(temp[i]==1&&temp[i+1]==0){
					tempTag=true;
					break;
				}
			}
			
			if(tempTag){
				move(temp,i);
				swap(temp, i, i+1);
			}else{
				return set;
			}
		}
		
		
		
		
	}
	
	public static void swap(int a[],int i,int j){
		a[i]=a[i]^a[j];
		a[j]=a[i]^a[j];
		a[i]=a[i]^a[j];
	}
	
	public static String[] getCombination(String word[]){
		int length=word.length;
		int resultLength=(1<<length)-1;
		String result[]=new String[resultLength];
		for(int i=1;i<=resultLength;i++){
			String s=num2Binary(i,length);
			char c[]=s.toCharArray();
			String temp="";
			for(int j=0;j<length;j++){
				if(c[j]=='1'){
					temp+=word[j];
				}
			}
			result[i-1]=temp;
		}
		
		return result;
	}
	
	
	
	public static String num2Binary(int num,int nbit){
		String s="";
		
		for(int i=nbit-1;i>=0;i--){
			s+=(num>>i)&1;
		}
		
		return s;
	}

}
