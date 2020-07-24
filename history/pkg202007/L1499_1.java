package history.pkg202007;

import utils.MatrixHelper;

public class L1499_1 {

    public static void main(final String[] args) {
        final int[][] matrix = MatrixHelper.stringToMatrix("[[1,3],[2,0],[5,10],[6,-10]]");

        System.out.println(new L1499_1().findMaxValueOfEquation(matrix, 1));
    }

    public int findMaxValueOfEquation(final int[][] points, final int k) {

        int max = Integer.MIN_VALUE;
        for (int j = 1; j < points.length; j++) {
            final int tmp = points[j][0] + points[j][1];
            for (int i = j - 1; i >= 0 && points[j][0] - points[i][0] <= k; i--) {
                max = Math.max(points[i][1] - points[i][0] + tmp, max);
            }
        }
        return max;
    }
}
