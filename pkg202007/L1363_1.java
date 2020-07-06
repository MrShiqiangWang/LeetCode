package pkg202007;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import utils.ArrayHelper;

public class L1363_1 {

    public static void main(final String[] args) {
        final int[] digits = ArrayHelper.stringToArray("[9,8,6,8,6]");
        System.out.println(new L1363_1().largestMultipleOfThree(digits));
    }

    public String largestMultipleOfThree(final int[] digits) {
        int sum = 0;
        Integer minModule1 = null;
        Integer secondMinModule1 = null;
        Integer minModule2 = null;
        Integer secondMinModule2 = null;

        for (int i = 0; i < digits.length; i++) {
            final int module3 = digits[i] % 3;
            sum = (sum + module3) % 3;
            if (module3 == 1) {
                if (minModule1 == null) {
                    minModule1 = i;
                }
                else if (digits[minModule1] >= digits[i]) {
                    secondMinModule1 = minModule1;
                    minModule1 = i;
                }
            }
            else if (module3 == 2) {
                if (minModule2 == null) {
                    minModule2 = i;
                }
                else if (digits[minModule2] >= digits[i]) {
                    secondMinModule2 = minModule2;
                    minModule2 = i;
                }
            }
        }

        if (sum % 3 == 0) {
            return this.largestSum(digits, null, null);
        }
        else if (sum % 3 == 1) {
            if (minModule1 != null) {
                return this.largestSum(digits, minModule1, null);
            }
            else if (minModule2 != null && secondMinModule2 != null) {
                return this.largestSum(digits, minModule2, secondMinModule2);
            }
            else {
                return "";
            }
        }
        else {
            if (minModule2 != null) {
                return this.largestSum(digits, minModule2, null);
            }
            else if (minModule1 != null && secondMinModule1 != null) {
                return this.largestSum(digits, minModule1, secondMinModule1);
            }
            else {
                return "";
            }
        }
    }

    private String largestSum(final int[] digits, final Integer remove1, final Integer remove2) {
        final List<Integer> result = new ArrayList<>();
        for (int i = 0; i < digits.length; i++) {
            if (remove1 != null && i == remove1) {
                continue;
            }
            if (remove2 != null && i == remove2) {
                continue;
            }
            result.add(digits[i]);
        }
        Collections.sort(result, new Comparator<Integer>() {

            @Override
            public int compare(final Integer o1, final Integer o2) {
                return o2.compareTo(o1);
            }
        });
        if (!result.isEmpty() && result.get(0).equals(0)) {
            return "0";
        }
        final StringBuilder builder = new StringBuilder();
        for (int i = 0; i < result.size(); i++) {
            builder.append(result.get(i));
        }
        return builder.toString();
    }

}
