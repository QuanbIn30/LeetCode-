package lc_5_4;

import java.util.Scanner;

/**
 * 正数拆分
 * @author superquanbin@gmail.com
 * @date 2020-05-04 10:32
 */
public class lc_343_integerBreak {

    // 方法1：暴力递归
    public int integerBreak1(int n){
        if(n == 2){
            return 1;
        }
        int res = -1;
        for(int i = 1; i < n - 1; i++){
            res = Math.max(res, Math.max((i * (n - i)), i * integerBreak1(n - i)));
        }
        return res;
    }

    // 方法2：备忘录算法
    int[] memo;
    public int integerBreak2(int n){
        memo = new int[n + 1];
        return integerBreakHelper(n);
    }
    public int integerBreakHelper(int n){
        if(n == 2)
            return 1;
        if(memo[n] != 0){
            return memo[n];
        }
        int res = -1;
        for(int i = 1; i <= n - 1; i++){
            res = Math.max(res, Math.max(i * (n - i), i * integerBreakHelper(n - i)));
        }
        memo[n] = res;
        return res;
    }

    // 方法3：动态规划，
    // 其实方法2已经满足题目要求，但是对于这样一个递归的过程，我们更习惯转化为递推，
    // 将自顶向下的思路转化为自底向上，这也是DP和备忘录算法的区别所在
    int[] memory;
    public int integerBreak3(int n){
        memory = new int[n + 1];
        memory[2] = 1;
        for(int i = 3; i <= n; i++){
            for(int j = 1; j <= i - 1; j++){
                memory[i] = Math.max(memory[i], Math.max(j * memory[i - j], j * (i - j)));
            }
        }
        return memory[n];
    }

    public static void main(String[] args) {
        lc_343_integerBreak tc = new lc_343_integerBreak();
        Scanner sc = new Scanner(System.in);
        System.out.println("please input a number as n~");
        int n = sc.nextInt();
//        int res = tc.integerBreak1(n);
//        int res = tc.integerBreak2(n);
        int res = tc.integerBreak3(n);
        System.out.println(res);
    }
}
