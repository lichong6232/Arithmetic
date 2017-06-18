package cn.bupt.mattrix;

public class SpecialMattrix {
	
	private int row;
	private double[] mattrix;
	
	public SpecialMattrix(int row){
		this.row=row;
		
	}
	public int getRow() {
		return row;
	}
	public double[] getMattrix() {
		return mattrix;
	}
	
	public void diagonalMattrix(double[] array){
		int size=this.row;
		mattrix=new double[size];
		if(array.length!=size){
			try {
				throw new Exception("数组大小应和矩阵的行相一致");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else{
			for(int i=0;i<array.length;i++){
				this.mattrix[i]=array[i];
			}
		}
		
		
	}
	
	public void threeDiagonalMattrix(double[] array){
		int size=3*this.row-2;
		mattrix=new double[size];
		if(array.length!=size){
			try {
				throw new Exception("数组大小应等于3rows-2");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else{
			for(int i=0;i<array.length;i++){
				this.mattrix[i]=array[i];
			}
		}
		
	}
	
	public void threeAnglelMattrix(double[] array){
		int size=this.row*(this.row+1)/2;
		mattrix=new double[size];
		if(array.length!=size){
			try {
				throw new Exception("数组大小应该等于rows*(rows-1)/2");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else{
			for(int i=0;i<array.length;i++){
				this.mattrix[i]=array[i];
			}
		}
	}
	
	public double getDiagonalMattrix(int i,int j){
		if(i>=this.row||j>=this.row){
			try {
				throw new Exception("索引值最大为row-1");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return Double.NaN;
		}else{
			if(i==j){
				return this.mattrix[i];
			}else{
				return 0;
			}
		}
		
	}
	
	public double getThreeDiagonalMattrix(int i,int j){
		
		
		if(i>=this.row||j>=this.row){
			try {
				throw new Exception("索引值最大为row-1");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return Double.NaN;
		}else{
			double value=Double.NaN;
			switch (i-j) {
				case 1:value=this.mattrix[i-1];
					break;
				case 0:value=this.mattrix[this.row+i-1];
					break;
				case -1:value=this.mattrix[2*this.row+i-1];
					break;
			}
			
			return value;
		}
		
		
		
	}
	
	public double getUpAngleMattrix(int i,int j){
		
		if(i>=this.row||j>=this.row){
			try {
				throw new Exception("索引值最大为row-1");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return Double.NaN;
		}else{
			if(j>=i){
				return this.mattrix[j*(j+1)/2+i];
			}else{
				return 0;
			}
		}
		
	}
	
	public double getLowAngleMattrix(int i,int j){
			
			if(i>=this.row||j>=this.row){
				try {
					throw new Exception("索引值最大为row-1");
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				return Double.NaN;
			}else{
				if(j<=i){
					return this.mattrix[i*(i+1)/2+j];
				}else{
					return 0;
				}
			}
			
		}
	
	

	
	

}
