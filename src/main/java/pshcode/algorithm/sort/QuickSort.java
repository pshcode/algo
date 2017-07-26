package pshcode.algorithm.sort;

import org.apache.commons.lang3.ArrayUtils;

/**
 * 퀵정렬.
 *
 * @author SungHoon, Park
 */
public class QuickSort {
	public static void main(String[] args) {
		int[] values = {80, 75, 10, 60, 15, 49, 12, 25};
		int start = 0;
		int end = values.length - 1;

		printArray("Start", values);
		quickSort(values, start, end);
		printArray("End", values);
	}

	private static void quickSort(int[] values, int start, int end) {
		if (start < end) {
			int pivot = pivotAndSwitch(values, start, end);
			quickSort(values, start, pivot - 1);
			quickSort(values, pivot + 1, end);
		}
	}

	private static int pivotAndSwitch(int[] values, int start, int end) {
		int left = start;
		int right = end;
		int pivot = end;
		int temp;

		while (left < right) {
			while ((left < right) && (values[left] < values[pivot])) {
				left++;
			}

			while ((left < right) && (values[right] >= values[pivot])) {
				right--;
			}

			if (left < right) {
				temp = values[left];
				values[left] = values[right];
				values[right] = temp;
			}

			printArray("Change", values);
		}

		temp = values[right];
		values[right] = values[pivot];
		values[pivot] = temp;

		return right;
	}

	private static void printArray(String comment, int[] values) {
		System.out.println(comment + ":\t" + ArrayUtils.toString(values));
	}
}
