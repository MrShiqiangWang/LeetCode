package pkg202007;

import utils.MatrixHelper;

public class L1499 {

    public static void main(final String[] args) {
        final int[][] matrix = MatrixHelper.stringToMatrix("[[1,3],[2,0],[5,10],[6,-10]]");

        System.out.println(new L1499().findMaxValueOfEquation(matrix, 1));
    }

    public int findMaxValueOfEquation(final int[][] points, final int k) {

        int max = Integer.MIN_VALUE;
        for (int i = 0; i < points.length - 1; i++) {
            // 遍历所有的点
            // 取出当前电
            final int point[] = points[i];
            // 从下一个点开始
            for (int j = i + 1; j < points.length && points[j][0] <= point[0] + k; j++) {
                max = Math.max(points[j][1] + point[1] + Math.abs(point[0] - points[j][0]), max);
            }
        }
        return max;
    }
}
