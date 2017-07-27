package pshcode.algorithm.sort;

import org.apache.commons.lang3.ArrayUtils;

/**
 * 병합정렬
 * 병합된 결과 저장을 위해 추가적인 buffer 메모리 공간이 필요하다.
 * 최선, 평균, 최악: O(nlogn)
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
		int firstIndex = start;
		int secondIndex = middle + 1;
		int bufferIndex = start;
		int remainIndex;

		System.out.print(String.format("firstIndex=%d~middle=%d, secondIndex=%d~end=%d", firstIndex, middle, secondIndex, end));

		while (firstIndex <= middle && secondIndex <= end) {
			if (values[firstIndex] <= values[secondIndex]) {
				buffer[bufferIndex] = values[firstIndex];
				firstIndex++;
			} else {
				buffer[bufferIndex] = values[secondIndex];
				secondIndex++;
			}

			bufferIndex++;
		}

		//병합하면서 먼저 한쪽의 부분집합이 buffer로 모두 들어갔을 경우, 나머지 부분집합을 buffer로 넣어준다.
		if (firstIndex > middle) {
			for (remainIndex = secondIndex; remainIndex <= end; remainIndex++, bufferIndex++) {
				buffer[bufferIndex] = values[remainIndex];
			}
		} else {
			for (remainIndex = firstIndex; remainIndex <= middle; remainIndex++, bufferIndex++) {
				buffer[bufferIndex] = values[remainIndex];
			}
		}

		for (int copyIndex = start; copyIndex <= end; copyIndex++) {
			values[copyIndex] = buffer[copyIndex];
		}

		printArray("", buffer);

	}

	private static void printArray(String comment, int[] values) {
		System.out.println(comment + ":\t" + ArrayUtils.toString(values));
	}
}
