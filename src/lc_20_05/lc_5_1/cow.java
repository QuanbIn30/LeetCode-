package lc_20_05.lc_5_1;

import java.util.Scanner;

/**
 * 母牛生产问题
 * 题意：假设农场中成熟的母牛每年都会生 1 头小母牛，并且永远不会死。
 * 第一年有 1 只成熟母牛（可以生产），从第二年开始，成熟母牛开始生小母牛。
 * 每只小母牛 3 年之后成熟又可以生小母牛。给定整数 n，求 n 年后牛的数量。
 * @author superquanbin@gmail.com
 * @date 2020-05-01 21:15
 */
public class cow {
    public int cow(int n){
        // 首先判断一下输入的欺骗性
        if(n < 0)
            return 0;
        // 然后前三年里都只有原本那一头成熟母牛进行生产
        // 所以判断如果输入年份属于前三年的话，直接输出固定得数就行，因为前三年的生产都是递增加1的
        if(n == 1 || n == 2 || n == 3)
            return n;
        // 然后定义一个备忘录数组用来记录过去年份在当年分别都有几头牛
        int[] dp = new int[n + 1];
        // 要在备忘录数组中记录好已经确定的前三年年份的牛的数量，dp[0]表示第0年，不算
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 3;
        for(int i = 4; i <= n; i++){
            dp[i] = dp[i - 1] + dp[i - 3];
        }
        return dp[n];
    }

    public static void main(String[] args) {
        cow tc = new cow();
        Scanner sc = new Scanner(System.in);
        System.out.println("please input n~");
        int input = sc.nextInt();
        int res = tc.cow(input);
        System.out.println(res);
    }
}
