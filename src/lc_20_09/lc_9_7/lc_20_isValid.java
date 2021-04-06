package lc_20_09.lc_9_7;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * 有效的括号
 * @author superquanbin@gmail.com
 * @date 2020-09-07 19:49
 */
public class lc_20_isValid {


    // 方法1
    private static final Map<Character, Character> map = new HashMap<Character,Character>(){
        {put('{','}'); put('[',']'); put('(',')'); put('?','?');}
    };

    public boolean isValid(String s){
        if(s.length() > 0 && !map.containsKey(s.charAt(0)))
            return false;
        Stack<Character> stack = new Stack<Character>(){{ add('?');}};
        for(Character c : s.toCharArray()){
            if(map.containsKey(c))
                stack.push(c);
            else if (map.get(stack.pop()) != c)
                return false;
        }
        return stack.size() == 1;
    }

    // 方法2
    public static boolean isValid2(String s){
        if(s.isEmpty())
            return true;
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()){
            if(c == '(')
                stack.push(')');
            else if(c == '[')
                stack.push(']');
            else if(c == '{')
                stack.push('}');
            else if (stack.isEmpty() || c != stack.pop())
                return false;
        }

        return stack.isEmpty();
    }

    public static void main(String[] args) {
        String s = "([{}])";
        boolean res = isValid2(s);
        System.out.println(res);
    }
}
