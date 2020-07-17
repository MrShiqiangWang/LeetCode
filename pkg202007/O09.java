package pkg202007;

import java.util.Stack;

public class O09 {

    class CQueue {

        Stack<Integer> deleteStack;

        Stack<Integer> insertStack;

        public CQueue() {
            this.deleteStack = new Stack<>();
            this.insertStack = new Stack<>();
        }

        public void appendTail(final int value) {
            if (this.insertStack.isEmpty()) {
                while (!this.deleteStack.isEmpty()) {
                    final Integer va = this.deleteStack.pop();
                    this.insertStack.push(va);
                }
            }
            this.insertStack.push(value);
        }

        public int deleteHead() {
            if (this.deleteStack.isEmpty()) {
                while (!this.insertStack.isEmpty()) {
                    final Integer va = this.insertStack.pop();
                    this.deleteStack.push(va);
                }
            }
            return 0;
        }
    }
}
