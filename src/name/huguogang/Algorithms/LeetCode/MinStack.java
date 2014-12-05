package name.huguogang.Algorithms.LeetCode;

import java.util.Stack;

/**
 * Design a stack that supports push, pop, top, and retrieving the minimum
 * element in constant time.
 *
 * push(x) -- Push element x onto stack.
 * pop() -- Removes the element on top of the stack.
 * top() -- Get the top element.
 * getMin() -- Retrieve the minimum element in the stack.
 * 
 * @author ghu
 *
 */
public 
class MinStack {
    private Stack<Integer> mainStack = new Stack<Integer>();
    private Stack<Integer> minStack = new Stack<Integer>();

    public void push(int x) {
        if(minStack.isEmpty() || x <= minStack.peek()) {
            minStack.push(x);
        }
        mainStack.push(x);
    }

    public void pop() {
        if(mainStack.isEmpty()) {
            return; //no op
        }
        int top = mainStack.pop();
        if(top == minStack.peek()) {
            minStack.pop();
        }
    }

    public int top() {
        return mainStack.peek();
    }

    public int getMin() {
        return minStack.peek();
    }
}