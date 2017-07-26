package pshcode.algorithm.sort;

import org.apache.commons.lang3.ArrayUtils;

/**
 * 선택정렬.
 *
 * @author SungHoon, Park
 */
public class SelectionSort {
	public static void main(String[] args) {
		int[] values = {80, 75, 10, 60, 15, 49, 12, 25};

		printArray("Start", values);
		selectionSort(values);
		printArray("End", values);
	}

	private static void selectionSort(int[] values) {
		int count = values.length;

		for (int i = 0; i < count; i++) {
			int min = i;
			boolean changed = false;

			for (int j = i + 1; j < count; j++) {
				if (values[j] < values[min]) {
					min = j;
					changed = true;
				}
			}

			if (changed) {
				int temp = values[i];
				values[i] = values[min];
				values[min] = temp;
			}

			printArray("Step-" + i, values);
		}
	}

	private static void printArray(String comment, int[] values) {
		System.out.println(comment + ":\t" + ArrayUtils.toString(values));
	}
}
