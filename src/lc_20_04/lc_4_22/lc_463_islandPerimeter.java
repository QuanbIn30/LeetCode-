package lc_20_04.lc_4_22;

/**
 * @author superquanbin@gmail.com
 * @date 2020-04-22 11:46
 */
public class lc_463_islandPerimeter {

    int m, n;

    public int islandPerimeter(int[][] grid){
        m = grid.length;
        n = grid[0].length;
        // 判断base case
        if(grid == null || grid.length == 0){
            return 0;
        }
        // for循环遍历
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if(grid[i][j] == 1){
                    return dfs(grid, i, j);
                }
            }
        }
        return 0;
    }

    // dfs
    private int dfs(int[][] grid, int i, int j){
        // 函数因为"坐标越界"而返回，对应一条边
        if(!inArea(grid, i, j)){
            return 1;
        }

        // 函数因为"走到了海洋格子"而返回，对应一条边
        if(grid[i][j] == 0){
            return 1;
        }

        // 函数因为"走到的陆地是走过的"而返回，与周长没有关系
        if(grid[i][j] != 1){
            return 0;
        }

        grid[i][j] = 2;
        return dfs(grid, i + 1, j)
                + dfs(grid,i - 1,j)
                + dfs(grid,i, j + 1)
                + dfs(grid,i, j - 1);
    }

    // 判断当前格子是否在网格中
    private boolean inArea(int[][] grid,int r, int c){
        return 0 <= r && r < m && 0 <= c && c < n;
    }
}
