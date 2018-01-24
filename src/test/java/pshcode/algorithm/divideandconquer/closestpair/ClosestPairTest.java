package pshcode.algorithm.divideandconquer.closestpair;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * @author SungHoon, Park
 */
class ClosestPairTest {
	private ClosestPair sut = new ClosestPair();

	/*@DisplayName("좌표 정보를 X 좌표 기준으로 정렬한다")
	@Test
	void sortPoints() {
		//given
		List<Point> points = new ArrayList<>();
		points.add(new Point(2, 5));
		points.add(new Point(15, 30));
		points.add(new Point(40, 50));
		points.add(new Point(5, 2));
		points.add(new Point(15, 10));
		points.add(new Point(10, 5));

		//when
		sut.sortPoints(points);

		//then
		assertEquals("(2, 5)", points.get(0).toString());
		assertEquals("(5, 2)", points.get(1).toString());
		assertEquals("(10, 5)", points.get(2).toString());
		assertEquals("(15, 30)", points.get(3).toString());
		assertEquals("(15, 10)", points.get(4).toString());
		assertEquals("(40, 50)", points.get(5).toString());
	}*/

	/*@DisplayName("두 점 사이의 거리를 구한다")
	@Test
	void getDistance() {
		//given
		Point point1 = new Point(0, 0);
		Point point2 = new Point(3, 4);

		//when
		double actual = sut.getDistance(point1, point2);

		//then
		assertEquals(5.0, actual);
	}*/

	@DisplayName("점이 3개일 때 가장 가까운 두점의 거리를 구한다")
	@Test
	void closestPair3Points() {
		//given
		List<Point> points = new ArrayList<>();
		points.add(new Point(2, 5));
		points.add(new Point(15, 30));
		points.add(new Point(40, 50));

		//when
		double actual = sut.closestPair3Points(points);

		//then
		assertEquals(28.18, actual);
	}

	@Test
	void name() {
		Point point1 = new Point(2, 5);
		Point point2 = new Point(15, 30);
		Point point3 = new Point(40, 50);
		Point point4 = new Point(5, 2);
		Point point5 = new Point(15, 10);
		Point point6 = new Point(10, 5);

		List<Point> points = new ArrayList<>();
		points.add(point1);
		points.add(point2);
		points.add(point3);
		points.add(point4);
		points.add(point5);
		points.add(point6);

		sut.closestPairRecursive(points);
	}

	@Test
	void name2() {
		Point point1 = new Point(2, 5);
		Point point2 = new Point(15, 30);
		Point point3 = new Point(40, 50);
		Point point4 = new Point(5, 2);
		Point point5 = new Point(15, 10);
		Point point6 = new Point(10, 5);

		List<Point> points = new ArrayList<>();
		points.add(point1);
		points.add(point2);
		points.add(point3);
		points.add(point4);
		points.add(point5);
		points.add(point6);

		double actual = sut.closestPair(points);

		assertEquals(4.242641, actual);
	}
}