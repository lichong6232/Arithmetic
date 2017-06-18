package cn.bupt.other.methods;

public class GetMaxSumSubSequence {
	
	public static void getMaxSum(int a[]){
		
		boolean leftTag=false;
		int tempSum=0,maxSum=0,tempLeftIndex=-1,leftIndex=-1,rightIndex=-1;
		
		for(int i=0;i<=a.length;i++){
			
			
			if(i<a.length&&!leftTag&&a[i]>0){
				leftTag=true;
				tempLeftIndex=i;
			}
			if(i==a.length||(leftTag&&a[i]<0)){
				if(tempSum>maxSum){
					maxSum=tempSum;
					leftIndex=tempLeftIndex;
					rightIndex=i-1;
				}
				tempSum=0;
				leftTag=false;
				tempLeftIndex=0;
				continue;
			}
			tempSum+=a[i];
			
			
		}
		
		System.out.println("最大序列和为："+maxSum);
		System.out.println("最大序列范围为："+leftIndex+","+rightIndex);
		
	}

}
