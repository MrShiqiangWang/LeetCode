package history.pkg202007;

import utils.ArrayHelper;

public class L922 {

    public static void main(final String[] args) {
        System.out.println(new L922().sortArrayByParityII(ArrayHelper.stringToArray("[3,4]")));
    }

    public int[] sortArrayByParityII(final int[] A) {
        final int[] result = new int[A.length];
        int ou = 0;
        int ji = 1;
        for (int i = 0; i < A.length; i++) {
            if (A[i] % 2 == 0) {
                result[ou] = A[i];
                ou = ou + 2;
            }
            else {
                result[ji] = A[i];
                ji = ji + 2;
            }
        }
        return result;
    }
}
