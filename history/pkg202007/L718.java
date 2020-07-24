package history.pkg202007;

public class L718 {

    public static void main(final String[] args) {

    }

    public int findLength(final int[] A, final int[] B) {
        final int max = this.findMax(A, B);
        return Math.max(max, this.findMax(B, A));
    }

    private int findMax(final int[] A, final int[] B) {
        int max = 0;
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < B.length; j++) {
                max = Math.max(max, this.findMax(A, B, i, j));
            }
        }
        return max;
    }

    private int findMax(final int[] a, final int[] b, int i, int j) {
        int max = 0;
        int tmp = 0;
        for (; i < a.length && j < b.length; i++, j++) {
            if (a[i] == b[j]) {
                tmp++;
                max = Math.max(max, tmp);
            }
            else {
                tmp = 0;
            }
        }
        return max;
    }

}
