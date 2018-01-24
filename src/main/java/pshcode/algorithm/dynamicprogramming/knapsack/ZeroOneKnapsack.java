package pshcode.algorithm.dynamicprogramming.knapsack;

import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.math.NumberUtils;

import pshcode.algorithm.greedy.knapsack.KnapsackItem;

/**
 * @author SungHoon, Park
 */
public class ZeroOneKnapsack {
	int capacity;
	KnapsackItem[] items;
	int ppValues[][];

	public ZeroOneKnapsack(int capacity, KnapsackItem[] items) {
		if (capacity == 0 || ArrayUtils.isEmpty(items)) {
			throw new IllegalArgumentException("incorrect parameters!");
		}

		this.capacity = capacity;
		this.items = items;
		this.ppValues = new int[items.length + 1][capacity + 1];
	}

	public int getMaxProfit() {
		for (int i = 0; i <= items.length; i++) {
			for (int w = 0; w <= capacity; w++) {
				if (i == 0 || w == 0) {
					continue;
				}

				if (items[i - 1].getWeight() <= w) {
					ppValues[i][w] = NumberUtils.max(items[i - 1].getPrice() + ppValues[i - 1][w - items[i - 1].getWeight()], ppValues[i - 1][w]);
				} else {
					ppValues[i][w] = ppValues[i - 1][w];
				}
			}
			printAll();
		}

		return ppValues[items.length][capacity];
	}

	public void printAll() {
		for (int i = 0; i < ppValues.length; i++) {
			if (i != 0) {
				System.out.print("(" + items[i - 1].getPrice() + "원, " + items[i - 1].getWeight() + "kg) ");
			}

			for (int w = 0; w < ppValues[i].length; w++) {
				System.out.print("[" + ppValues[i][w] + "]  ");
			}

			System.out.println();
		}

		System.out.println();
	}
}
