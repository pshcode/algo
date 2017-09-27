package pshcode.algorithm.shortestpath.floyd;

import pshcode.algorithm.shortestpath.dijkstra.Edge;
import pshcode.algorithm.shortestpath.dijkstra.ShortestPath;

/**
 * 플로이드 알고리즘.
 *
 * @author SungHoon, Park
 */
public class Floyd extends ShortestPath {
	private int[][] distances;

	public Floyd(int nodeSize) {
		super(nodeSize);
		this.distances = new int[nodeSize][nodeSize];
	}

	public void init() {
		for (int r = 0; r < nodeSize; r++) {
			for (int s = 0; s < nodeSize; s++) {
				if (r == s) {
					distances[r][s] = 0;
				} else {
					Edge edge = getEdge(r, s);

					if (edge != null) {
						distances[r][s] = edge.getWeight();
					} else {
						distances[r][s] = MAX_WEIGHT;
					}
				}
			}
		}

		printDistances();
	}

	public void calcShortestPath() {
		for (int v = 0; v < nodeSize; v++) {
			System.out.println("중간 노드 v=" + v + " 시작");

			for (int r = 0; r < nodeSize; r++) {
				for (int s = 0; s < nodeSize; s++) {
					if (v == r || v == s || r == s) {
						continue;
					}

					if (distances[r][v] + distances[v][s] < distances[r][s]) {
						distances[r][s] = distances[r][v] + distances[v][s];
					}
				}
			}

			printDistances();
		}
	}

	public void printDistances() {
		for (int s = 0; s < nodeSize; s++) {
			System.out.print("\t\t" + s);
		}

		System.out.println("");

		for (int r = 0; r < nodeSize; r++) {
			System.out.print(r + ":");

			for (int s = 0; s < nodeSize; s++) {
				System.out.print("\t\t" + distances[r][s]);
			}

			System.out.println("");
		}

		System.out.println();
	}
}
