package pshcode.algorithm.backtracking;

/**
 * @author SungHoon, Park
 */
public class TravelingSalesmanProblem {
	private static final int NUM_OF_NODE = 4;
	private static final int A = 0;

	private static int bestPath[] = new int[NUM_OF_NODE + 1];
	private static int minCost = Integer.MAX_VALUE;

	public void printPath(int[][] costGraph, int[] path, int minCost) {
		for (int i = 0; i <= NUM_OF_NODE; i++) {
			if (i > 0) {
				System.out.print(" -(" + costGraph[path[i - 1]][path[i]] + ")-> ");
			}

			System.out.print((char)('A' + path[i]));
		}

		System.out.print("\t비용: " + minCost + "\n");
	}

	public boolean isValid(int path[], int step) {
		for (int i = 0; i < step; i++) {
			if (path[i] == path[step]) {
				return false;
			}
		}

		return true;
	}

	public void tspBackTracking(int[][] costGraph, int[] path, int step, int nowCost) {
		if (isValid(path, step)) {
			int currentNode = path[step];
			int nextNode, totalCost;

			if (isLastNode(step)) {
				nextNode = path[0];
				totalCost = nowCost + costGraph[currentNode][nextNode];

				path[step + 1] = nextNode;

				if (totalCost < minCost) {
					minCost = totalCost;
					changeBestPath(path);
					System.out.print("* ");
				}

				printPath(costGraph, path, totalCost);
			} else {
				for (int toNode = 1; toNode < NUM_OF_NODE; toNode++) {
					nextNode = toNode;
					path[step + 1] = nextNode;
					totalCost = nowCost + costGraph[currentNode][nextNode];

					tspBackTracking(costGraph, path, step + 1, totalCost);
				}
			}
		}
	}

	private boolean isLastNode(int step) {
		return step == NUM_OF_NODE - 1;
	}

	public void changeBestPath(int[] originalArr) {
		for (int i = 0; i < originalArr.length; i++) {
			bestPath[i] = originalArr[i];
		}
	}

	public static void main(String[] args) {
		int costGraph[][] = {
			{0, 10, 15, 20},
			{10, 0, 35, 25},
			{15, 35, 0, 30},
			{20, 25, 30, 0}
		};

		int path[] = new int[NUM_OF_NODE + 1];
		path[0] = A;

		TravelingSalesmanProblem travelingSalesmanProblem = new TravelingSalesmanProblem();
		travelingSalesmanProblem.tspBackTracking(costGraph, path, 0, 0);
		travelingSalesmanProblem.printPath(costGraph, travelingSalesmanProblem.bestPath, travelingSalesmanProblem.minCost);
	}
}
