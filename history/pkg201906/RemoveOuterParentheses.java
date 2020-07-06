package history.pkg201906;

import java.util.Stack;

public class RemoveOuterParentheses {

    public String removeOuterParentheses(final String S) {
        final StringBuffer stringBuffer = new StringBuffer();
        final Stack<Character> stacks = new Stack<Character>();
        final int length = S.length();
        for (int i = 0; i < length; i++) {
            final Character character = S.charAt(i);
            if (character == '(') {
                if (stacks.size() != 0) {
                    stringBuffer.append(character);
                }
                stacks.push('(');
            }
            else {
                stacks.pop();
                if (stacks.size() != 0) {
                    stringBuffer.append(character);
                }
            }
        }
        return stringBuffer.toString();
    }

    public String removeOuterParentheses1(final String S) {

        return "";
    }

}
