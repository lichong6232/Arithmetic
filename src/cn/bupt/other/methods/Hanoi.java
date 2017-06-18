package cn.bupt.other.methods;


public class Hanoi {

	static private int i=1;
	public static void move(int layer,String source,String temp,String dest){
		if(layer==1){
			System.out.println("第"+i+"步：从"+source+"移动到"+dest);
			i++;
			
		}else{
			move(layer-1,source,dest,temp);
			System.out.println("第"+i+"步：从"+source+"移动到"+dest);
			i++;
			move(layer-1, temp, source, dest);
		}
		
	}
	
	public static void main(String[] args) {

		move(5,"A","B","C");
	}


}
