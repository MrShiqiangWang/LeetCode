package pkg202007;

import java.util.Stack;

public class L155 {

    class MinStack {

        Stack<Integer> stack = new Stack<>();

        Stack<Integer> minStack = new Stack<>();

        /** initialize your data structure here. */
        public MinStack() {
        }

        public int getMin() {
            return this.minStack.peek();
        }

        public void pop() {
            this.stack.pop();
            this.minStack.pop();
        }

        public void push(final int x) {
            this.stack.push(x);
            if (this.minStack.isEmpty()) {
                this.minStack.push(x);
            }
            else {
                final int min = Math.min(this.minStack.peek(), x);
                this.minStack.push(min);
            }
        }

        public int top() {
            return this.stack.peek();
        }
    }
}
