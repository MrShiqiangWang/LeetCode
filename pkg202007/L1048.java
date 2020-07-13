package pkg202007;

import java.util.Arrays;
import java.util.Comparator;

import utils.ArrayHelper;

public class L1048 {

    public static void main(final String[] args) {
        final String[] words =
                ArrayHelper.stringToStrArray(
                        "[ksqvsyq,ks,kss,czvh,zczpzvdhx,zczpzvh,zczpzvhx,zcpzvh,zczvh,gr,grukmj,ksqvsq,gruj,kssq,ksqsq,grukkmj,grukj,zczpzfvdhx,gru]");
        System.out.println(new L1048().longestStrChain(words));
    }

    public int longestStrChain(final String[] words) {

        Arrays.sort(words, new Comparator<String>() {

            @Override
            public int compare(final String o1, final String o2) {
                return o1.length() - o2.length();
            }
        });

        int longest = 0;
        final int dp[] = new int[words.length];
        for (int i = 0; i < words.length; i++) {
            final String word = words[i];
            int max = 0;
            for (int j = i; j >= 0;) {
                if (word.length() == words[j].length()) {
                    j--;
                }
                else if (word.length() - 2 == words[j].length()) {
                    break;
                }
                else {
                    if (this.isHouji(words[j], word)) {
                        if (max < dp[j]) {
                            max = dp[j];
                        }
                    }
                    j--;
                }
            }
            dp[i] = max + 1;
            if (longest < dp[i]) {
                longest = dp[i];
            }
        }
        return longest;

    }

    private boolean isHouji(final String preStr, final String nextStr) {
        int i = 0;
        int j = 0;
        final char[] pre = preStr.toCharArray();
        final char[] next = nextStr.toCharArray();
        if (next.length - pre.length != 1) {
            return false;
        }
        for (; i < pre.length && j < next.length;) {
            if (pre[i] == next[j]) {
                i++;
                j++;
            }
            else {
                j++;
            }
        }
        if (j == i + 1) {
            return true;
        }
        if (i == j) {
            return true;
        }
        return false;
    }
}
