package cn.bupt.test;

import cn.bupt.graph.DirectedGraph;
import cn.bupt.graph.UnDirectedGraph;
import cn.bupt.lineTable.ChainTable;

public class Test2 {
	
	public static void main(String[] args) {
		/*UnDirectedGraph graph=new UnDirectedGraph();
		graph.addVertex('A');
		graph.addVertex('B');
		graph.addVertex('C');
		graph.addVertex('D');
		graph.addVertex('E');
		graph.addEdge(0, 1);
		graph.addEdge(0, 2);
		graph.addEdge(0, 3);
		graph.addEdge(0, 4);
		graph.addEdge(1, 2);
		graph.addEdge(1, 3);
		graph.addEdge(1, 4);
		graph.addEdge(2, 3);
		graph.addEdge(2, 4);
		graph.addEdge(3, 4);
//		graph.dfs();
//		graph.dfsV(4);
//		graph.bfs();
		graph.mst();*/
		
		DirectedGraph directedGraph=new DirectedGraph();
		directedGraph.addVertex('A');
		directedGraph.addVertex('B');
		directedGraph.addVertex('C');
		directedGraph.addVertex('D');
		directedGraph.addVertex('E');
		directedGraph.addVertex('F');
		directedGraph.addVertex('G');
		directedGraph.addVertex('H');
		directedGraph.addEdge(0, 3);
		directedGraph.addEdge(0, 4);
		directedGraph.addEdge(1, 4);
		directedGraph.addEdge(2, 5);
		directedGraph.addEdge(3, 6);
		directedGraph.addEdge(4, 6);
		directedGraph.addEdge(5, 7);
		directedGraph.addEdge(6, 7);
		directedGraph.topOrder();

	}

}
