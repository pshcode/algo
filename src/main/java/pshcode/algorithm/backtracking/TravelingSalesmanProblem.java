package pshcode.algorithm.backtracking;

/**
 * @author SungHoon, Park
 */
public class TravelingSalesmanProblem {
	private static final int NUM_OF_NODE = 4;
	private static final int A = 0;

	private static int BEST_PATH[] = new int[NUM_OF_NODE + 1];
	private static int MIN_COST = 99999;

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

	public void backTracking(int[][] costGraph, int[] path, int[] bestPath, int step, int nowCost) {
		int currentNode, nextNode, totalCost;

		if (isValid(path, step)) {
			currentNode = path[step];

			if (step == NUM_OF_NODE - 1) {
				nextNode = path[0];
				path[step + 1] = nextNode;
				totalCost = nowCost + costGraph[currentNode][nextNode];

				if (totalCost < MIN_COST) {
					MIN_COST = totalCost;
					arrayCopy(path, bestPath);
					System.out.print("*");
				}

				printPath(costGraph, bestPath, totalCost);
			} else {
				for (int toNode = 1; toNode < NUM_OF_NODE; toNode++) {
					nextNode = toNode;
					path[step + 1] = nextNode;
					totalCost = nowCost + costGraph[currentNode][nextNode];

					backTracking(costGraph, path, bestPath, step + 1, totalCost);
				}
			}
		}

	}

	public void arrayCopy(int[] originalArr, int[] newArr) {
		for (int i = 0; i < originalArr.length; i++) {
			newArr[i] = originalArr[i];
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
		travelingSalesmanProblem.backTracking(costGraph, path, travelingSalesmanProblem.BEST_PATH, 0, 0);
		travelingSalesmanProblem.printPath(costGraph, travelingSalesmanProblem.BEST_PATH, travelingSalesmanProblem.MIN_COST);
	}
}
