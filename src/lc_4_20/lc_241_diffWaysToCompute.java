package lc_4_20;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * 给表达式加括号
 * @author superquanbin@gmail.com
 * @date 2020-04-20 11:53
 */
public class lc_241_diffWaysToCompute {

    // 方法1：递归
    public static List<Integer> diffWaysToCompute1(String input){

        // 定义一个存放Integer类型数据的链表
        List<Integer> ways = new ArrayList<>();

        // 遍历输入的字符串
        for(int i = 0; i < input.length(); i++){
            // 得到当前的字符
            char c = input.charAt(i);
            //
            if(c == '+' || c == '-' || c == '*'){
                List<Integer> left = diffWaysToCompute1(input.substring(0,i));
                List<Integer> right = diffWaysToCompute1(input.substring(i + 1));
                for(int l : left){
                    for(int r : right){
                        switch (c){
                            case '+':
                                ways.add(l + r);
                                break;
                            case '-':
                                ways.add(l - r);
                                break;
                            case '*':
                                ways.add(l * r);
                                break;
                        }
                    }
                }
            }
        }
        if(ways.size() == 0){
            ways.add(Integer.valueOf(input));
        }
        return ways;
    }

    // 方法2：（其实还是递归，只是代码不一样）
    public static List<Integer> diffWaysToCompute2(String input){

        // 判断输入的字符串是否为空
        if(input.length() == 0)
            return new ArrayList<>();

        // 定义一个存放Integer类型数据的链表
        List<Integer> result = new ArrayList<>();
        int num = 0;

        // 考虑全是数字的情况
        int index = 0;
        while(index < input.length() && !isOperation(input.charAt(index))){
            num = num * 10 + input.charAt(index) - '0';
            index++;
        }

        // 将全是数字的情况直接返回
        if(index == input.length()){
            result.add(num);
            return result;
        }

        // 如果输入的字符串不是全是数字的话，这两个递归可以把输入的字符串拆开揉碎去把每一种情况遍历到
        for(int i = 0; i < input.length(); i++){
            // 通过运算符将字符串分成两部分
            if(isOperation(input.charAt(i))){
                List<Integer> result1 = diffWaysToCompute2(input.substring(0, i));
                List<Integer> result2 = diffWaysToCompute2(input.substring(i + 1));
                // 将两个结果依次运算
                for(int j = 0; j < result1.size(); j++){
                    for(int k = 0; k < result2.size(); k++){
                        char op = input.charAt(i);
                        result.add(caculate(result1.get(j), op, result2.get(k)));
                    }
                }
            }
        }
        return result;
    }

    private static int caculate(int num1, char c, int num2){
        switch(c){
            case '+':
                return num1 + num2;
            case '-':
                return num1 - num2;
            case '*':
                return num1 * num2;
        }
        return -1;
    }

    private static boolean isOperation(char c){
        return c == '+' || c == '-' || c == '*';
    }

    public static void main(String[] args) {
        System.out.println("please input a string~");
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        List<Integer> res = diffWaysToCompute2(str);
        System.out.println(res);
    }
}
