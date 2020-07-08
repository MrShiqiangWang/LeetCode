package pkg202007;

import java.util.Stack;

public class L844 {

    public boolean backspaceCompare(final String S, final String T) {
        final String s1 = this.getString(S);
        final String t1 = this.getString(T);
        return s1.equals(t1);
    }

    private String getString(final String s) {
        final char[] cs = s.toCharArray();
        final Stack<Character> stack = new Stack<>();
        for (int i = 0; i < cs.length; i++) {
            if (cs[i] == '#') {
                stack.pop();
            }
            else {
                stack.push(cs[i]);
            }
        }
        final StringBuilder builder = new StringBuilder();
        for (int i = 0; i < stack.size(); i++) {
            builder.append(stack.get(i));
        }
        return builder.toString();
    }
}
