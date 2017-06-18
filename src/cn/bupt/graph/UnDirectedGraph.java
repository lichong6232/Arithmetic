package cn.bupt.graph;

import java.util.List;

import javax.management.Query;

import cn.bupt.queue.ChainQueue;
import cn.bupt.stack.ChainStack;

public class UnDirectedGraph {
	
	private int MAX_SIZE=20;
	private Vertex[] vertexList;
	private int[][] adjMat;
	private int nVertex;
	private ChainStack stack;
	private ChainQueue queue;
	
	public UnDirectedGraph(){
		vertexList=new Vertex[MAX_SIZE];
		adjMat=new int[MAX_SIZE][MAX_SIZE];
		for(int i=0;i<MAX_SIZE;i++){
			for(int j=0;j<MAX_SIZE;j++){
				adjMat[i][j]=0;
			}
		}
		nVertex=0;
		stack=new ChainStack();
		queue=new ChainQueue();
	}
	
	public void addVertex(char label){
		vertexList[nVertex++]=new Vertex(label);	
	}
	
	public void addEdge(int start,int end){
		adjMat[start][end]=1;
		adjMat[end][start]=1;
		
	}
	
	public void displayVertex(int v){
		System.out.println(vertexList[v].getLabel());
	}
	
	
	
	public int getAdjUnvisitedVertex(int v){
		
		for(int j=0;j<nVertex;j++){
			if(adjMat[v][j]==1&&!vertexList[j].isWasVisited()){
				return j;
			}
		}
		
		return -1;
		
	}
	
	public void dfsV(int v){
		vertexList[v].setWasVisited(true);
		displayVertex(v);
		stack.push(v);
		while(!stack.isEmpty()){
			int adjV=getAdjUnvisitedVertex((int)stack.peek());
			if(adjV>-1){
				vertexList[adjV].setWasVisited(true);
				displayVertex(adjV);
				stack.push(adjV);
			}else{
				stack.pop();
			}
			
		}
		
		for(int i=0;i<nVertex;i++){
			vertexList[i].setWasVisited(false);
		}
		
	}
	
	public void mst(){
		vertexList[0].setWasVisited(true);
		stack.push(0);
		
		while(!stack.isEmpty()){
			int adjV=getAdjUnvisitedVertex((int)stack.peek());
			if(adjV>-1){
				vertexList[adjV].setWasVisited(true);
				displayVertex((int)stack.peek());
				displayVertex(adjV);
				stack.push(adjV);
			}else{
				stack.pop();
			}
		}
		
		for(int i=0;i<nVertex;i++){
			vertexList[i].setWasVisited(false);
		}
	}
	
	public void dfs(){
		vertexList[0].setWasVisited(true);
		displayVertex(0);
		stack.push(0);
		
		while(!stack.isEmpty()){
			int adjV=getAdjUnvisitedVertex((int)stack.peek());
			if(adjV>-1){
				vertexList[adjV].setWasVisited(true);
				displayVertex(adjV);
				stack.push(adjV);
			}else{
				stack.pop();
			}
		}
		
		for(int i=0;i<nVertex;i++){
			vertexList[i].setWasVisited(false);
		}
		
	}
	
	public void bfs(){
		vertexList[0].setWasVisited(true);
		displayVertex(0);
		queue.push(0);
		while(!queue.isEmpty()){
			int adjV=-1;
			while((adjV=getAdjUnvisitedVertex((int)queue.peek()))!=-1){
				vertexList[adjV].setWasVisited(true);
				displayVertex(adjV);
				queue.push(adjV);
			}
			queue.pop();
		}
		for(int i=0;i<nVertex;i++){
			vertexList[i].setWasVisited(false);
		}
		
	}
	
	

}
