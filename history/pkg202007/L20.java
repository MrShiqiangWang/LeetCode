package history.pkg202007;

import java.util.Stack;

public class L20 {

    public boolean isValid(final String s) {
        final char[] chars = s.toCharArray();
        final Stack<Character> stack = new Stack<>();
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == '(' || chars[i] == '[' || chars[i] == '{') {
                stack.push(chars[i]);
            }
            else {
                if (stack.isEmpty()) {
                    return false;
                }
                final char c = stack.pop();
                if (chars[i] == ')' && c == '(') {
                    continue;
                }
                if (chars[i] == ']' && c == '[') {
                    continue;
                }
                if (chars[i] == '}' && c == '{') {
                    continue;
                }
                return false;
            }
        }
        if (!stack.isEmpty()) {
            return false;
        }
        return true;
    }
}
