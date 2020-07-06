package history.pkg201907;

public class MaxSumSubmatrix {

    public int maxSumSubmatrix(final int[][] matrix, final int k) {
        if (matrix.length == 0) {
            return 0;
        }
        final int xlength = matrix.length;
        final int ylength = matrix[0].length;

        int x1 = 0;
        int y1 = 0;// 矩形左上角点的位置

        for (; x1 < xlength; x1++) {
            for (; y1 < ylength; y1++) {
                for (int x2 = x1 + 1; x2 < xlength; x2++) {
                    for (int y2 = y1 + 1; y2 < ylength; y2++) {
                    }
                }
            }
        }
        return k;
    }
}
