package cn.bupt.graph;


import cn.bupt.queue.ChainQueue;
import cn.bupt.stack.ChainStack;

public class DirectedGraph {
	
	private int MAX_SIZE=20;
	private Vertex vertexList[];
	private int adjMax[][];
	private int nvertex;
	private ChainStack stack;
	private ChainQueue queue;
	private char[] sortedArray;
	
	public DirectedGraph(){
		vertexList=new Vertex[MAX_SIZE];
		adjMax=new int[MAX_SIZE][MAX_SIZE];
		for(int i=0;i<MAX_SIZE;i++){
			for(int j=0;j<MAX_SIZE;j++){
				adjMax[i][j]=0;
			}
		}
		nvertex=0;
		stack=new ChainStack();
		queue=new ChainQueue();
		sortedArray=new char[MAX_SIZE];
	}
	
	public void addVertex(char label){
		vertexList[nvertex++]=new Vertex(label);
	}
	
	public void addEdge(int start,int end){
		adjMax[start][end]=1;
	}
	
	public int noSuccessors(){
		
		
		for(int i=0;i<nvertex;i++){
			boolean isHasSuccessor=false;
			for(int j=0;j<nvertex;j++){
				if(adjMax[i][j]==1){
					isHasSuccessor=true;
					break;
				}
			}
			if(!isHasSuccessor){
				return i;
			}
		}
		return -1;
		
	}
	
	public void rowUp(int row,int nCol){
		for(int i=0;i<nCol;i++){
			adjMax[row][i]=adjMax[row+1][i];
		}
	}
	
	public void colLeft(int col,int nRow){
		for(int i=0;i<nRow;i++){
			adjMax[i][col]=adjMax[i][col+1];
		}
	}
	
	public void removeVertex(int v){
		if(v!=nvertex-1){
			for(int i=v;i<nvertex-1;i++){
				vertexList[i]=vertexList[i+1];
			}
			for(int row=v;row<nvertex-1;row++){
				rowUp(row, nvertex);
			}
			for(int col=v;col<nvertex-1;col++){
				colLeft(col, nvertex-1);
			}
			
		}
		nvertex--;
		
	}
	
	public void topOrder(){
		int orig_nVertex=nvertex;
		while(nvertex>0){
			int noSuccessorIndex=noSuccessors();
			if(noSuccessorIndex==-1){
				System.out.println("此图存在环，不能进行拓扑排序");
				return;
			}
			sortedArray[nvertex-1]=vertexList[noSuccessorIndex].getLabel();
			removeVertex(noSuccessorIndex);
		}
		System.out.println("拓扑排序顺序为");
		
		for(int i=0;i<orig_nVertex;i++){
			System.out.print(sortedArray[i]+",");
		}
		System.out.println();
	}
	
}
