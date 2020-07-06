package history.pkg201906;

public class SortedSquares {

    public static void main(final String[] args) {
        final int[] A = { -4, -1, 0, 3, 10 };
        System.out.println(new SortedSquares().sortedSquares(A).toString());
    }

    public int[] sortedSquares(final int[] A) {
        final int length = A.length;
        final int[] result = new int[length];
        int x = 0;
        int y = length - 1;
        int xMax = A[x] * A[x];
        int yMax = A[y] * A[y];
        for (int i = length - 1; i >= 0; i--) {
            if (xMax >= yMax) {
                result[i] = xMax;
                x++;
                if (x < length) {
                    xMax = A[x] * A[x];
                }
            }
            else {
                result[i] = yMax;
                y--;
                if (y >= 0) {
                    yMax = A[y] * A[y];
                }
            }
        }
        return result;
    }
}
