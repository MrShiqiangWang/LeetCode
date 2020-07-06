package history.pkg201906;

public class FlipAndInvertImage {

    public int[][] flipAndInvertImage(final int[][] A) {
        for (int i = 0; i < A.length; i++) {
            this.reverse(A[i]);
        }
        return A;
    }

    private void reverse(final int[] is) {
        for (int i = 0; i < is.length / 2; i++) {
            final int tmp = is[i];
            is[i] = is[is.length - 1 - i];
            is[i] = tmp;
        }
        for (int i = 0; i < is.length; i++) {
            is[i] = this.reverseDigit(is[i]);
        }
    }

    private int reverseDigit(final int tmp) {
        if (tmp == 0) {
            return 1;
        }
        return 0;
    }
}
