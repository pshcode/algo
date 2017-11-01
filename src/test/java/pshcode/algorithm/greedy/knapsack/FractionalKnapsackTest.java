package pshcode.algorithm.greedy.knapsack;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * 부분 배낭 문제 TC.
 *
 * @author SungHoon, Park
 */
class FractionalKnapsackTest {
	private FractionalKnapsack sut = new FractionalKnapsack();

	@DisplayName("물건 5개 설정하기")
	@Test
	void setKnapsackItem() {
		//given
		KnapsackItem knapsackItem1 = new KnapsackItem("물건1", 1, 500);
		KnapsackItem knapsackItem2 = new KnapsackItem("물건2", 2, 300);
		KnapsackItem knapsackItem3 = new KnapsackItem("물건3", 3, 900);
		KnapsackItem knapsackItem4 = new KnapsackItem("물건4", 4, 800);

		//when
		sut.addKnapsackItem(knapsackItem1);
		sut.addKnapsackItem(knapsackItem2);
		sut.addKnapsackItem(knapsackItem3);
		sut.addKnapsackItem(knapsackItem4);

		//then
		assertNotNull(sut.knapsackItems);
		assertEquals(4, sut.knapsackItems.size());
	}

	@DisplayName("물건을 비율이 큰 순서대로 정렬하기")
	@Test
	void sortKnapsackItems() {
		//given
		KnapsackItem knapsackItem1 = new KnapsackItem("물건1", 1, 500);
		KnapsackItem knapsackItem2 = new KnapsackItem("물건2", 2, 300);
		KnapsackItem knapsackItem3 = new KnapsackItem("물건3", 3, 900);
		KnapsackItem knapsackItem4 = new KnapsackItem("물건4", 4, 800);

		//when
		sut.addKnapsackItem(knapsackItem1);
		sut.addKnapsackItem(knapsackItem2);
		sut.addKnapsackItem(knapsackItem3);
		sut.addKnapsackItem(knapsackItem4);
		sut.sortKnapsackItems();

		//then
		assertEquals("물건1", sut.knapsackItems.get(0).getName());
		assertEquals("물건3", sut.knapsackItems.get(1).getName());
		assertEquals("물건4", sut.knapsackItems.get(2).getName());
		assertEquals("물건2", sut.knapsackItems.get(3).getName());
	}

	@DisplayName("알고리즘을 실행하여 최적해 구하기")
	@Test
	void calcMaxPrice() {
		//given
		KnapsackItem knapsackItem1 = new KnapsackItem("물건1", 1, 500);
		KnapsackItem knapsackItem2 = new KnapsackItem("물건2", 2, 300);
		KnapsackItem knapsackItem3 = new KnapsackItem("물건3", 3, 900);
		KnapsackItem knapsackItem4 = new KnapsackItem("물건4", 4, 800);

		//when
		sut.addKnapsackItem(knapsackItem1);
		sut.addKnapsackItem(knapsackItem2);
		sut.addKnapsackItem(knapsackItem3);
		sut.addKnapsackItem(knapsackItem4);
		int actual = sut.calcMaxPrice(5);

		//then
		assertEquals(1600, actual);
		sut.printKnapsackItems();
	}
}