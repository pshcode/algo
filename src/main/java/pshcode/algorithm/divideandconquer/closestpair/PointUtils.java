package pshcode.algorithm.divideandconquer.closestpair;

/**
 * @author SungHoon, Park
 */
public class PointUtils {
	public static double distance(Point point1, Point point2) {
		int doubleX = (point1.getX() - point2.getX()) * (point1.getX() - point2.getX());
		int doubleY = (point1.getY() - point2.getY()) * (point1.getY() - point2.getY());

		return Math.round(Math.sqrt(doubleX + doubleY) * 1000000) / 1000000.0;
	}

	public static double minDistance(double distance1, double distance2) {
		return (distance1 < distance2) ? distance1 : distance2;
	}
}
