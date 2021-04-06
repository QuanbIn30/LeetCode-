package lc_20_09.lc_9_7;

import java.util.Stack;

/**
 * @author superquanbin@gmail.com
 * @date 2020-09-07 20:45
 */
public class lc_155_MinStack {

    private Stack<Integer> stack;
    private Stack<Integer> minStack;

    public lc_155_MinStack(){
        stack = new Stack<>();
        minStack = new Stack<>();
    }

    public void push(int x){
        stack.push(x);
        if (!minStack.isEmpty()){
            int top = minStack.peek();
            if(x < top)
                minStack.push(x);
        } else {
           minStack.push(x);
        }
    }

    public void pop(){
        int pop = stack.pop();
        int top = minStack.peek();
        if(pop == top)
            minStack.pop();
    }

    public int top(){
        return stack.peek();
    }

    public int getMin(){
        return minStack.peek();
    }
}
