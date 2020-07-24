package history.pkg202007;

import java.util.Arrays;

public class L415 {

    public static void main(final String[] args) {
        System.out.println(new L415().addStrings("9", "99"));
    }

    public String addStrings(final String num1, final String num2) {
        final char[] first = num1.toCharArray();
        final char[] second = num2.toCharArray();
        int i = first.length - 1;
        int j = second.length - 1;

        final char[] re = new char[Math.max(first.length, second.length) + 1];
        int counter = re.length - 1;
        int jinwei = 0;
        while (i >= 0 || j >= 0) {
            if (i >= 0 && j >= 0) {
                re[counter] = (char) ((first[i] - '0' + second[j] - '0' + jinwei) % 10 + '0');
                jinwei = (first[i] - '0' + second[j] - '0' + jinwei) / 10;
                counter--;
                i--;
                j--;
            }
            else if (i >= 0) {
                re[counter] = (char) ((first[i] - '0' + jinwei) % 10 + '0');
                jinwei = (first[i] - '0' + jinwei) / 10;
                counter--;
                i--;
            }
            else {
                re[counter] = (char) ((second[j] - '0' + jinwei) % 10 + '0');
                jinwei = (second[j] - '0' + jinwei) / 10;
                counter--;
                j--;
            }
        }
        if (jinwei == 1) {
            re[0] = '1';
            return new String(re);
        }
        return new String(Arrays.copyOfRange(re, 1, re.length));
    }
}
