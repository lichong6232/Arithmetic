package cn.bupt.search;

public class BinSearch {
	
	
	public static void main(String[] args) {
		int a[]={1,3,5,7,8,9,10};
		int index=binSearch1(a,5);
		System.out.println(index);
	}
	
	/*
	 * 递归算法的二分查找
	 */
	public static int binSearch(int a[],int left,int right,int k){
		if(left<=right){
			int mid=(left+right)/2;
			if(a[mid]==k){
				return mid;
			}else if(k<a[mid]){
				return binSearch(a, left, mid-1, k);
			}else{
				return binSearch(a, mid+1, right, k);
			}
		}
		
		return -1;
	}
	/*
	 * 非递归方法
	 */
	public static int binSearch1(int a[],int k){
		int left=0;
		int right=a.length-1;
		
		while(left<=right){
			int mid=(left+right)/2;
			if(a[mid]==k){
				return mid;
			}else if(k<a[mid]){
				right=mid-1;
			}else{
				left=mid+1;
			}
		}
		
		return -1;
	}
	
	

}
