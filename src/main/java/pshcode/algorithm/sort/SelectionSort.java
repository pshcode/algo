package pshcode.algorithm.sort;

import org.apache.commons.lang3.ArrayUtils;

/**
 * 선택정렬
 * 최선, 평균, 최악: O(n^2)
 *
 * @author SungHoon, Park
 */
public class SelectionSort {
	int[] values;

	public static void main(String[] args) {
		int[] values = {80, 75, 10, 60, 15, 49, 12, 25};

		printArray("Start", values);
		selectionSort(values);
		printArray("End", values);
	}

	public SelectionSort(int[] values) {
		this.values = values;
	}

	private static void selectionSort(int[] values) {
		int count = values.length;

		for (int firstIndex = 0; firstIndex < count; firstIndex++) {
			int min = firstIndex;
			boolean changed = false;

			for (int secondIndex = firstIndex + 1; secondIndex < count; secondIndex++) {
				if (values[secondIndex] < values[min]) {
					min = secondIndex;
					changed = true;
				}
			}

			if (changed) {
				int temp = values[firstIndex];
				values[firstIndex] = values[min];
				values[min] = temp;
			}

			printArray("Step-" + firstIndex, values);
		}
	}

	private static void printArray(String comment, int[] values) {
		System.out.println(comment + ":\t" + ArrayUtils.toString(values));
	}
}
