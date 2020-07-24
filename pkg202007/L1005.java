package pkg202007;

import java.util.Arrays;

public class L1005 {

    public int largestSumAfterKNegations(final int[] A, final int K) {
        for (int i = 0; i < K; i++) {
            Arrays.sort(A);
            A[0] = -A[0];
        }

        int sum = 0;
        for (int i = 0; i < A.length; i++) {
            sum += A[i];
        }
        return sum;
    }
}
