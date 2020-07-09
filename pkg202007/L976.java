package pkg202007;

import java.util.Arrays;

import com.sun.accessibility.internal.resources.accessibility;

import utils.ArrayHelper;

public class L976 {

    public static void main(String[] args) {
        System.out.println(new L976().largestPerimeter(ArrayHelper.stringToArray("[2,1,2]")));
    }

    public int largestPerimeter(int[] A) {

        // 首先判断三角形
        Arrays.sort(A);
        for (int i = A.length - 3; i >= 0; i--) {
            if (A[i] + A[i + 1] > A[i + 2]) {
                return A[i] + A[i + 1] + A[i + 2];
            }
        }
        return 0;

    }
}