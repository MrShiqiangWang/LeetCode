package pkg202007;

import java.util.Stack;

public class L482_1 {

    public String licenseKeyFormatting(final String S, final int K) {
        final char[] cs = S.toCharArray();
        final Stack<Character> stack = new Stack<>();
        for (int i = 0; i < cs.length; i++) {
            if (cs[i] != '-') {
                stack.push(Character.toUpperCase(cs[i]));
            }
        }
        int tik = 0;
        final StringBuilder builder = new StringBuilder();
        while (!stack.isEmpty()) {
            if (tik == K) {
                builder.append('-');
                tik = 0;
            }
            final Character character = stack.pop();
            builder.append(character);
            tik++;
        }
        return builder.reverse().toString();
    }
}
