package pshcode.algorithm.sort;

import org.apache.commons.lang3.ArrayUtils;

/**
 * 병합정렬.
 *
 * @author SungHoon, Park
 */
public class MergeSort {
	public static void main(String[] args) {
		int[] values = {80, 75, 10, 60, 15, 49, 12, 25};
		int[] buffer = new int[values.length];
		int start = 0;
		int end = values.length - 1;

		printArray("Start", values);
		mergeSort(values, buffer, start, end);
		printArray("End", buffer);
	}

	private static void mergeSort(int[] values, int[] buffer, int start, int end) {
		if (start < end) {
			int middle = (start + end) / 2;
			mergeSort(values, buffer, start, middle);
			mergeSort(values, buffer, middle + 1, end);
			mergeSortInternal(values, buffer, start, middle, end);
		}
	}

	private static void mergeSortInternal(int[] values, int[] buffer, int start, int middle, int end) {
		int i = start;
		int j = middle + 1;
		int k = start;
		int t = 0;

		while (i <= middle && j <= end) {
			if (values[i] <= values[j]) {
				buffer[k] = values[i];
				i++;
			} else {
				buffer[k] = values[j];
				j++;
			}
			k++;
		}

		if (i > middle) {
			for (t = j; t <= end; t++, k++) {
				buffer[k] = values[t];
			}
		} else {
			for (t = i; t <= middle; t++, k++) {
				buffer[k] = values[t];
			}
		}

		for (t = start; t <= end; t++) {
			values[t] = buffer[t];
		}

		printArray(String.format("middle:%d, i:%d, j:%d, k:%d, t:%d", middle, i, j, k, t) , buffer);
	}

	private static void printArray(String comment, int[] values) {
		System.out.println(comment + ":\t" + ArrayUtils.toString(values));
	}
}
