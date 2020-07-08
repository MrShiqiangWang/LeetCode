package pkg202007;

import java.util.Arrays;

public class L1502 {

    public boolean canMakeArithmeticProgression(int[] arr) {
        if (arr.length == 0) {
            return false;
        }
        if (arr.length == 1
                ||
                arr.length == 2) {
            return true;
        }
        Arrays.sort(arr);
        int increment = arr[1] - arr[0];
        for (int i = 2; i < arr.length; i++) {
            if (arr[i] - arr[i - 1] != increment) {
                return false;
            }
        }
        return true;
    }
}
