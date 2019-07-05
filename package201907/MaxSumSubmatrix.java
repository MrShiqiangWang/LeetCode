package package201907;

public class MaxSumSubmatrix {

    public int maxSumSubmatrix(int[][] matrix, int k) {
        if (matrix.length == 0) {
            return 0;
        }
        int xlength = matrix.length;
        int ylength = matrix[0].length;

        int x1 = 0;
        int y1 = 0;// 矩形左上角点的位置

        for (; x1 < xlength; x1++) {
            for (; y1 < ylength; y1++) {
                for (int x2 = x1 + 1; x2 < xlength; x2++) {
                    for (int y2 = y1 + 1; y2 < ylength; y2++) {
                        // 坐标1
                        int lefttop = matrix[x1][y1];
                        int righttop = matrix[x2][y1];
                        //
                        int leftbottom = matrix[x1][y1];
                        int rightbottm = matrix[x2][y2];
                    }
                }
            }
        }
        return k;
    }
}
