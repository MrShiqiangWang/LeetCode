package history.pkg202007;

public class L812 {
	public double largestTriangleArea(int[][] points) {
		double max = 0;
		for (int i = 0; i < points.length; i++) {
			for (int j = i + 1; j < points.length; j++) {
				for (int k = j + 1; k < points.length; k++) {
					max = Math.max(max, area(points[i], points[j], points[k]));
				}
			}
		}
		return max;
	}

	private double area(int[] P, int[] Q, int[] R) {
		return 0.5 * Math.abs(P[0] * Q[1] + Q[0] * R[1] + R[0] * P[1] - P[1] * Q[0] - Q[1] * R[0] - R[1] * P[0]);
	}
}
