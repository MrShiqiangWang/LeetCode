package history.pkg201907;

public class Transpose {

    public int[][] transpose(final int[][] A) {
        final int result[][] = new int[A[0].length][A.length];

        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < A[i].length; j++) {
                result[j][i] = A[i][j];
            }
        }

        return result;
    }
}
