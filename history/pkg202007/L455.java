package history.pkg202007;

import java.util.Arrays;

public class L455 {

    public int findContentChildren(final int[] g, final int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int i = 0, j = 0;
        for (; i < g.length;) {
            for (; j < s.length; j++) {
                if (g[i] <= s[j]) {
                    i++;
                    j++;
                    break;
                }
            }

            if (j == s.length) {
                break;
            }
        }
        return i;
    }
}
