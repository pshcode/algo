package pshcode.algorithm.sort;

import lombok.Getter;

/**
 * 선택정렬.
 * 최선, 평균, 최악: O(n^2)
 *
 * @author SungHoon, Park
 */
public class SelectionSort {
	@Getter
	int[] values;

	public SelectionSort(int[] values) {
		this.values = values;
	}

	public void sort() {
		int arraySize = values.length;

		for (int firstIndex = 0; firstIndex < arraySize; firstIndex++) {
			int minIndex = firstIndex;

			for (int secondIndex = firstIndex + 1; secondIndex < arraySize; secondIndex++) {
				if (values[secondIndex] < values[minIndex]) {
					minIndex = secondIndex;
				}
			}

			if (minIndex != firstIndex) {
				int temp = values[firstIndex];
				values[firstIndex] = values[minIndex];
				values[minIndex] = temp;
			}
		}
	}
}
