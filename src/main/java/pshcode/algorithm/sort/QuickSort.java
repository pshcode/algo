package pshcode.algorithm.sort;

import lombok.Getter;

/**
 * 퀵정렬.
 * 최선, 평균: O(nlogn)
 * 최악: O(n^2)
 *
 * @author SungHoon, Park
 */
public class QuickSort {
	@Getter
	int[] values;

	public QuickSort(int[] values) {
		this.values = values;
	}

	/**
	 * 분할될 때 피벗을 기준으로 좌우측이 없을 경우, start가 end보다 클 수 있다.
	 */
	public void sort(int start, int end) {
		if (start < end) {
			int pivot = partitionQuickSort(start, end);
			sort(start, pivot - 1);
			sort(pivot + 1, end);
		}
	}

	private int partitionQuickSort(int start, int end) {
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
		}

		temp = values[right];
		values[right] = values[pivot];
		values[pivot] = temp;

		return right;
	}

	private boolean notEquals(int left, int right) {
		return left != right;
	}
}
