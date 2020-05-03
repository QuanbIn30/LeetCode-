package lc_5_1;

/**
 * @author superquanbin@gmail.com
 * @date 2020-05-01 22:14
 */
public class lc_64_minPathSum {

    // method1
    public int minPathSum1(int[][] grid){
        // 直接上来就是两层循环打算把矩阵逐行都从左到右遍历一遍
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if(i == 0 && j == 0){
                    continue;
                }
                if(i == 0){
                    grid[i][j] = grid[i][j - 1] + grid[i][j];
                }
                if(j == 0){
                    grid[i][j] = grid[i - 1][j] + grid[i][j];
                }
                if(i != 0 && j != 0){
                    grid[i][j] = Math.min(grid[i - 1][j] + grid[i][j],
                                          grid[i][j - 1] + grid[i][j]);
                }
            }
        }
        return grid[grid.length - 1][grid[0].length - 1];
    }

    // method2
    public int minPathSum2(int[][] grid){
        int[][] dp = new int[grid.length][grid[0].length];
        for (int i = grid.length - 1; i >= 0; i--) {
            for(int j = grid[0].length - 1; j >= 0; j--){
                if(i == grid.length - 1 && j != grid[0].length - 1){
                    dp[i][j] = grid[i][j] + dp[i][j + 1];
                }
                else if(j == grid[0].length - 1 && i != grid.length - 1){
                    dp[i][j] = grid[i][j] + dp[i + 1][j];
                }
                else if(i != grid.length - 1 && j != grid[0].length - 1){
                    dp[i][j] = grid[i][j] + Math.min(dp[i + 1][j], dp[i][j + 1]);
                }
                else {
                    dp[i][j] = grid[i][j];
                }
            }
        }
        return dp[0][0];
    }

    public static void main(String[] args) {
        lc_64_minPathSum tc = new lc_64_minPathSum();
        int[][] patharr = new int[][]{{3,1,4,8},{3,2,2,4},{5,7,1,9},{2,3,2,3}};
//        int res = tc.minPathSum1(patharr);
        int res = tc.minPathSum2(patharr);
        System.out.println(res);
    }
}
