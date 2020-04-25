package lc_4_21;

/**
 * @author superquanbin@gmail.com
 * @date 2020-04-21 21:36
 */
public class lc_200_numIslands {

    // 先定义两个int型的变量m n，一会儿记录输入的二维矩阵的边长用
    private static int m, n;
    // 定义一个指向数组
    private static int[][] direction = {{0,1},{0,-1},{1,0},{-1,0}};

    // 方法1： DFS
    public static int numIslands(char[][] grid){
        // 判断输入的二维矩阵是否为空
        if(grid == null || grid[0].length == 0)
            return 0;

        m = grid.length;
        n = grid[0].length;
        // 定义一个int型的变量islandsNum记录有多少个岛屿
        int islandsNum = 0;
        // 两层for循环从左上角开始遍历矩阵
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                // 如果遍历到当前的元素不是字符'0'，那么就看一下它有多少连通的岛屿
                if(grid[i][j] != '0'){
                    dfs(grid, i, j);
                    islandsNum++; // 岛屿数量加加
                }
            }
        }
        return islandsNum;
    }

    private static void dfs(char[][] grid, int i, int j){
        if(i < 0 || i >= m || j < 0 || j >= n || grid[i][j] == '0'){
            return;
        }
        // 将遍历过的岛屿设为字符'0'
        grid[i][j] = '0';
        // 这里只要判断当前元素的上下左右有没有连通的岛屿，有的话，会去把连通的岛屿设为'0'
        for(int[] d : direction){
            dfs(grid, i + d[0], j + d[1]);
        }
    }
}
