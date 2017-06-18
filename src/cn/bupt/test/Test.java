package cn.bupt.test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;
import java.util.Stack;

import cn.bupt.lineTable.ChainTable;
import cn.bupt.queue.PriorityNode;
import cn.bupt.queue.PrioritySequenceQueue;

public class Test {
	
	public static void main(String[] args) {
		ChainTable chainTable=new ChainTable();
		chainTable.add(1);
		chainTable.add(2);
		System.out.println(chainTable.get(0));
		
	}
	
	public static String getRandomString(int n){
		char c[]=new char[n];
		char first[]={'a','A'};
		Random random=new Random();
		for(int i=0;i<n;i++){
			int firstIndex=random.nextInt(2);
			int randomIndex=random.nextInt(26);
			char head=first[firstIndex];
			c[i]=(char) (head+randomIndex);
		}
		
		
		
		
		return String.valueOf(c);
	}
	
	public static int getCountWays(int n){
		int countWays=0;
		if(n<=2){
			return n;
		}
		return getCountWays(n-1)+getCountWays(n-2);
		
	}
	
	
	public static  int countWays(int n) {  
        // write code here  
        if(n<=2)  
            return n;  
        int f = 1;  
        
        int s = 2;  
        int t = 0;  
        for(int i=3;i<=n;i++){  
        	
         t = f+s;  
         f = s;  
         s = t;  
        }  
       return t;   
    }  
	
	
	
	public static int findLCS(String A, int n, String B, int m) {  
        // write code here  
        int[][] dp = new int[n][m];  
        char[] a = A.toCharArray();  
        char[] b = B.toCharArray();  
       for(int i=0;i<n;i++){  
           if(a[i]==b[0]){  
               dp[i][0] = 1;  
               for(int j=i+1;j<n;j++){  
                   dp[j][0] = 1;  
               }  
               break;  
           }  
             
       }  
         for(int i=0;i<m;i++){  
           if(a[0]==b[i]){  
               dp[0][i] = 1;  
               for(int j=i+1;j<m;j++){  
                   dp[0][j] = 1;  
               }  
               break;  
           }  
             
       }  
       for(int i=1;i<n;i++){  
           for(int j=1;j<m;j++){  
               if(a[i]==b[j]){  
            	   if(dp[i-1][j]>dp[i-1][j-1]+1){
            		   System.out.println("dp[i-1][j-1]+1:"+dp[i-1][j-1]+1+",dp[i-1][j]："+dp[i-1][j]);
            		   
            	   }
            	   if(dp[i][j-1]>dp[i-1][j-1]+1){
            		   System.out.println("dp[i-1][j-1]+1:"+dp[i-1][j-1]+1+",dp[i][j-1]："+dp[i][j-1]);
            	   }
                  dp[i][j] = max(dp[i-1][j-1]+1,dp[i-1][j],dp[i][j-1]);  
               }else{  
                   dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1]);  
               }  
                     
           }  
       }   
          
        return dp[n-1][m-1];  
    }  
    public static int max(int a,int b,int c){  
        int max = a;  
        if(b>max)  
            max=b;  
        if(c>max)  
            max = c;  
        return max;  
    }  
}
