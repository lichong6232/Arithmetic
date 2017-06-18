package cn.bupt.test;

public class InverseNumber {
	
	private static int number=0;
	public static void main(String[] args) {
		int a[]={2,8,3,1,0,4,7,6,5};
		int a2[]={2,8,3,1,0,7,4,5,6};
		mergeSort(a2, 0, a.length-1);
		System.out.println(number);
	}
	
	
	public static void mergeSort(int a[],int left,int right){
		if(left<right){
			int mid=(left+right)/2;
			mergeSort(a, left, mid);
			mergeSort(a, mid+1, right);
			merge(a, left, mid, right);
		}
		
	}
	public static void merge(int a[],int left,int mid,int right){
		int temp[]=new int[right-left+1];
		int i=left,j=mid+1,pos=0;
		while(i<=mid&&j<=right){
			if(a[i]<=a[j]){
				temp[pos++]=a[i++];
			}else{
				temp[pos++]=a[j++];
				number+=mid-i+1;
			}
		}
		while(i<=mid){
			temp[pos++]=a[i++];
		}
		while(j<=right){
			temp[pos++]=a[j++];
		}
		
		int start=0;
		while(left<=right){
			a[left++]=temp[start++];
		}
		
	}

}
