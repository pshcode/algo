package pshcode.algorithm.divideandconquer.closestpair;

import lombok.Getter;
import lombok.Setter;

/**
 * @author SungHoon, Park
 */
@Getter
@Setter
public class Point {
	int x;
	int y;

	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}

	@Override
	public String toString() {
		return String.format("(%d, %d)", x, y);
	}
}
