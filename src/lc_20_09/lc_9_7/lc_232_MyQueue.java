package lc_20_09.lc_9_7;

import java.util.Stack;

/**
 * 用栈实现队列
 * @author MHLEVEL
 * @date 2020-09-07 21:31
 */
public class lc_232_MyQueue {

    Stack<Integer> stack;
    Stack<Integer> helpStack;

    public lc_232_MyQueue(){
        stack = new Stack<>();
        helpStack = new Stack<>();
    }

    /** Push element x to the back of queue. */
    public void push(int x) {
        stack.push(x);
    }

    /** Removes the element from in front of queue and returns that element. */
    public int pop() {

        if (stack.isEmpty())
            return 0;

        swap(stack, helpStack);

        int pop =  helpStack.pop();

        swap(helpStack, stack);

        return pop;
    }

    private void swap(Stack a, Stack b){
        int size = a.size();
        for (int i = 0; i < size; i++)
            b.push(a.pop());
    }

    /** Get the front element. */
    public int peek() {
        if (stack.isEmpty())
            return 0;

        swap(stack, helpStack);

        int peek =  helpStack.peek();

        swap(helpStack, stack);

        return peek;
    }

    /** Returns whether the queue is empty. */
    public boolean empty() {
        return stack.isEmpty() && helpStack.isEmpty();
    }

    public static void main(String[] args) {
        lc_232_MyQueue queue = new lc_232_MyQueue();
        queue.push(1);
        queue.push(2);
        int a = queue.peek();
        System.out.println(a);
    }
}
