package pkg202007;

import java.util.Arrays;

public class L66 {

    public int[] plusOne(final int[] digits) {
        final int[] re = new int[digits.length + 1];
        int jinwei = 1;
        for (int i = re.length - 1; i >= 1; i--) {
            if (digits[i - 1] + jinwei == 10) {
                re[i] = 0;
                jinwei = 1;
            }
            else {
                re[i] = digits[i - 1] + jinwei;
                jinwei = 0;
            }
        }
        if (jinwei == 1) {
            re[0] = jinwei;
            return Arrays.copyOfRange(re, 1, re.length);
        }
        return Arrays.copyOfRange(re, 0, re.length);
    }
}
