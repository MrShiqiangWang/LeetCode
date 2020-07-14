package pkg202007;

import java.util.Stack;

public class O09 {
	class CQueue {

		Stack<Integer> deleteStack;

		Stack<Integer> insertStack;

		public CQueue() {
			deleteStack = new Stack<>();
			insertStack = new Stack<>();
		}

		public void appendTail(int value) {
			if (insertStack.isEmpty()) {
				while (!deleteStack.isEmpty()) {
					Integer va = deleteStack.pop();
					insertStack.push(va);
				}
			}
			insertStack.push(value);
		}

		public int deleteHead() {
			if(deleteStack.isEmpty()) {
				while(!insertStack.isEmpty()) {
					Integer va = insertStack.pop();
					deleteStack.push(va);
				}
			}
			return 0;
		}
	}
}
