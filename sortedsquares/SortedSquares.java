package sortedsquares;

public class SortedSquares {

    public int[] sortedSquares(int[] A) {
        int length = A.length;
        int[] result = new int[length];
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

    public static void main(String[] args) {
        int[] A = { -4, -1, 0, 3, 10 };
        System.out.println(new SortedSquares().sortedSquares(A).toString());
    }
}
