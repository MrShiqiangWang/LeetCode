package history.pkg202007;

import java.util.Stack;

public class L1047 {

    public String removeDuplicates(final String S) {
        final char[] cs = S.toCharArray();
        final Stack<Character> stack = new Stack<>();
        for (int i = 0; i < cs.length; i++) {
            if (stack.isEmpty()) {
                stack.push(cs[i]);
            }
            else {
                final char top = stack.peek();
                if (top == cs[i]) {
                    stack.pop();
                }
                else {
                    stack.push(cs[i]);
                }
            }
        }

        final StringBuilder builder = new StringBuilder();
        for (int i = 0; i < stack.size(); i++) {
            builder.append(stack.get(i));
        }
        return builder.toString();
    }
}
