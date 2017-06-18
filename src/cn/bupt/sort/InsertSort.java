package cn.bupt.sort;

public class InsertSort {

	/*
	 * 直接插入排序
	 */
	
	public static void directInsertSort(int a[]){
		
		for(int i=1;i<a.length;i++){
			int j=i-1;
			int temp=a[i];
			while(j>=0&&a[j]>=temp){
				a[j+1]=a[j];
				j--;
			}
			a[j+1]=temp;
		}
		
	}
	/*
	 * 折半插入排序
	 */
	public static void binInsertSort(int a[]){
		
		for(int i=1;i<a.length;i++){
			int temp=a[i];
			int low=0,high=i-1,mid;
			while(low<=high){
				mid=(low+high)/2;
				if(temp<a[mid]){
					high=mid-1;
				}else{
					low=mid+1;
				}
			}
			
			for(int j=i;j>=low+1;j--){
				a[j]=a[j-1];
				
			}
			a[low]=temp;
		}
		
	}
	
	public static void shellSort(int list[]){
		 int gap = list.length / 2;
		 
		    while (1 <= gap) {
		        // 把距离为 gap 的元素编为一个组，扫描所有组
		        for (int i = gap; i < list.length; i++) {
		            int j = 0;
		            int temp = list[i];
		 
		            // 对距离为 gap 的元素组进行排序
		            for (j = i - gap; j >= 0 && temp < list[j]; j = j - gap) {
		                list[j + gap] = list[j];
		            }
		            list[j + gap] = temp;
		        }
		 
		        System.out.format("gap = %d:\t", gap);
//		        printAll(list);
		        gap = gap / 2; // 减小增量
		    }
	}
	
	public static void main(String[] args) {
		int a[]=new int[]{1,6,8,4,0,3,12,45,32,33,6,4,8,0,4,6,5,12,43};
		shellSort(a);
		for(int i=0;i<a.length;i++){
			System.out.println(a[i]);
		}
	}

}
