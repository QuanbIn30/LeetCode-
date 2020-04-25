package lc_4_8;

import java.util.Scanner;
import java.util.Stack;

/**
 *
 * 删除最外层的括号
 * @author superquanbin@gmail.com
 * @date 2020-04-08 09:01
 */
public class lc_1021_RemoveOuterParentheses {

    public static String removeOuterParentheses1(String S) {

        StringBuilder sb = new StringBuilder();
        int level = 0;
        for (char c : S.toCharArray()){
            if (c == ')') --level;
            if (level >= 1) sb.append(c);
            if (c == '(') ++level;
        }
        return sb.toString();
    }

    public static String removeOuterParentheses2(String S){

        StringBuilder ans = new StringBuilder();
        Stack<Character> stack = new Stack<>();

        int start = 0;
        int end = 0;
        boolean flag = false;

        for (int i = 0; i < S.length(); i++){
            char ch = S.charAt(i);
            if (ch == '('){
                stack.push(ch);
                if (!flag){
                    start = i;
                    flag = true;
                }
            }

            if (ch == ')'){
                stack.pop();
                if (stack.isEmpty()){
                    end = i;
                    ans.append(S.substring(start + 1, end));
                    flag = false;
                }
            }
        }
        return ans.toString();
    }

    public static void main(String[] args) {
        Scanner scString = new Scanner(System.in);
        String str = scString.nextLine();
        String ans = removeOuterParentheses2(str);
        System.out.println(ans);
    }
}
