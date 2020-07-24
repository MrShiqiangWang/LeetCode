package history.pkg202007;

import java.util.Deque;
import java.util.LinkedList;

public class L225 {

    class MyStack {

        Deque<Integer> deque = new LinkedList<>();

        /** Initialize your data structure here. */
        public MyStack() {

        }

        /** Returns whether the stack is empty. */
        public boolean empty() {
            return this.deque.isEmpty();
        }

        /** Removes the element on top of the stack and returns that element. */
        public int pop() {
            return this.deque.pollLast();
        }

        /** Push element x onto stack. */
        public void push(final int x) {
            this.deque.addLast(x);
        }

        /** Get the top element. */
        public int top() {
            return this.deque.peekLast();
        }
    }
}
