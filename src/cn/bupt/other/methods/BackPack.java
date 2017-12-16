package cn.bupt.other.methods;

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
