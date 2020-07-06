package history.pkg201906;

import java.util.Stack;

public class MyQueue {

    private final Stack<Integer> inputStack = new Stack<>();
    private final Stack<Integer> outputStack = new Stack<>();

    /** Initialize your data structure here. */
    public MyQueue() {

    }

    /** Returns whether the queue is empty. */
    public boolean empty() {
        if (this.inputStack.isEmpty() && this.outputStack.isEmpty()) {
            return true;
        }
        return false;
    }

    /** Get the front element. */
    public int peek() {
        while (!this.inputStack.isEmpty()) {
            final Integer integer = this.inputStack.pop();
            this.outputStack.push(integer);
        }
        final Integer result = this.outputStack.peek();
        while (!this.outputStack.isEmpty()) {
            final Integer sInteger = this.outputStack.pop();
            this.inputStack.push(sInteger);
        }
        return result;

    }

    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        while (!this.inputStack.isEmpty()) {
            final Integer integer = this.inputStack.pop();
            this.outputStack.push(integer);
        }
        final Integer result = this.outputStack.pop();
        while (!this.outputStack.isEmpty()) {
            final Integer sInteger = this.outputStack.pop();
            this.inputStack.push(sInteger);
        }
        return result;

    }

    /** Push element x to the back of queue. */
    public void push(final int x) {
        this.inputStack.push(x);
    }
}
