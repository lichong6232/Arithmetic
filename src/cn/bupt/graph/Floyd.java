package cn.bupt.graph;

import java.util.Arrays;

public class Floyd {
	
	public static void main(String[] args) {
		 int[][] WeightMat = {
	                {0,50,1000,80,1000},
	                {1000,0,60,90,1000},
	                {1000,1000,0,1000,40},
	                {1000,1000,20,0,70},
	                {1000,50,1000,1000,0}
	        };
		 Floyd floyd=new Floyd();
		 floyd.floyd(WeightMat);
		 for(int i=0;i<WeightMat.length;i++){
			 System.out.println(Arrays.toString(WeightMat[i]));
		 }
	}

	public void floyd(int adj[][]){
		int n=adj.length;
		for(int k=0;k<n;k++){
			for(int i=0;i<n;i++){
				for(int j=0;j<n;j++){
					adj[i][j]=Math.min(adj[i][j], adj[i][k]+adj[k][j]);
				}
			}
		}
	}
}
