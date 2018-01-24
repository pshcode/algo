package pshcode.algorithm.graph.shortestpath.dijkstra;

import java.util.List;

/**
 * 다익스트라 알고리즘.
 *
 * @author SungHoon, Park
 */
public class Dijkstra extends ShortestPath {
	private int[] checked;
	private int[] distances;

	public Dijkstra(int nodeSize) {
		super(nodeSize);
		checked = new int[nodeSize];
		distances = new int[nodeSize];
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
