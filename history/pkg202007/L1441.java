package history.pkg202007;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import utils.ArrayHelper;

public class L1441 {

    public static void main(final String[] args) {
        System.out.println(new L1441().buildArray(ArrayHelper.stringToArray("[1,3]"), 3));
    }

    public List<String> buildArray(final int[] target, final int n) {
        final Stack<Integer> stack = new Stack<>();
        for (int i = target.length - 1; i >= 0; i--) {
            stack.push(target[i]);
        }

        final List<String> result = new ArrayList<String>();
        for (int i = 1; i <= n; i++) {
            if (stack.isEmpty()) {
                return result;
            }
            final int top = stack.peek();
            if (top == i) {
                result.add("Push");
                stack.pop();
            }
            else {
                result.add("Push");
                result.add("Pop");
            }
        }
        if (stack.isEmpty()) {
            return result;
        }
        return new ArrayList<>();
    }
}
