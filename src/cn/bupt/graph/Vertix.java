package cn.bupt.graph;

public class Vertix{
	char label;
	boolean isInTree;
	public Vertix(char label, boolean isInTree) {
		this.label = label;
		this.isInTree = isInTree;
	}
	public Vertix(char label) {
		this.label = label;
	}
}
