package pshcode.algorithm.dynamicprogramming.knapsack;

import org.junit.jupiter.api.Test;

import pshcode.algorithm.greedy.knapsack.KnapsackItem;

/**
 * @author SungHoon, Park
 */
class ZeroOneKnapsackTest {
	@Test
	void test1() {
		KnapsackItem[] items = new KnapsackItem[3];
		items[0] = new KnapsackItem("물건A", 1, 600);
		items[1] = new KnapsackItem("물건B", 2, 1000);
		items[2] = new KnapsackItem("물건C", 3, 1200);

		ZeroOneKnapsack sut = new ZeroOneKnapsack(5, items);
		System.out.println(sut.getMaxProfit());
	}

	@Test
	void test2() {
		KnapsackItem[] items = new KnapsackItem[4];
		items[0] = new KnapsackItem("물건C", 4, 5);
		items[1] = new KnapsackItem("물건A", 1, 1);
		items[2] = new KnapsackItem("물건D", 5, 7);
		items[3] = new KnapsackItem("물건B", 3, 4);

		ZeroOneKnapsack sut = new ZeroOneKnapsack(7, items);
		System.out.println(sut.getMaxProfit());
	}
}