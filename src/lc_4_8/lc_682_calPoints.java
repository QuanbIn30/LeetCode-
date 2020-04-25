package lc_4_8;

import java.util.Stack;

/**
 *
 * 棒球比赛
 * @author superquanbin@gmail.com
 * @date 2020-04-08 12:31
 */
public class lc_682_calPoints {

    public static int calPoints1(String[] ops){

        Stack<Integer> stack = new Stack<>();

        for(String op : ops){
            if (op.equals("+")){
                int top = stack.pop();
                int newTop = top + stack.peek();
                stack.push(top);
                stack.push(newTop);
            }else if (op.equals("C")){
                stack.pop();
            }else if (op.equals("D")){
                stack.push(2 * stack.peek());
            }else {
                stack.push(Integer.valueOf(op));
            }
        }

        int ans = 0;
        for (int score : stack)
            ans += score;
        return ans;
    }

    public static int calPoints2(String[] ops){
        int sum = 0;
        Stack<String> stack = new Stack<>();
        for(int i = 0; i < ops.length; i++){
            switch (ops[i]){
                case "C":
                    sum -= Integer.parseInt(stack.pop());
                    break;
                case "D":
                    sum += 2*Integer.parseInt(stack.peek());
                    stack.push(String.valueOf(2 * Integer.parseInt(stack.peek())));
                    break;
                case "+":
                    sum += (Integer.parseInt(stack.elementAt(stack.size() - 1))
                            + Integer.parseInt(stack.elementAt(stack.size() - 2)));
                    stack.push(String.valueOf(Integer.parseInt(stack.elementAt(stack.size() - 1))
                            + Integer.parseInt(stack.elementAt(stack.size() - 2))));
                    break;
                default:
                    stack.push(ops[i]);
                    sum += Integer.parseInt(ops[i]);
                    break;
            }
        }
        return sum;
    }
}
