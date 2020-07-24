package history.pkg202007;

public class L766 {

    public boolean isToeplitzMatrix(int[][] matrix) {
        int j;
        int start = 0;
        int i;
        for (; start < matrix.length; start++) {
            i = start;
            j = 0;
            while (i < matrix.length && j < matrix[0].length) {
                if (i - 1 >= 0 && j - 1 >= 0) {
                    if (matrix[i][j] != matrix[i - 1][j - 1]) {
                        return false;
                    }
                }
                i++;
                j++;
            }
        }
        i = 0;
        start = 0;
        j = 0;
        for (; start < matrix[0].length; start++) {
            j = start;
            i = 0;
            while (i < matrix.length && j < matrix[0].length) {
                if (i - 1 >= 0 && j - 1 >= 0) {
                    if (matrix[i][j] != matrix[i - 1][j - 1]) {
                        return false;
                    }
                }
                i++;
                j++;
            }
        }
        return true;
    }
}
