package history.pkg202007;

import java.util.Arrays;

import utils.ArrayHelper;

public class L976 {

    public static void main(final String[] args) {
        System.out.println(new L976().largestPerimeter(ArrayHelper.stringToArray("[2,1,2]")));
    }

    public int largestPerimeter(final int[] A) {

        // 首先判断三角�?
        Arrays.sort(A);
        for (int i = A.length - 3; i >= 0; i--) {
            if (A[i] + A[i + 1] > A[i + 2]) {
                return A[i] + A[i + 1] + A[i + 2];
            }
        }
        return 0;

    }
}
