package cn.bupt.other.methods;

import java.util.Arrays;

public class BackPack {
	
	public static void main(String[] args) {
		int w[]={3,4,5};
		int p[]={4,5,6};
		int c[][]=solution(10, w, p);
		for(int i=0;i<c.length;i++){
			for(int j=0;j<c[i].length;j++){
				System.out.print(c[i][j]+" ");
			}
			System.out.println();
		}

		System.out.println(c[w.length][10]);
		System.out.println(solutionByRecursion(w,p,10,w.length-1));
		System.out.println(solutionByRecursion(w,p,10,w.length-1,new int[w.length]));
        System.out.println(solutionByDp(w,p,10));

	}

	public static int solutionByRecursion(int w[], int p[], int maxWeight, int n){
		if (n==-1){
			return 0;
		}
		if (w[n]>maxWeight){
			return solutionByRecursion(w,p,maxWeight,n-1);
		}else {
			return Math.max(solutionByRecursion(w,p,maxWeight,n-1),p[n]+solutionByRecursion(w,p,maxWeight-w[n],n-1));

		}
	}

	public static int solutionByRecursion(int w[], int p[], int maxWeight, int n,int result[]){
		if (n==-1){
			return 0;
		}
		if (result[n]!=0){
			return result[n];
		}
		if (w[n]>maxWeight){
			int res = solutionByRecursion(w,p,maxWeight,n-1);
			result[n] = res;
			return res;
		}else {
			int res = Math.max(solutionByRecursion(w,p,maxWeight,n-1),p[n]+solutionByRecursion(w,p,maxWeight-w[n],n-1));
			result[n] = res;
			return res;

		}
	}

	public static int solutionByDp(int w[], int p[], int maxWeight){
		int dp[][] = new int[w.length+1][maxWeight+1];
		for (int i = 1;i<dp.length;i++){
		    for (int j=1;j<dp[i].length;j++){
		        int weight = j;
		        if (w[i-1]>weight){
		            dp[i][j] = dp[i-1][j];
                }else {
		            dp[i][j] = Math.max(dp[i-1][j],p[i-1]+dp[i-1][weight - w[i-1]]);
                }
            }
        }
        for (int i=0;i<dp.length;i++){
            System.out.println(Arrays.toString(dp[i]));
        }

        return dp[w.length][maxWeight];
	}
	
	
	public static int[][] solution(int maxWeight,int w[],int p[]){
		//c[i][j]表示前i个物品装入容量为j的背包的最大价值
		int c[][]=new int[w.length+1][maxWeight+1];
		for(int i=0;i<c.length;i++){
			c[i][0]=0;
		}
		for(int j=0;j<c[0].length;j++){
			c[0][j]=0;
		}
		for(int i=1;i<c.length;i++){
			for(int j=1;j<c[i].length;j++){
				if(w[i-1]<=j){

					//这部分有两个含义一是当背包容量足够大时，可以将当前的物品直接放进去，二是将一个物品取出来，放进当前物品。
					if(c[i-1][j]<c[i-1][j-w[i-1]]+p[i-1]){
						c[i][j]=c[i-1][j-w[i-1]]+p[i-1];
					}else{
						c[i][j]=c[i-1][j];
					}
					
				}else{
					c[i][j]=c[i-1][j];
				}
			}
		}
		
		
		return c;
	}

}
