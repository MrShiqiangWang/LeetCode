package pkg202007;

public class L944 {

    public int minDeletionSize(final String[] A) {
        final boolean[] flags = new boolean[A[0].length()];
        for (int i = 0; i < A.length - 1; i++) {
            final char[] pre = A[i].toCharArray();
            final char[] next = A[i + 1].toCharArray();
            for (int j = 0; j < pre.length; j++) {
                if (pre[j] > next[j]) {
                    flags[j] = true;
                }
            }
        }
        int sum = 0;
        for (int i = 0; i < flags.length; i++) {
            if (flags[i] == true) {
                sum++;
            }
        }
        return sum;
    }
}
