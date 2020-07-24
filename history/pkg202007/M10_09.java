package history.pkg202007;

import utils.MatrixHelper;

public class M10_09 {

    public static void main(final String[] args) {
        System.out.println(
                new M10_09().searchMatrix(MatrixHelper.stringToMatrix("[[5,6,9],[9,10,11],[11,14,18]]"), 9));
    }

    public boolean searchMatrix(final int[][] matrix, final int target) {
        if (matrix.length == 0) {
            return false;
        }
        final int i = 0;
        final int j = 0;
        final int M = matrix.length;
        final int N = matrix[0].length;
        return this.searchMatrix(matrix, target, i, j, M - 1, N - 1);
    }

    private boolean searchMatrix(final int[][] matrix, final int target, int i, int j, int m, int n) {
        if (i > m || j > n) {
            return false;
        }
        if (matrix[i][j] == target || matrix[m][n] == target) {
            return true;
        }
        else if (i == m && j == n) {
            return false;
        }
        if (matrix[0][0] > target) {
            return false;
        }
        if (matrix[matrix.length - 1][matrix[0].length - 1] < target) {
            return false;
        }
        // 先左上角�?始找
        for (; i < m;) {
            if (matrix[i][j] < target && matrix[i][n] < target) {
                i++;
            }
            else {
                if (matrix[i][j] == target || matrix[i][n] == target) {
                    return true;
                }
                break;
            }
        }
        for (; j < n;) {
            if (matrix[i][j] < target && matrix[m][j] < target) {
                j++;
            }
            else {
                if (matrix[i][j] == target || matrix[m][j] == target) {
                    return true;
                }
                break;
            }
        }
        for (; m > i;) {
            if (matrix[m][j] > target && matrix[m][n] > target) {
                m--;
            }
            else {
                if (matrix[m][j] == target || matrix[m][n] == target) {
                    return true;
                }
                break;
            }
        }
        for (; n > j;) {
            if (matrix[i][n] > target && matrix[m][n] > target) {
                n--;
            }
            else {
                if (matrix[i][n] == target || matrix[m][n] == target) {
                    return true;
                }
                break;
            }
        }
        return this.searchMatrix(matrix, target, i, j, m, n);
    }
}
