package lc_5_11;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 用队列实现栈
 * @author superquanbin@gmail.com
 * @date 2020-05-11 21:23
 */
public class lc_225_MyStack {

    private Queue<Integer> queue;

    /** Initialize your data structure here. */
    public lc_225_MyStack() {
        queue = new LinkedList<>();
    }

    /** Push element x onto stack. */
    public void push(int x) {
        queue.add(x);
        int cnt = queue.size();
        while(cnt-- > 0){
            queue.add(queue.poll());
        }
    }

    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        return queue.poll();
    }

    /** Get the top element. */
    public int top() {
        return queue.peek();
    }

    /** Returns whether the stack is empty. */
    public boolean empty() {
        return queue.isEmpty();
    }
}
