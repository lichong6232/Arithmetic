package cn.bupt.mattrix;

public class Mattrix {
	
	private double[][] mattrix;
	private int row;
	private int col;
	
	public int getRow() {
		return row;
	}
	

	public void setRow(int row) {
		this.row = row;
	}

	public int getCol() {
		return col;
	}

	public void setCol(int col) {
		this.col = col;
	}

	public Mattrix(int row,int col){
		mattrix= new double[row][col];
		this.row=row;
		this.col=col;
	}

	public double[][] getMattrix() {
		return mattrix;
	}
	
	public Mattrix add(Mattrix mattrix){
		if(this.row!=mattrix.row||this.col!=mattrix.col){
			try {
				throw new Exception("要相加的两个矩阵的行数与列数不一致！");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return null;
		}else{
			Mattrix addMattrix=new Mattrix(row, col);
			for(int i=0;i<this.row;i++){
				for(int j=0;j<this.col;j++){
					addMattrix.mattrix[i][j]=this.mattrix[i][j]+mattrix.mattrix[i][j];
				
				}
			}
			return addMattrix;
		}
		
	}
	
	
	public void outPutByRow(){
		for(int i=0;i<this.row;i++){
			for(int j=0;j<this.col;j++){
				System.out.println(this.mattrix[i][j]);
			}
			
		}
	}
	
	public void outPutByCol(){
		for(int i=0;i<this.col;i++){
			for(int j=0;j<this.row;j++){
				System.out.println(this.mattrix[j][i]);
			}
		}
	}
	
	public void addByRow(double array[]){
		if(array.length!=this.row*this.col){
			try {
				throw new Exception("数组长度应等于矩阵的行与列的和");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else{
			for(int i=0;i<this.row;i++){
				for(int j=0;j<this.col;j++){
					this.mattrix[i][j]=array[i*this.col+j];
				}
			}
		}
	}
	
	public void addByCol(double array[]){
		if(array.length!=this.row*this.col){
			try {
				throw new Exception("数组长度应等于矩阵的行与列的和");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else{
			for(int i=0;i<this.col;i++){
				for(int j=0;j<this.row;j++){
					this.mattrix[i][j]=array[i*this.row+j];
				}
			}
		}
	}
	
	public Mattrix multiply(Mattrix mattrix){
		
		if(this.col!=mattrix.row){
			try {
				throw new Exception("相乘的矩阵的行列不匹配");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			return null;
		}else{
			Mattrix multiplyMattrix=new Mattrix(this.row, mattrix.col);
			for(int i=0;i<multiplyMattrix.row;i++){
				for(int j=0;j<multiplyMattrix.col;j++){
					int value=0;
					for(int k=0;k<this.col;k++){
						value+=this.mattrix[i][k]*mattrix.getMattrix()[k][j];
					}
					multiplyMattrix.getMattrix()[i][j]=value;
				}
			}
			return multiplyMattrix;
		}
		
	}
	
	public Mattrix transposition(){
		Mattrix transpositionMattrix=new Mattrix(this.col, this.row);
		
		for(int i=0;i<this.row;i++){
			for(int j=0;j<this.col;j++){
				transpositionMattrix.mattrix[j][i]=this.mattrix[i][j];
			}
		}
		
		return transpositionMattrix;
	}
	
	public static Mattrix getComplete(Mattrix mattrix,int i,int j){
		Mattrix completeMattrix=new Mattrix(mattrix.getRow()-1, mattrix.getCol()-1);
		for(int k=0;k<mattrix.getRow();k++){
			for(int h=0;h<mattrix.getCol();h++){
				if(k==i||h==j){
					continue;
				}
				if(k<i){
					if(h<j){
						completeMattrix.mattrix[k][h]=mattrix.getMattrix()[k][h];
					}else{
						completeMattrix.mattrix[k][h-1]=mattrix.getMattrix()[k][h];
					}
				}else{
					if(h<j){
						completeMattrix.mattrix[k-1][h]=mattrix.getMattrix()[k][h];
					}else{
						completeMattrix.mattrix[k-1][h-1]=mattrix.getMattrix()[k][h];
					}
				}
				
			}
		}
		
		return completeMattrix;
	}
	
	public static double  getDet(Mattrix mattrix){
		if(mattrix.getRow()==1){
			return mattrix.getMattrix()[0][0];
		}else{
			double value=0;
			for(int i=0;i<mattrix.getRow();i++){
				value+=Math.pow(-1, i)*mattrix.getMattrix()[0][i]*getDet(getComplete(mattrix, 0, i));
			}
			return value;
		}
		
		
	
	}
	
	public Mattrix inverse(){
		
		if(this.row!=this.col){
			try {
				throw new Exception("矩阵的行与列不相同不存在逆矩阵");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return null;
		}else{
			double det=getDet(this);
			if(det==0){
				try {
					throw new Exception("矩阵的行列式为0，不存在逆矩阵");
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				return null;
			}else{
				Mattrix inverseMattrix=new Mattrix(this.row, this.col);
				
				for(int i=0;i<this.row;i++){
					for(int j=0;j<this.col;j++){
						inverseMattrix.getMattrix()[i][j]=Math.pow(-1, i+j)*getDet(getComplete(this,j,i))/det;
					}
				}
				return inverseMattrix;
			}
			
			
		}

	}
	
}
