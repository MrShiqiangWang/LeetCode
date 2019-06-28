package implementqueueusingstacks;

import java.util.Stack;

public class MyQueue {

    private Stack<Integer> inputStack = new Stack<>();
    private Stack<Integer> outputStack = new Stack<>();

    /** Initialize your data structure here. */
    public MyQueue() {

    }

    /** Push element x to the back of queue. */
    public void push(int x) {
        inputStack.push(x);
    }

    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        while (!inputStack.isEmpty()) {
            Integer integer = inputStack.pop();
            outputStack.push(integer);
        }
        Integer result = outputStack.pop();
        while (!outputStack.isEmpty()) {
            Integer sInteger = outputStack.pop();
            inputStack.push(sInteger);
        }
        return result;

    }

    /** Get the front element. */
    public int peek() {
        while (!inputStack.isEmpty()) {
            Integer integer = inputStack.pop();
            outputStack.push(integer);
        }
        Integer result = outputStack.peek();
        while (!outputStack.isEmpty()) {
            Integer sInteger = outputStack.pop();
            inputStack.push(sInteger);
        }
        return result;

    }

    /** Returns whether the queue is empty. */
    public boolean empty() {
        if (inputStack.isEmpty() && outputStack.isEmpty()) {
            return true;
        }
        return false;
    }
}
