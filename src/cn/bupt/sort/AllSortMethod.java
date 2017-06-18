package cn.bupt.sort;

import java.util.Arrays;

public class AllSortMethod {
	
	
	public static void swap(int a[],int i,int j){
		if(i!=j){
			a[i]=a[i]^a[j];
			a[j]=a[i]^a[j];
			a[i]=a[i]^a[j];
		}
		
		
	}
	
	/*
	 * 冒泡排序
	 * 时间复杂父O(n^2)
	 * 稳定排序
	 */
	public static void bubble(int a[]){
		
		for(int i=0;i<a.length;i++){
			for(int j=0;j<a.length-i-1;j++){
				if(a[j]>a[j+1]){
					swap(a, j, j+1);
				}
			}
		}
		
	}
	/*
	 * 快速排序
	 * 时间复杂度O(nlogn)
	 * 不稳定排序
	 */
	public static void quickSort(int a[],int left,int right){
		
		if(left<right){
			int temp=a[left],i=left,j=right;
			while(i!=j){
				while(i<j&&a[j]>=temp){
					--j;
				}
				while(i<j&&a[i]<=temp){
					++i;
				}
				if(i<j){
					swap(a, i, j);
					--j;
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
		
	}
	
	/*
	 *另外一种快速排序算法，此种方法多用于对单链表的快速排序
	 */
	public static void quickSort1(int a[],int left,int right){
		if(left!=right){
			int partition=getPartition(a, left, right);
			quickSort1(a, left, partition);
			quickSort1(a, partition+1, right);
		}
		
	}
	
	public static int getPartition(int a[],int left,int right){
		int p=left,q=left+1;
		int key=a[left];
		while(q!=right){
			if(a[q]<key){
				++p;
				swap(a, p, q);
			}
			++q;
		}
//		System.out.println("p:"+p+",q:"+q+",a[p]:"+a[p]);
		
		swap(a, left, p);
		System.out.println(Arrays.toString(a));
		return p;
	}
	
	public static void quickSort2(int a[],int left,int right){
		if(left<right){
			int partition[]=getPartition2(a, left, right);
			quickSort2(a, left, partition[0]-1);
			quickSort2(a, partition[1]+1, right);
		}
	}
	
	public static int[] getPartition2(int a[],int left,int right){
		int i=left-1;
		int j=right+1;
		int temp=a[left];
		int current=left;
		while(current!=j){
			if(a[current]==temp){
				current++;
			}else if(a[current]<temp){
				swap(a, ++i, current++);
			}else{
				swap(a, current, --j);
			}
		}
		int par[]=new int[2];
		par[0]=i+1;
		par[1]=j-1;
		return par;
	}
	
	
	/*
	 * 选择排序
	 * 时间复杂度O(n^2)
	 * 不稳定排序
	 */
	public static void choiceSort(int a[]){
		
		for(int i=0;i<a.length;i++){
			int minIndex=i;
			for(int j=i+1;j<a.length;j++){
				if(a[minIndex]>a[j]){
					minIndex=j;
				}
			}
			if(i!=minIndex){
				swap(a, i, minIndex);
			}
		}
		
	}
	
	
	/*
	 * 插入排序
	 * 时间复杂度O(n^2)
	 * 稳定排序
	 */
	public static void insertSort(int a[]){
		for(int i=1;i<a.length;i++){
			int temp=a[i];
			int pos=i-1;
			while(pos>=0&&a[pos]>temp){
				a[pos+1]=a[pos];
				--pos;
			}
			a[pos+1]=temp;
		}
		
	}
	/*
	 * 希尔排序
	 * 时间复杂度O(nlogn)
	 * 稳定排序
	 */
	public static void shellSort(int a[]){
		
		int d=a.length/2;
		while(d>0){
			for(int i=0;i<d;i++){
				for(int j=i+d;j<a.length;j++){
					int temp=a[j];
					int pos=j-d;
					while(pos>=0&&a[pos]>temp){
						a[pos+d]=a[pos];
						pos-=d;
					}
					a[pos+d]=temp;
				}
				
			}
			d/=2;
		}
		
		
	}
	
	
	
	/*
	 * 归并排序
	 * 时间复杂度O(nlogn)
	 * 稳定排序
	 */
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
	/*
	 * 堆排序
	 * 时间复杂度O(nlogn)
	 * 不稳定排序
	 */
	public static void heapSort(int a[]){
		int lastIndex=a.length-1;
		for(int i=0;i<lastIndex;i++){
			buildMaxHeap(a,lastIndex-i);
			swap(a, 0, lastIndex-i);
			
		}
	}
	
	
	
	public static void builadMaxHeap1(int a[],int lastIndex){
		for(int i=(lastIndex-1)/2;i>=0;i--){
			int k=i;
			while(2*k+1<=lastIndex){
				int biggerIndex=2*k+1;
				if(biggerIndex<lastIndex){
					if(a[biggerIndex]<a[biggerIndex+1]){
						biggerIndex++;
					}
					
				}
				if(a[k]<a[biggerIndex]){
					swap(a,k,biggerIndex);
					k=biggerIndex;
				}else{
					break;
				}
			}
		}
	}
	
	public static void buildMaxHeap(int a[],int lastIndex){
		for(int i=(lastIndex-1)/2;i>=0;i--){
			int k=i;
			while(2*k+1<=lastIndex){
				int biggerIndex=2*k+1;
				if(2*k+1<lastIndex){
					if(a[biggerIndex]<a[biggerIndex+1]){
						++biggerIndex;
					}
				}
				if(a[k]<a[biggerIndex]){
					swap(a, k, biggerIndex);
					k=biggerIndex;
				}else{
					break;
				}
			}
		}
	}
	
	public static void countSort(int input[]){
		int max=Integer.MIN_VALUE,min=Integer.MAX_VALUE;
		for(int i=0;i<input.length;i++){
			if(input[i]<min){
				min=input[i];
			}
			if(input[i]>max){
				max=input[i];
			}
		}
		int arrayLength=max-min+1;
		int c[]=new int[arrayLength];
		/*for(int i=0;i<input.length;i++){
			c[i]=0;
		}*/
		System.out.println(min);
		for(int i=0;i<input.length;i++){
			c[input[i]-min]++;
		}
		for(int i=1;i<c.length;i++){
			c[i]+=c[i-1];
		}
		int outPut[]=new int[input.length];
		System.out.println(Arrays.toString(c));
		for(int i=input.length-1;i>=0;i--){
			outPut[c[input[i]-min]-1]=input[i];
			c[input[i]-min]--;
		}
		System.out.println(Arrays.toString(c));
		System.out.println(Arrays.toString(outPut));
		
//		System.out.println(Arrays.toString(c));
		
	}
	
	public static void main(String[] args) {
		int a[]={5,4,3,5,1,7,8,9,2,10,1,11,20,5,4,9,7,6,3};
//		bubble(a);
//		quickSort(a,0,a.length-1);
//		choiceSort(a);
//		insertSort(a);
//		shellSort(a);
//		mergeSort(a,0,a.length-1);
//		heapSort(a);
//		countSort(a);
		quickSort2(a, 0, a.length-1);
		System.out.println(Arrays.toString(a));
	}

}
