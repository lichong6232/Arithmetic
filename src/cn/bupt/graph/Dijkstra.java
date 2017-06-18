package cn.bupt.graph;

public class Dijkstra {
	
	private int MAX_VERTIX=20;
	private Vertix[] vertixList=null;
	private int adj[][]=null;
	private int dist[]=null;
	private int pre[]=null;
	private int nVertix;
	private int nTree;
	private boolean isDirected;
	
	public Dijkstra(boolean isDirected){
		vertixList=new Vertix[MAX_VERTIX];
		adj=new int[MAX_VERTIX][MAX_VERTIX];
		for(int i=0;i<adj.length;i++){
			for(int j=0;j<adj[i].length;j++){
				adj[i][j]=Integer.MAX_VALUE;
			}
		}
		nVertix=0;
		nTree=0;
		this.isDirected=isDirected;
		
	}
	
	public void addVertix(char label){
		vertixList[nVertix++]=new Vertix(label);
	}
	public void addEndge(int start,int end,int distance){
		if(isDirected){
			addEndgeDirected(start, end, distance);
		}else{
			addEndgeUndirected(start, end, distance);
		}
	}
	private void addEndgeDirected(int start,int end,int distance){
		adj[start][end]=distance;
	}
	
	private void addEndgeUndirected(int start,int end,int distance){
		adj[start][end]=distance;
		adj[end][start]=distance;
	}
	
	public void dijkstra(int start){
		dist=new int[nVertix];
		pre=new int[nVertix];
		for(int i=0;i<nVertix;i++){
			dist[i]=adj[start][i];
			pre[i]=start;
		}
		dist[start]=0;
		vertixList[start].isInTree=true;
		nTree=1;
		while(nTree<nVertix){
			int minVertix=getMinVertix();
			if(minVertix==-1){
				System.out.println("不是连通图");
				
				return;
			}
			int distance=dist[minVertix];
			vertixList[minVertix].isInTree=true;
			updateDist(minVertix, distance);
			nTree++;
		}
	}
	
	public void display(){
		for(int i=0;i<nVertix;i++){
			System.out.print(vertixList[i].label+"="+dist[i]+"("+vertixList[pre[i]].label+") ");
		}
	}
	
	public void updateDist(int currentIndex,int distance){
		for(int i=0;i<nVertix;i++){
			if(vertixList[i].isInTree)
				continue;
			int newDist=adj[currentIndex][i]==Integer.MAX_VALUE?Integer.MAX_VALUE:distance+adj[currentIndex][i];
			if(newDist<dist[i]){
				dist[i]=newDist;
				pre[i]=currentIndex;
			}
		}
	}
	
	public int getMinVertix(){
		int min=Integer.MAX_VALUE;
		int minIndex=-1;
		for(int i=0;i<nVertix;i++){
			if(vertixList[i].isInTree)
				continue;
			if(dist[i]<min){
				min=dist[i];
				minIndex=i;
			}
		
				
		}
		return minIndex;
	}
	
	public static void main(String[] args) {
		Dijkstra dijkstra=new Dijkstra(true);
		dijkstra.addVertix('A');
		dijkstra.addVertix('B');
		dijkstra.addVertix('C');
		dijkstra.addVertix('D');
		dijkstra.addVertix('E');
		dijkstra.addEndge(0, 1, 50);
		dijkstra.addEndge(0, 3, 80);
		dijkstra.addEndge(1, 2, 60);
		dijkstra.addEndge(1, 3, 90);
		dijkstra.addEndge(2, 4, 40);
		dijkstra.addEndge(3, 2, 20);
		dijkstra.addEndge(3, 4, 70);
		dijkstra.addEndge(4, 1, 50);
		dijkstra.dijkstra(0);
		dijkstra.display();
		
		
		
	}
	
	
	
	
	

}
