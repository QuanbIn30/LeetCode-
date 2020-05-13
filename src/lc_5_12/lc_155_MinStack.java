package lc_5_12;

import java.util.Stack;

/**
 * @author superquanbin@gmail.com
 * @date 2020-05-12 07:50
 */
public class lc_155_MinStack {

    private Stack<Integer> dataStack;
    private Stack<Integer> minStack;
    private int min;


    /** initialize your data structure here. */
    public lc_155_MinStack() {
        dataStack = new Stack<>();
        minStack = new Stack<>();
        min = Integer.MAX_VALUE;
    }

    public void push(int x) {
        dataStack.push(x);
        min = Math.min(min, x);
        minStack.push(min);
    }

    public void pop() {
        dataStack.pop();
        minStack.pop();
        min = minStack.isEmpty() ? Integer.MAX_VALUE : minStack.peek();
    }

    public int top() {
        return dataStack.peek();
    }

    public int getMin() {
        return minStack.peek();
    }
}
