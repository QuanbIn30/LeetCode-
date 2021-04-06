package lc_20_05.lc_5_5;

import java.util.Scanner;

/**
 * @author superquanbin@gmail.com
 * @date 2020-05-05 11:08
 */
public class lc_504_convertToBase7 {

    public String convertToBase7(int num){
        // 国际惯例，先判断输入的欺骗性
        if (num == 0) {
            return "0";
        }
        // 然后定义一个变量用来存放结果集
        StringBuilder sb = new StringBuilder();
        // 判断输入的数是不是负数
        boolean isNegative = num < 0;
        // 如果输入的是负数的话，需要先转成正数，处理完成之后输出的时候在把负号添加上去
        if (isNegative) {
            num = -num;
        }
        // 这个算法主要计算重点就在这，前面都是预处理
        while (num > 0) {
            sb.append(num % 7);
            num /= 7;
        }
        String ret = sb.reverse().toString();
        // 最后返回的时候要先判断一下输入的是不是负数，是的话记得要把负号添加回去
        return isNegative ? "-" + ret : ret;
    }

    public static void main(String[] args) {
        lc_504_convertToBase7 tc = new lc_504_convertToBase7();
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        String res = tc.convertToBase7(num);
        System.out.println(res);
    }
}
