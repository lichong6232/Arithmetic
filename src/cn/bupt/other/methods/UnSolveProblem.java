package cn.bupt.other.methods;

import java.util.Arrays;

public class UnSolveProblem {
	
	/*
	 * [1,2,3,4,5,6,7,8]
	 * 数组中给出app的版本号，有一个函数（isBugVersion）可以判断出哪个版本是否有bug，且有bug的版本是从某个版本之后的所有版本
	 * 要求：
	 * 调用最少的isBugBersion函数查出第一个有bug的版本
	 */
	
	public static int getBugBersion(int a[],int left,int right){
		
		if(left!=right){
			int mid=(left+right)/2;
			if(isBugVersion(a[mid])){
				return getBugBersion(a, left, mid);
			}else{
				return getBugBersion(a, mid+1, right);
			}
		}
		return left;
		
		
	}
	
	public static boolean isBugVersion(int version){
		
		if(version>=10){
			return true;
		}
		return false;
	}
	
	
	/*
	 * 重复子字符串
	 * 判断一个字符串是否是重复出现自字符串
	 * 比如abcabcabc这种
	 * 
	 */
	
	public static boolean isRepeatPattern(String s){
		
		int sLength=s.length();
		int next[]=getNext(s);
		int maxLength=next[next.length-1]+1;
		if(sLength%(sLength-maxLength)==0){
			return true;
		}else{
			return false;
		}
		
		
	}
	/*
	 * KMP的next数字
	 */
	public static int[] getNext(String s){
		int sLength=s.length();
		int next[]=new int[sLength];
		char p[]=s.toCharArray();
		next[0]=-1;
		int k=-1;
		int j=0;
		while(j<sLength-1){
			if(k==-1||p[k]==p[j]){
				++k;
				++j;
				next[j]=k;
			}else{
				k=next[k];
			}
		}
		
		return next;
		
	}
	/*
	 * 重复子串问题方法二
	 */
	public static boolean isRepeatPattern1(String s){
		int sLength=s.length();
		boolean tag=false;
		for(int i=1;i<=sLength/2;i++){
			if(sLength%i==0){
				tag=isMatch(s, i);
			}
			if(tag){
				break;
			}
		}
		
		return tag;
	}
	
	public static boolean isMatch(String s,int length){
		int sLength=s.length();
		String pat=s.substring(0, length);
		char sc[]=s.toCharArray();
		char patc[]=pat.toCharArray();
		int i=0,j=0;
		while(i<sLength){
			if(sc[i]!=patc[j]){
				break;
			}
			++i;
			++j;
			j=j%length;
			
		}
		if(i==sLength){
			return true;
		}
		return false;
	}
	
	/*
	 * 重复子串方法三
	 */
	public static boolean isRepeatPattern2(String s){
		int sLength=s.length();
		for(int i=1;i<=sLength/2;i++){
			if(sLength%i==0){
				String temp=s.substring(0, i);
				StringBuffer sb=new StringBuffer();
				for(int j=0;j<sLength/i;j++){
					sb.append(temp);
				}
				if(s.equals(sb.toString())){
					return true;
				}
			}
		}
		
		return false;
	}
	
	//给定一个集合计算集合的全部子集
	
	
	//给定一个二叉树，树的数值有正有负，求路径和的最大值
	
	
	public static void main(String[] args) {
//		System.out.println(isRepeatPattern("abab"));
//		System.out.println("abc".substring(0, 2));
//		System.out.println(isMatch("abcabc",2));
//		System.out.println(isRepeatPattern1("abcabcabc"));
//		System.out.println(isRepeatPattern2("abcdabc"));
		/*int a[]={1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16};
		System.out.println(getBugBersion(a,0,a.length-1));*/
		System.out.println(Arrays.toString(getNext("abcabcabc")));
		System.out.println(isRepeatPattern("abcabcabc"));
	}

}
