package cn.bupt.union;

import java.util.Arrays;

class Node{
	int fatherId;
	int weight;
	@Override
	public String toString() {
		return "Node [fatherId=" + fatherId + ", weight=" + weight + "]";
	}
}

public class UnionFind {
	private Node[] nodeArray=null;
	private int counter;
	public UnionFind(int n){
		this.counter=n;
		nodeArray=new Node[n];
		for(int i=0;i<n;i++){
			nodeArray[i]=new Node();
			nodeArray[i].fatherId=i;
			nodeArray[i].weight=1;
		}
	}
	
	public int findFatherId(int x){
		if(x!=nodeArray[x].fatherId){
			nodeArray[x].fatherId=findFatherId(nodeArray[x].fatherId);
		}
		return nodeArray[x].fatherId;
	}
	
	public boolean isSameGroup(int x,int y){
		return findFatherId(x)==findFatherId(y);
	}
	
	public int groupSize(){
		return counter;
	}
	
	public void union(int x,int y){
		int xFatherId=findFatherId(x);
		int yFatherId=findFatherId(y);
		if(xFatherId==yFatherId){
			return;
		}
		
		if(nodeArray[xFatherId].weight<nodeArray[yFatherId].weight){
			nodeArray[xFatherId].fatherId=yFatherId;
			nodeArray[yFatherId].weight+=nodeArray[xFatherId].weight;
		}else{
			nodeArray[yFatherId].fatherId=xFatherId;
			nodeArray[xFatherId].weight+=nodeArray[yFatherId].weight;
		}
		counter--;
		
	}
	
	public static void main(String[] args) {
		UnionFind unionFind=new UnionFind(10);
		unionFind.union(0, 1);
		unionFind.union(1, 2);
		unionFind.union(2, 3);
		unionFind.union(3, 4);
		unionFind.union(4, 5);
		unionFind.union(7, 8);
		unionFind.union(5, 7);
		System.out.println(unionFind.isSameGroup(0, 2));
		System.out.println(Arrays.toString(unionFind.nodeArray));
		System.out.println("连通区数："+unionFind.groupSize());
	}
	
	public void out(){
		System.out.println(Arrays.toString(nodeArray));
	}

}
