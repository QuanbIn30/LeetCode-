package lc_5_2;

/**
 * @author superquanbin@gmail.com
 * @date 2020-05-02 08:36
 */
public class lc_62_uniquePaths {
    public int uniquePaths(int m, int n){
        int[][] dp = new int[m][n];
        for (int i = 0; i < n; i++) {
            dp[0][i] = 1;
        }
        for (int i = 0; i < m; i++) {
            dp[i][0] = 1;
        }
        // 注意下面这两层循环要从索引1开始，因为前两个for循环已经把数组索引0的位置都填满了
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }
        return dp[m - 1][n - 1];
    }

    public static void main(String[] args) {
        lc_62_uniquePaths tc = new lc_62_uniquePaths();
        int m = 3;
        int n = 2;
        int res = tc.uniquePaths(m, n);
        System.out.println(res);
    }
}
