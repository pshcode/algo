package pshcode.algorithm.sort;

import org.apache.commons.lang3.ArrayUtils;

/**
 * 퀵정렬
 * 최선, 평균: O(nlogn)
 * 최악: O(n^2)
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

	/**
	 * 분할될 때 피벗을 기준으로 좌우측이 없을 경우, start가 end보다 클 수 있다.
	 */
	private static void quickSort(int[] values, int start, int end) {
		if (start < end) {
			int pivot = partitionQuickSort(values, start, end);
			quickSort(values, start, pivot - 1);
			quickSort(values, pivot + 1, end);
		}
	}

	private static int partitionQuickSort(int[] values, int start, int end) {
		int left = start;
		int right = end;
		int pivot = end;
		int temp;

		while (notEquals(left, right)) {
			while (notEquals(left, right) && (values[left] < values[pivot])) {
				left++;
			}

			while (notEquals(left, right) && (values[right] >= values[pivot])) {
				right--;
			}

			if (notEquals(left, right)) {
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

	private static boolean notEquals(int left, int right) {
		return left != right;
	}

	private static void printArray(String comment, int[] values) {
		System.out.println(comment + ":\t" + ArrayUtils.toString(values));
	}
}
