package cn.bupt.graph;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import cn.bupt.union.UnionFind;

public class Kruskal {
	
	private List<Endge> endges=null;
	private int MAX_VERTIX=20;
	private Vertix[] vertixList=null;
	private int nVertix;
	
	public Kruskal(){
		vertixList=new Vertix[MAX_VERTIX];
		nVertix=0;
		endges=new ArrayList<Endge>();
	}
	
	public void addVertix(char label){
		vertixList[nVertix++]=new Vertix(label);
	}
	
	public void addEndge(int start,int end,int distance){
		endges.add(new Endge(start, end, distance));
	}
	
	public List<Endge> kruskal(){
		List<Endge> target=new ArrayList<Endge>();
		Collections.sort(endges, new Comparator<Endge>() {
			@Override
			public int compare(Endge o1, Endge o2) {
				// TODO Auto-generated method stub
				return o1.distance-o2.distance;
			}
		});
		UnionFind unionFind=new UnionFind(nVertix);
		for(int i=0;i<endges.size();i++){
			Endge endge=endges.get(i);
			int source=endge.sourceVertix;
			int dest=endge.destVertix;
			if(!unionFind.isSameGroup(source, dest)){
				target.add(endge);
				unionFind.union(source, dest);
			}
		}
		return target;
	}
	
	public static void main(String[] args) {
		Kruskal kruskal=new Kruskal();
		kruskal.addVertix('A');
		kruskal.addVertix('B');
		kruskal.addVertix('C');
		kruskal.addVertix('D');
		kruskal.addVertix('E');
		kruskal.addVertix('F');
		kruskal.addEndge(0, 1, 6);
		kruskal.addEndge(0, 3, 4);
		kruskal.addEndge(1, 2, 10);
		kruskal.addEndge(1, 3, 7);
		kruskal.addEndge(1, 4, 7);
		kruskal.addEndge(2, 3, 8);
		kruskal.addEndge(2, 4, 5);
		kruskal.addEndge(2, 5, 6);
		kruskal.addEndge(3, 4, 12);
		kruskal.addEndge(4, 5, 7);
		List<Endge> result=kruskal.kruskal();
		for(Endge endge:result){
			System.out.print(kruskal.vertixList[endge.sourceVertix].label +"--------->");
			System.out.print(kruskal.vertixList[endge.destVertix].label);
			System.out.println();
		}
		
		
	}
	

}
