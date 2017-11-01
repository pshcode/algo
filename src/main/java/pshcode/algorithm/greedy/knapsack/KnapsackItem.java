package pshcode.algorithm.greedy.knapsack;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * 배낭 물건.
 *
 * @author SungHoon, Park
 */
@Getter
@Setter
@ToString
public class KnapsackItem {
	private String name;
	private int weight;
	private int price;
	private int selected;

	public KnapsackItem(String name, int weight, int price) {
		this.name = name;
		this.weight = weight;
		this.price = price;
	}
}
