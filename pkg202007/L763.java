package pkg202007;

import java.util.ArrayList;
import java.util.List;

public class L763 {

    public static void main(final String[] args) {
        System.out.println((int) 'a');
    }

    public List<Integer> partitionLabels(final String S) {
        final char[] cs = S.toCharArray();
        final int[] counter = new int[26];
        for (int i = 0; i < cs.length; i++) {
            counter[cs[i] - 'a'] = i;
        }

        final List<Integer> result = new ArrayList<>();
        int j = 0, anchor = 0;
        for (int i = 0; i < cs.length; i++) {
            j = Math.max(j, counter[cs[i] - 'a']);
            if (i == j) {
                result.add(i - anchor + 1);
                anchor = i + 1;
            }
        }
        return result;
    }
}
