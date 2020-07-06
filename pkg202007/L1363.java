package pkg202007;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import utils.ArrayHelper;

public class L1363 {

    public static void main(final String[] args) {
        final int[] array = ArrayHelper.stringToArray("[1,1,1,2]");
        System.out.println(new L1363().largestMultipleOfThree(array));
    }

    public String largestMultipleOfThree(final int[] digits) {
        final int sum = this.sum(digits);
        final int[] dp = new int[digits.length];
        for (int i = 0; i < dp.length; i++) {
            dp[i] = -1;
        }
        final Map<String, String> max = new HashMap<>();
        return this.largestMultipleOfThree(digits, sum, dp, max);
    }

    private boolean end(final int[] dp) {
        for (int i = 0; i < dp.length; i++) {
            if (dp[i] == -1) {
                return false;
            }
        }
        return true;
    }

    private String getFromMap(final Map<String, String> max, final int[] dp) {
        final String key = this.getKey(dp);
        if (!max.containsKey(key)) {
            return null;
        }
        return max.get(key);
    }

    private String getKey(final int[] dp) {
        final StringBuilder builder = new StringBuilder();
        for (int i = 0; i < dp.length; i++) {
            if (dp[i] == -1) {
                builder.append(i);
                builder.append("-");
            }
        }
        return builder.toString();
    }

    private String getLargest(final String largest, final String result) {
        if (largest == "") {
            return result;
        }
        if (result == "") {
            return largest;
        }
        if (largest.length() != result.length()) {
            if (largest.length() > result.length()) {
                return largest;
            }
            return result;
        }
        if (largest.compareTo(result) < 0) {
            return result;
        }
        return largest;
    }

    private String largest(final int[] digits, final int[] dp) {
        final List<Integer> result = new ArrayList<>();
        for (int i = 0; i < digits.length; i++) {
            if (dp[i] == -1) {
                result.add(digits[i]);
            }
        }
        if (result.isEmpty()) {
            return "";
        }
        Collections.sort(result, new Comparator<Integer>() {

            @Override
            public int compare(final Integer o1, final Integer o2) {
                return o2.compareTo(o1);
            }
        });

        if (result.get(0) == 0) {
            return "0";
        }
        final StringBuilder builder = new StringBuilder();
        for (int i = 0; i < result.size(); i++) {
            builder.append(result.get(i));
        }
        return builder.toString();
    }

    private String largestMultipleOfThree(final int[] digits, final int sum, final int[] dp, final Map<String, String> max) {
        if (sum % 3 == 0) {
            return this.largest(digits, dp);
        }
        if (this.end(dp)) {
            return "";
        }
        String largest = "";

        for (int i = 0; i < digits.length; i++) {
            if (dp[i] == -1) {
                dp[i] = 1;
                final String data = this.getFromMap(max, dp);
                if (data == null) {
                    final String result = this.largestMultipleOfThree(digits, sum - digits[i], dp, max);
                    this.setToMap(max, dp, result);
                    largest = this.getLargest(largest, result);
                }
                dp[i] = -1;
            }
        }
        return largest;
    }

    private void setToMap(final Map<String, String> max, final int[] dp, final String result) {
        final String key = this.getKey(dp);
        max.put(key, result);
    }

    private int sum(final int[] digits) {
        int sum = 0;
        for (int i = 0; i < digits.length; i++) {
            sum += digits[i];
        }
        return sum;
    }

}
