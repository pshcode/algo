package pshcode.algorithm.shortestpath.dijkstra;

import java.util.LinkedList;
import java.util.List;

/**
 * @author SungHoon, Park
 */
public class ShortestPath {
	protected static final int MAX_WEIGHT = 999;
	protected int nodeSize;
	protected List[] adjEdges;

	public ShortestPath(int nodeSize) {
		this.nodeSize = nodeSize;
		adjEdges = new List[nodeSize];
	}

	public boolean addEdge(int fromNode, int toNode, int weight) {
		if (isNotValid(fromNode, toNode)) {
			return false;
		}

		List<Edge> edgeList = adjEdges[fromNode];

		if (edgeList == null) {
			adjEdges[fromNode] = new LinkedList<Edge>();
			edgeList = adjEdges[fromNode];
		}

		edgeList.add(new Edge(toNode, weight));

		return true;
	}

	public Edge getEdge(int fromNode, int toNode) {
		List<Edge> edgeList = adjEdges[fromNode];

		if (edgeList != null) {
			for (Edge edge : edgeList) {
				if (toNode == edge.getToNode()) {
					return edge;
				}
			}
		}

		return null;
	}

	private boolean isNotValid(int fromNode, int toNode) {
		if (fromNode < 0 || fromNode > nodeSize) {
			System.out.println("잘못된 노드 정보: fromNode=" + fromNode);
			return true;
		}

		if (toNode < 0 || toNode > nodeSize) {
			System.out.println("잘못된 노드 정보: toNode=" + toNode);
			return true;
		}

		return false;
	}
}
