package cn.bupt.sort;

public class SimpleSort {

	public static void bubbling(int[] array){
		for(int i=0;i<array.length;i++){
			for(int j=0;j<array.length-i-1;j++){
				if(array[j]>array[j+1]){
					int temp=array[j];
					array[j]=array[j+1];
					array[j+1]=temp;
				}
			}
		}
		
	}
	
	
	public static void select(int[] array){
		
		for(int i=0;i<array.length;i++){
			int k=i;
			for(int j=i+1;j<array.length;j++){
				if(array[k]>array[j]){
					k=j;
				}
			}
			int temp=array[i];
			array[i]=array[k];
			array[k]=temp;
		}
	}
	
	public static void insert(int[] array){
		for(int i=0;i<array.length;i++){
			int temp=array[i];
			int k=i;
			while((k-1)>=0&&temp<array[k-1]){
				array[k]=array[k-1];
				k--;
			}
			array[k]=temp;
			
		}
	}
	
	/*public static int[] mergeSort(int[] array){
		int[] result=new int[array.length];
		if(array.length==1){
			result=array;
		}else{
			int leftLength=array.length/2;
			int rightLength=array.length-leftLength;
			int splitIndex=leftLength-1;
			int[] leftArray=new int[leftLength];
			int[] rightArray=new int[rightLength];
			for(int i=0;i<=splitIndex;i++){
				leftArray[i]=array[i];
			}
			for(int i=splitIndex+1;i<array.length;i++){
				rightArray[i-leftLength]=array[i];
			}
			result=merge(mergeSort(leftArray), mergeSort(rightArray));
		}
		
		return result;
		
	}*/
	
	public static void mergeSort(int[] array,int lower,int upper){
		if(upper==lower){
			return;
		}
		int mid=(lower+upper)/2;
		mergeSort(array, lower, mid);
		mergeSort(array, mid+1, upper);
		merge(array, lower, mid, upper);
		
	}
	
	
	public static void quickSort(int[] a,int left,int right){
		if(left>=right){
			return;
		}
		int temp=a[left];
		int i=left,j=right;
		while(i!=j){
			while(a[j]>=temp&&i<j){
				j--;
			}
			while(a[i]<=temp&&i<j){
				i++;
			}
			if(i<j){
				a[i]=a[i]^a[j];
				a[j]=a[i]^a[j];
				a[i]=a[i]^a[j];
				j--;
			}
		}
		a[left]=a[i];
		a[i]=temp;
		
		if(left<i-1){
			quickSort(a, left, i-1);
		}
		if(right>i+1){
			quickSort(a, i+1, right);
		}
		
	}
	
	public static void merge(int[] a,int lower,int mid,int upper){
		int[] result=new int[upper-lower+1];
		int i=lower;
		int j=mid+1;
		int k=0;
		while(i<=mid&&j<=upper){
			if(a[i]<=a[j]){
				result[k++]=a[i++];
			}else{
				result[k++]=a[j++];
			}
		}
		while(i<=mid){
			result[k++]=a[i++];
		}
		while(j<=upper){
			result[k++]=a[j++];
		}
		
		int start=0;
		while(lower<=upper){
			a[lower++]=result[start++];
		}
		
	}
	
	public static int[] merge(int[] a,int[] b){
		int merge[]=new int[a.length+b.length];
		int i=0,j=0,k=0;
		while(i!=a.length&&j!=b.length){
			if(a[i]<b[j]){
				merge[k++]=a[i++];
			}else{
				merge[k++]=b[j++];
			}
		}
		if(i!=a.length){
			while(i!=a.length){
				merge[k++]=a[i++];
			}
		}else{
			while(j!=b.length){
				merge[k++]=b[j++];
			}
		}
		
		return merge;
		
	}
	
	public static void main(String[] args) {
		int a[]=new int[]{10,7,6,4,5,2,3,9,0};
		/*int b[]=new int[]{10,9,8,7,6,5,4,3,2,1};
		int c[]=new int[]{1,2,3,4,5,6,7,8,9,10};
		int d[]=merge(b, c);*/
//		int b[]=new int[]{1,3,5,7,9,2,4,6,8,10,11,14,15};
		quickSort(a, 0, a.length-1);
		for(int i=0;i<a.length;i++){
			System.out.println(a[i]);
		}
	}
}
