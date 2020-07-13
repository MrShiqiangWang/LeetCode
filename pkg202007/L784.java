package pkg202007;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class L784 {

    public static void main(final String[] args) {
        System.out.println(new L784().letterCasePermutation("c"));
    }

    public List<String> letterCasePermutation(final String S) {
        final Set<String> result = new HashSet<>();
        final char[] cs = S.toCharArray();
        this.counter(result, cs, 0);
        return new ArrayList<>(result);
    }

    private void counter(final Set<String> result, final char[] cs, final int i) {
        if (i >= cs.length) {
            return;
        }
        result.add(new String(cs));
        if (cs[i] >= 'a' && cs[i] <= 'z') {
            cs[i] = (char) (cs[i] - 32);
            result.add(new String(cs));
            this.counter(result, cs, i + 1);
            cs[i] = (char) (cs[i] + 32);
        }

        if (cs[i] >= 'a' && cs[i] <= 'z') {
            cs[i] = (char) (cs[i] + 32);
            result.add(new String(cs));
            this.counter(result, cs, i + 1);
            cs[i] = (char) (cs[i] - 32);
        }
        this.counter(result, cs, i + 1);
    }

}
