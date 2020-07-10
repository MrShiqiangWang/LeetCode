package pkg202007;

import java.util.Arrays;

import utils.ArrayHelper;

public class L167 {

    public static void main(final String[] args) {
        new ArrayHelper();
        System.out.println(new L167().twoSum(ArrayHelper.stringToArray("[2,3,4]"), 6));
    }

    public int[] twoSum(final int[] numbers, final int target) {
        for (int i = 0; i < numbers.length; i++) {
            final int newTarget = target - numbers[i];
            final int index = Arrays.binarySearch(numbers, i + 1, numbers.length, newTarget);
            if (index > -1) {
                final int[] result = { i, index };
                return result;
            }
        }
        return new int[0];
    }
}
