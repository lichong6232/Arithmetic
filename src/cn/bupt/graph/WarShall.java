package cn.bupt.graph;

import java.util.Arrays;

public class WarShall {
	
	public static void main(String[] args) {
		int[][] AdjMat = {
                {0,0,1,0,0},
                {1,0,0,0,1},
                {0,0,0,0,0},
                {0,0,0,0,1},
                {0,0,1,0,0}};
		
		WarShall warShall=new WarShall();
		warShall.warShall(AdjMat);
		for(int i=0;i<AdjMat.length;i++){
			System.out.println(Arrays.toString(AdjMat[i]));
		}
	}
	
	public void warShall(int adj[][]){
		int n=adj.length;
		for(int k=0;k<n;k++){
			for(int i=0;i<n;i++){
				for(int j=0;j<n;j++){
					if(adj[i][j]!=1&&adj[i][k]==1&&adj[k][j]==1){
						adj[i][j]=1;
					}
				}
			}
		}
		
	}

}
