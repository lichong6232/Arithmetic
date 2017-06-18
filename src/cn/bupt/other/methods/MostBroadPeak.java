package cn.bupt.other.methods;

public class MostBroadPeak {
	
	public static int[] solution(int a[]){
		int result[]=new int[2];
		
		boolean leftTag=false,midTag=false;
		int leftIndex=-1,rightIndex=-1,max=0,tempLeftIndex=-1,tempRightIndex=-1;
		for(int i=0;i<a.length-1;i++){
			if(!leftTag&&a[i]<a[i+1]){
				tempLeftIndex=i;
				leftTag=true;
			}
			if(leftTag&&a[i]>a[i+1]){
				midTag=true;
			}
			if(midTag&&a[i]<a[i+1]){
				tempRightIndex=i;
				if(tempRightIndex-tempLeftIndex>max){
					max=tempRightIndex-tempLeftIndex;
					leftIndex=tempLeftIndex;
					rightIndex=tempRightIndex;
				}
				leftTag=false;
				midTag=false;
			}
		}
		
		result[0]=leftIndex;
		result[1]=rightIndex;
		
		return result;
	}

}
