package pshcode.algorithm.divideandconquer.closestpair;

import static pshcode.algorithm.divideandconquer.closestpair.PointUtils.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * @author SungHoon, Park
 */
public class ClosestPair {
	public double closestPair(List<Point> points) {
		Collections.sort(points, Comparator.comparingInt(Point::getX));

		return closestPairRecursive(points);
	}

	public double closestPairRecursive(List<Point> points) {
		int size = points.size();

		if (size <= 1) {
			return 0;
		}

		if (size == 2) {
			return distance(points.get(0), points.get(1));
		}

		if (size == 3) {
			return closestPair3Points(points);
		}

		int middleIndex = size / 2;
		Point middlePoint = points.get(middleIndex);

		double distanceLeft = closestPairRecursive(points.subList(0, middleIndex));
		double distanceRight = closestPairRecursive(points.subList(middleIndex, size));

		double minDistance = minDistance(distanceLeft, distanceRight);
		double centerBoxMinDistance = findCenterBoxMinDistance(points, middlePoint, minDistance);

		return minDistance(minDistance, centerBoxMinDistance);
	}

	public double closestPair3Points(List<Point> points) {
		Point point1 = points.get(0);
		Point point2 = points.get(1);
		Point point3 = points.get(2);

		double distance1 = distance(point1, point2);
		double distance2 = distance(point1, point3);
		double distance3 = distance(point2, point3);

		return minDistance(minDistance(distance1, distance2), distance3);
	}

	public double findCenterBoxMinDistance(List<Point> fullPoints, Point middlePoint, double minDistance) {
		List<Point> centerBoxPoints = new ArrayList<>();

		for (Point point : fullPoints) {
			if (Math.abs(point.getX() - middlePoint.getX()) < minDistance) {
				centerBoxPoints.add(point);
			}
		}

		Collections.sort(centerBoxPoints, Comparator.comparingInt(Point::getY));
		double centerBobxMinDistance = minDistance;

		for (int index1 = 0; index1 < centerBoxPoints.size(); index1++) {
			for (int index2 = index1 + 1; index2 < centerBoxPoints.size(); index2++) {
				Point point1 = centerBoxPoints.get(index1);
				Point point2 = centerBoxPoints.get(index2);

				if (Math.abs(point1.getY() - point2.getY()) >= minDistance) {
					break;
				}

				centerBobxMinDistance = minDistance(distance(point1, point2), minDistance);
			}
		}

		return centerBobxMinDistance;
	}
}
