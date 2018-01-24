package pshcode.algorithm.graph.mst.kruskal;

import lombok.Data;

/**
 * @author SungHoon, Park
 */
@Data
public class Edge {
	private int fromNode;
	private int toNode;
	private int weight;

	public Edge(int fromNode, int toNode, int weight) {
		this.fromNode = fromNode;
		this.toNode = toNode;
		this.weight = weight;
	}
}
