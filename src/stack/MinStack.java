// https://leetcode.com/problems/min-stack/

package stack;

import java.util.Stack;

public class MinStack {

    private int min;

    private Stack<Integer> stack;

    private Stack<Integer> minStack;

    /** initialize your data structure here. */
    public MinStack() {
        min = Integer.MAX_VALUE;
        stack = new Stack<>();
        minStack = new Stack<>();
    }

    public void push(int x) {
        stack.push(x);
        minStack.push(min);
        min = Math.min(min, x);
    }

    public void pop() {
        stack.pop();
        min = minStack.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return min;
    }

    public static void main(String[] args) {
        MinStack minStack = new MinStack();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
        System.out.println(minStack.getMin()); // return -3
        minStack.pop();
        System.out.println(minStack.top()); // return 0
        System.out.println(minStack.getMin()); // return -2
    }
}
