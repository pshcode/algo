package pshcode.algorithm.shortestpath.dijkstra;

import lombok.Data;

/**
 * @author SungHoon, Park
 */
@Data
public class Edge {
	int toNode;
	int weight;

	public Edge(int toNode, int weight) {
		this.toNode = toNode;
		this.weight = weight;
	}
}
