package lc_20_04.lc_4_8;

import java.util.HashSet;
import java.util.Stack;
import java.util.Scanner;

/**
 *
 * 删除字符串中所有的相邻的重复项
 * @author superquanbin@gmail.com
 * @date 2020-04-08 11:31
 */
public class lc_1047_RemoveDuplicates {

    // 利用栈
    public static String removeDuplicates1(String S){

        Stack<Character> stack = new Stack<>();
        Stack<Character> help = new Stack<>();
        for (char c : S.toCharArray()){
            if (stack.isEmpty()){
                stack.push(c);
            }else if (c == (char)stack.peek()){
                stack.pop();
            }else{
                stack.push(c);
            }
        }
        while(!stack.isEmpty()) {
            help.push(stack.pop());
        }
        StringBuilder ans = new StringBuilder();
        while(!help.isEmpty()){
            ans.append(help.pop());
        }
        return ans.toString();
    }

    // 这是用到了String字符串自带的replace()函数，
    // 先用StringBuilder构造26个类似于"aa","bb","cc","dd"...的字符串
    // 然后放进HashSet中并且遍历这个哈希集合并且用replace(d,"");
    // 来将当前字符串S中的重复字符串替换成空串，因为替换之后可能会产生新的空串
    // 所以要遍历多次，用变量len与S的长度S.length()来判断上一次遍历中字符串长度有没有发生变化
    // 没有的话说明当前字符串已经没有相邻的重复字符串了，这时就可退出返回结果了
    public static String removeDuplicates2(String S){

        HashSet<String> duplicates = new HashSet<>();
        StringBuilder sb = new StringBuilder();

        for (char i = 'a'; i <= 'z'; i++){
            sb.setLength(0);
            sb.append(i);
            sb.append(i);
            duplicates.add(sb.toString());
        }

        int prevlength = -1;
        while(prevlength != S.length()){
            prevlength = S.length();
            for (String d : duplicates){
                S = S.replace(d,"");
            }
        }
        return S;
    }

    // 这种方法是到了StringBuilder
    // 将字符串S转成字符数组，
    // 定义一个变量len来判断当前StringBuilder类型的变量sb中是否有元素
    // 如果sb中有元素的话，先对比当前索引处的字符数组的元素是否与sb的最后一个元素一样
    // 一样的话则直接删除sb中最后一个元素，并且维护变量len
    // 否则的话直接把当前索引处的字符数组中的元素往sb中添加就行
    public static String removeDuplicates3(String S){
        StringBuilder sb = new StringBuilder();
        int len = 0;
        for (char character : S.toCharArray()){

            if (len != 0 && character == sb.charAt(len - 1)){
                sb.deleteCharAt(len-- - 1);
            }else{
                sb.append(character);
                len++;
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String sss = sc.nextLine();
        String res = removeDuplicates1(sss);
        System.out.println(res);
    }
}
