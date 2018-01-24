package pshcode.algorithm.graph.mst.kruskal;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.apache.commons.lang3.ArrayUtils;

/**
 * @author SungHoon, Park
 */
public class Kruskal {
	private int nodeSize;
	private int[][] inputGraph;
	private List<Edge> edgeList;

	public Kruskal(int nodeSize) {
		this.nodeSize = nodeSize;
		this.inputGraph = createGraph(nodeSize);
		this.edgeList = new ArrayList<Edge>();
	}

	private int[][] createGraph(int nodeSize) {
		inputGraph = new int[nodeSize][nodeSize];

		for (int i = 0; i < nodeSize; i++) {
			for (int j = 0; j < nodeSize; j++) {
				inputGraph[i][j] = 0;
			}
		}

		return inputGraph;
	}

	public void initEdge(int fromNode, int toNode, int weight) {
		inputGraph[fromNode][toNode] = weight;
		inputGraph[toNode][fromNode] = weight;

		edgeList.add(new Edge(fromNode, toNode, weight));
	}

	public void mstKruskal() {
		orderEdges();

		int[][] kruskalGraph = createGraph(nodeSize);

		for (Edge edge : edgeList) {

		}
	}

	public List<Edge> orderEdges() {
		Collections.sort(edgeList, new Comparator<Edge>() {
			@Override
			public int compare(Edge o1, Edge o2) {
				return o1.getWeight() - o2.getWeight();
			}
		});

		return edgeList;
	}

	public void print() {
		for (int i = 0; i < nodeSize; i++) {
			System.out.println(ArrayUtils.toString(inputGraph[i]));
		}
	}
}
