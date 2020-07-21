package pkg202007;

import java.util.Stack;

public class L482_1 {

    public String licenseKeyFormatting(String S, int K) {
        char[] cs = S.toCharArray();
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < cs.length; i++) {
            if (cs[i] != '-') {
                stack.push(Character.toUpperCase(cs[i]));
            }
        }
        int tik = 0;
        StringBuilder builder = new StringBuilder();
        while (!stack.isEmpty()) {
            if (tik == K) {
                builder.append('-');
                tik=0;
            }
            Character character = stack.pop();
            builder.append(character);
            tik++;
        }
        return builder.reverse().toString();
    }
}
