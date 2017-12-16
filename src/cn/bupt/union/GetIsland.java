package cn.bupt.union;

public class GetIsland {
	
	public static void main(String[] args) {
		int a[][]={{1,1,0,0,0},
				   {1,1,0,0,0},
				   {0,0,1,0,0},
				   {0,0,0,1,1}};
		System.out.println(getIsLandGroup(a));

		
	}
	
	public static int getOceanNumber(int a[][]){
		int oceanNumber=0;
		for(int i=0;i<a.length;i++){
			for(int j=0;j<a[i].length;j++){
				if(a[i][j]==0){
					oceanNumber++;
				}
			}
		}
		
		return oceanNumber;
	}
	
	public static int getIsLandGroup(int a[][]){
		UnionFind unionFind=new UnionFind(a.length*a[0].length);
		for(int i=0;i<a.length;i++){
			for(int j=0;j<a[i].length;j++){
				if(j<a[i].length-1&&a[i][j]==1&&a[i][j+1]==1){
					int i1Index=a[i].length*i+j;
					int i2Index=a[i].length*i+j+1;
					unionFind.union(i1Index, i2Index);

				}
				if(i<a.length-1&&a[i][j]==1&&a[i+1][j]==1){
					int i1Index=a[i].length*i+j;
					int i2Index=a[i].length*(i+1)+j;
					unionFind.union(i1Index, i2Index);

				}
			}
		}
		return unionFind.groupSize()-getOceanNumber(a);
	}

}
