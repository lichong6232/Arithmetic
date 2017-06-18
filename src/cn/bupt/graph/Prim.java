package cn.bupt.graph;



class Endge{
	int sourceVertix;
	int destVertix;
	int distance;
	public Endge(int sourceVertix, int destVertix, int distance) {
		
		this.sourceVertix = sourceVertix;
		this.destVertix = destVertix;
		this.distance = distance;
	}
	
}

class PriorityQueue{
	
	private Endge[] endgeArray=null;
	private int size;
	
	public PriorityQueue(int n){
		endgeArray=new Endge[n];
		size=0;
		
	}
	
	public void insert(Endge endge){
		
		int i=0;
		
		for(;i<size;i++){
			if(endgeArray[i].distance<=endge.distance){
				break;
			}
		}

		for(int j=size-1;j>=i;j--){
			endgeArray[j+1]=endgeArray[j];
		}
		endgeArray[i]=endge;
		size++;
		
	}
	
	public Endge removeMin(){
		return endgeArray[--size];
	}
	
	public Endge peekMin(){
		return endgeArray[size-1];
	}
	
	public Endge peekEndgeN(int nIndex){
		return endgeArray[nIndex];
	}
	public void removeEndgeN(int nIndex){
		for(int i=nIndex;i<size-1;i++){
			endgeArray[i]=endgeArray[i+1];
		}
		size--;
	}
	
	public int findDestVertixIndex(int destVertix){
		for(int i=0;i<size;i++){
			if(endgeArray[i].destVertix==destVertix){
				return i;
			}
		}
		return -1;
	}
	
	public boolean isEmpty(){
		return size==0;
	}
	
	public int size(){
		return size;
	}
	
	
	
}

public class Prim {
	
	private  final int MAX_VERTIX=20;
	private Vertix[] vertixList;
	private int currentVertix;
	private int adjMat[][];
	private int nVertix;
	private PriorityQueue priorityQueue;
	private int nTree;
	
	
	public Prim(){
		priorityQueue=new PriorityQueue(MAX_VERTIX);
		vertixList=new Vertix[MAX_VERTIX];
		adjMat=new int[MAX_VERTIX][MAX_VERTIX];
		for(int i=0;i<MAX_VERTIX;i++){
			for(int j=0;j<MAX_VERTIX;j++){
				adjMat[i][j]=Integer.MAX_VALUE;
			}
		}
		nVertix=0;
		nTree=0;
	}
	
	
	public void addVertix(char c){
		Vertix vertix=new Vertix(c, false);
		vertixList[nVertix++]=vertix;

	}
	
	public void addEndge(int start,int end,int distance){
		adjMat[start][end]=distance;
		adjMat[end][start]=distance;
	}
	
	public void prim(){
		currentVertix=0;
		while(nTree<nVertix-1){
			vertixList[currentVertix].isInTree=true;
			nTree++;
			for(int i=0;i<nVertix;i++){
				if(i==currentVertix)
					continue;
				if(vertixList[i].isInTree)
					continue;
				int distance=adjMat[currentVertix][i];
				if(distance==Integer.MAX_VALUE)
					continue;
				putPQ(i, distance);
			}
			if(priorityQueue.size()==0){
				System.out.println("GPATH NOT CONNECTED");
				return;
			}
			Endge endge=priorityQueue.removeMin();
			int sourceVertix=endge.sourceVertix;
			int destVertix=endge.destVertix;
			currentVertix=destVertix;
			System.out.print(vertixList[sourceVertix].label);
			System.out.print(vertixList[destVertix].label);
			System.out.print(" ");
		}
	}
	
	public  void putPQ(int destVertix,int distance){
		int index=priorityQueue.findDestVertixIndex(destVertix);
		if(index!=-1){
			Endge tempEndge=priorityQueue.peekEndgeN(index);
			if(tempEndge.distance>distance){
				priorityQueue.removeEndgeN(destVertix);
				Endge newEndge=new Endge(currentVertix, destVertix, distance);
				priorityQueue.insert(newEndge);
			}
		}else{
			Endge endge=new Endge(currentVertix, destVertix, distance);
			priorityQueue.insert(endge);
		}
	}
	

	public static void main(String[] args) {
		Prim prim=new Prim();
		prim.addVertix('A');
		prim.addVertix('B');
		prim.addVertix('C');
		prim.addVertix('D');
		prim.addVertix('E');
		prim.addVertix('F');
		prim.addEndge(0, 1, 6);
		prim.addEndge(0, 3, 4);
		prim.addEndge(1, 2, 10);
		prim.addEndge(1, 3, 7);
		prim.addEndge(1, 4, 7);
		prim.addEndge(2, 3, 8);
		prim.addEndge(2, 4, 5);
		prim.addEndge(2, 5, 6);
		prim.addEndge(3, 4, 12);
		prim.addEndge(4, 5, 7);
		prim.prim();
		
		
	}
	
	
	

}
