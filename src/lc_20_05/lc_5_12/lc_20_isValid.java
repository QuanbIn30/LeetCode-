package lc_20_05.lc_5_12;

import java.util.Stack;

/**
 * 用栈实现括号匹配
 * @author superquanbin@gmail.com
 * @date 2020-05-12 09:10
 */
public class lc_20_isValid {

    public boolean isValid(String s){
        // 定义一个栈用来存放s中的字符元素
        Stack<Character> stack = new Stack<>();
        // 将s转换字符数组，然后挨个遍历
        // 如果是左括号则直接入栈，如果是右括号则进入else代码块
        for(char c : s.toCharArray()){
            if(c == '(' || c == '[' || c == '{'){
                stack.push(c);
            }else{
                if(stack.isEmpty()){
                    return false;
                }
                char cStack = stack.pop();
                // 先把有不符合的先记录下来，然后等下那个if判断中直接返回false
                boolean b1 = c == ')' && cStack != '(';
                boolean b2 = c == ']' && cStack != '[';
                boolean b3 = c == '}' && cStack != '{';
                if(b1 || b2 || b3){
                    return false;
                }
            }
        }
        // 注意：最后栈中不能留有元素
        return stack.isEmpty();
    }
}
