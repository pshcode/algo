package pshcode.algorithm.shortestpath.dijkstra;

import java.util.LinkedList;
import java.util.List;

/**
 * @author SungHoon, Park
 */
public class Dijkstra {
	private static final int MAX_WEIGHT = 9999;

	private int nodeSize;
	private List[] adjEdges;
	private int[] checked;
	private int[] distances;

	public Dijkstra(int nodeSize) {
		this.nodeSize = nodeSize;
		adjEdges = new List[nodeSize];
		checked = new int[nodeSize];
		distances = new int[nodeSize];
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

	public void init(int startNode) {
		for (int toNode = 0; toNode < nodeSize; toNode++) {
			if (toNode == startNode) {
				checked[toNode] = 0;
				distances[toNode] = 0;
				continue;
			}

			Edge edge = getEdge(startNode, toNode);

			if (edge == null) {
				distances[toNode] = MAX_WEIGHT;
			} else {
				distances[toNode] = edge.getWeight();
			}

			checked[toNode] = 1;
		}
	}

	public void calcShortestPath() {
		for (int i = 0; i < nodeSize - 1; i++) {
			int vNode = getMinDistanceNode();
			checked[vNode] = 0;

			List<Edge> edgeList = adjEdges[vNode];

			if (edgeList != null) {
				for (Edge edge : edgeList) {
					int wNode = edge.getToNode();

					int cVW = edge.getWeight();
					int yV = distances[vNode];
					int yW = distances[wNode];

					if (yV + cVW < yW) {
						distances[wNode] = yV + cVW;
					}
				}
			}

			printDistances(0);
			System.out.println("");
		}

	}

	private int getMinDistanceNode() {
		int min = 0;
		int minDistance = MAX_WEIGHT;

		for (int index = 0; index < nodeSize; index++) {
			if (checked[index] != 0 && distances[index] < minDistance) {
				minDistance = distances[index];
				min = index;
			}
		}

		return min;
	}

	public void printDistances(int startNode) {
		for (int i = 0; i < nodeSize; i++) {
			String text = String.format("[%d]부터 [%d]까지 거리: %d", startNode, i, distances[i]);
			System.out.println(text);
		}
	}
}
