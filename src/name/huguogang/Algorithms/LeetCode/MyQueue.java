package name.huguogang.Algorithms.LeetCode;

import java.util.Stack;

class MyQueue {
	private Stack<Integer> inputStack = new Stack<>();
	private Stack<Integer> outputStack = new Stack<>();

	// Push element x to the back of queue.
	public void push(int x) {
		inputStack.push(x);
	}

	// Removes the element from in front of queue.
	public void pop() {
		ensureOutputStack();
		outputStack.pop();
	}

	// Get the front element.
	public int peek() {
		ensureOutputStack();
		return outputStack.peek();
	}

	// Return whether the queue is empty.
	public boolean empty() {
		ensureOutputStack();
		return outputStack.empty();
	}

	private void ensureOutputStack() {
		if (outputStack.empty()) {
			while (!inputStack.empty()) {
				outputStack.push(inputStack.pop());
			}
		}
	}
}