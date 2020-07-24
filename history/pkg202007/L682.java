package history.pkg202007;

import java.util.Stack;

public class L682 {

    public int calPoints(final String[] ops) {
        final Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < ops.length; i++) {
            if (ops[i].equals("+")) {
                stack.push(stack.peek() + stack.get(stack.size() - 2));
            }
            else if (ops[i].equals("C")) {
                stack.pop();
            }
            else if (ops[i].equals("D")) {
                stack.push(stack.peek() * 2);
            }
            else {
                stack.push(Integer.parseInt(ops[i]));
            }
        }

        int sum = 0;
        while (!stack.isEmpty()) {
            sum += stack.pop();
        }
        return sum;

    }
}
