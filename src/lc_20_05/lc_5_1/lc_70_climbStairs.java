package lc_20_05.lc_5_1;

/**
 * 爬楼梯
 * @author superquanbin@gmail.com
 * @date 2020-05-01 10:07
 */
public class lc_70_climbStairs {

    // method one
    public int climbStairs1(int n){
        if(n <= 2){
            return n;
        }
        int pre2 = 1;
        int pre1 = 2;
        for(int i = 2; i < n; i++){
            int cur = pre2 + pre1;
            pre2 = pre1;
            pre1 = cur;
        }
        return pre1;
    }

    // method tow -- 动态规划
    public int climbStairs2(int n){
        if(n == 1){
            return 1;
        }
        int[] dp = new int[n + 1];
        dp[1] = 1;
        dp[2] = 2;
        for(int i = 3; i <= n; i++){
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }

    // method three -- 斐波那契数
    public int climbStairs3(int n){
        if(n == 1){
            return 1;
        }
        int first = 1;
        int second = 2;
        for(int i = 3; i <= n; i++){
            int third = first + second;
            first = second;
            second = third;
        }
        return second;
    }

    public static void main(String[] args) {
        lc_70_climbStairs tc = new lc_70_climbStairs();
        int n = 10;
        int res = tc.climbStairs1(n);
        System.out.println(res);
    }
}
