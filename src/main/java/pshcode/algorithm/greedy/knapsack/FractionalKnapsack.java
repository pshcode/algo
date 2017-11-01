package pshcode.algorithm.greedy.knapsack;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 부분 배낭 문제.
 *
 * @author SungHoon, Park
 */
public class FractionalKnapsack {
	List<KnapsackItem> knapsackItems;
	int maxPrice;

	public void addKnapsackItem(KnapsackItem knapsackItem) {
		if (knapsackItems == null) {
			knapsackItems = new ArrayList<KnapsackItem>();
		}

		knapsackItems.add(knapsackItem);
	}

	public void sortKnapsackItems() {
		Collections.sort(knapsackItems, (o1, o2) -> {
			int ratio1 = o1.getPrice() / o1.getWeight();
			int ratio2 = o2.getPrice() / o2.getWeight();

			return ratio2 - ratio1;
		});
	}

	public int calcMaxPrice(int capacity) {
		sortKnapsackItems();

		int currentWeight = 0;
		maxPrice = 0;

		for (KnapsackItem knapsackItem : knapsackItems) {
			int weight = knapsackItem.getWeight();

			if (currentWeight + weight < capacity) {
				knapsackItem.setSelected(weight);
				currentWeight += weight;
				maxPrice += knapsackItem.getPrice();
			} else {
				int remain = capacity - currentWeight;
				knapsackItem.setSelected(remain);
				maxPrice += (knapsackItem.getPrice() * knapsackItem.getSelected()) / weight;
				break;
			}
		}

		return maxPrice;
	}

	public void printKnapsackItems() {
		for (KnapsackItem knapsackItem : knapsackItems) {
			System.out.format("%s, 가격: %d, 무게: %d, 선택된 무게: %d\n", knapsackItem.getName(), knapsackItem.getPrice(), knapsackItem.getWeight(), knapsackItem.getSelected());
		}

		System.out.println("\n최대금액: " + maxPrice);
	}
}
