package cn.bupt.other.methods;

public class Queen8 {
	
	private static int QUEEN_NUMBER=8;
	private static int[] cols=new int[QUEEN_NUMBER];
	private static int sum=0;
	
	public static void out(){
		for(int i=0;i<QUEEN_NUMBER;i++){
			for(int j=0;j<QUEEN_NUMBER;j++){
				if(cols[j]==i){
					System.out.print("*");
				}else{
					System.out.print("-");
				}
			}
			System.out.println();
		}
	}
	
	public static void main(String[] args) {
		backTrace(0);
	}
	private static void backTrace(int n){
		
		
		
		for(int row=0;row<QUEEN_NUMBER;row++){
			if(check(n, row)){
				cols[n]=row;
				if(n==QUEEN_NUMBER-1){
					sum++;
					System.out.println("��"+sum+"���������");
					out();
				}else{
					backTrace(n+1);
				}
			}
		}
		
	}
	
	private static boolean check(int n,int row){
		for(int i=0;i<n;i++){
			if(cols[i]==row){
				return false;
			}
			int d=n-i;
			if(cols[i]-d>=0&&cols[i]-d==row){
				return false;
			}
			if(cols[i]+d<=QUEEN_NUMBER-1&&cols[i]+d==row){
				return false;
			}
		}
		
		return true;
		
	}

}
