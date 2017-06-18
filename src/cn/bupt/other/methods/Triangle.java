package cn.bupt.other.methods;

public class Triangle {

	public static int getTriangle(int n){
		
		if(n==1){
			return 1;
		}
		return n+getTriangle(n-1);
		
	}
	
	public static void main(String[] args) {
		System.out.println(getTriangle(4));
	}

}
