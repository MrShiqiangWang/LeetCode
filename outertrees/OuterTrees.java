package outertrees;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.Set;

class Point {
	int x;
	int y;

	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + x;
		result = prime * result + y;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Point other = (Point) obj;
		if (x != other.x)
			return false;
		if (y != other.y)
			return false;
		return true;
	}
	
	

}

public class OuterTrees {

	

	public int[][] outerTrees(int[][] points) {
		// n¸öµãµÄÅÅÐò
		int n = points.length;

		Arrays.sort(points, new Comparator<int[]>() {

			@Override
			public int compare(int[] o1, int[] o2) {
				if ((o1[0] < o2[0]) || (o1[0] == o2[0] && o1[1] < o2[1])) {
					return -1;
				} else {
					return 1;
				}
			}
		});

		int[][] res = new int[2 * n][2];

		for (int i = 0; i < res.length; i++) {
			res[i][0] = -1;
			res[i][1] = -1;
		}
		int k = 0;

		boolean has = false;

		for (int i = 0; i < n; i++) {
			while (k > 1 && getExternalProd(res[k - 2], res[k - 1], points[i]) < 0)
				k--;
			if (points[i][0] == 0 && points[i][1] == 0) {
				has = true;
			}
			res[k++] = points[i];
		}

		for (int i = n - 2, t = k; i >= 0; i--) {
			while (k > t && getExternalProd(res[k - 2], res[k - 1], points[i]) < 0)
				k--;
			if (points[i][0] == 0 && points[i][1] == 0) {
				has = true;
			}
			res[k++] = points[i];
		}

		Set<Point> set = new HashSet<>();
		for (int i = 0; i < res.length; i++) {
			Point p = new Point(res[i][0], res[i][1]);
			if (p.x != -1 && p.y != -1) {
				set.add(p);
			}
		}

		int[][] result = new int[set.size()][2];

		int i = 0;
		for (Point p : set) {
			result[i][0] = p.x;
			result[i][1] = p.y;
			i++;
		}
		return result;
	}

	private int getExternalProd(int[] x, int[] y, int[] z) {
		int[] edge1 = { y[0] - x[0], y[1] - x[1] };
		int[] edge2 = { z[0] - y[0], z[1] - y[1] };
		return edge1[0] * edge2[1] - edge1[1] * edge2[0];
	}
}
