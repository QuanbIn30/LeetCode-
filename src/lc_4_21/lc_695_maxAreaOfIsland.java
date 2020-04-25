package lc_4_21;

/**
 * @author superquanbin@gmail.com
 * @date 2020-04-21 18:32
 */
public class lc_695_maxAreaOfIsland {

    private static int m, n;
    private static int[][] direction = {{0,1},{0,-1},{1,0},{-1,0}};

    // 解法1：DFS
    // 此题用到沉岛思想（就是把每次找到的岛屿设为0，这就是传说中的沉岛思想），可以解决任何此类问题
    public static int maxAreaOfIsland(int[][] grid){
        if(grid == null || grid.length == 0){
            return 0;
        }
        m = grid.length;
        n = grid[0].length;
        int maxArea = 0;
        for(int i = 0; i < m; i++){
            for (int j = 0; j < n; j++){
                maxArea = Math.max(maxArea, dfs(grid,i,j));
            }
        }
        return maxArea;
    }

    private static int dfs(int[][] grid, int r, int c){
        if(r < 0 || r >= m || c < 0 || c >= n || grid[r][c] == 0){
            return 0;
        }
        grid[r][c] = 0;
        int area = 1;
        for(int[] d : direction){
            area += dfs(grid, r + d[0], c + d[1]);
        }
        return area;
    }

    // 解法2：其实还是DFS，优化了一下dfs()方法，在探索某个岛的上下左右是不是也是岛的时候与方法1不太一样
    private static int dfs2(int[][] grid, int r, int c){
        if(r < 0 || r >= m || c < 0 || c >= n || grid[r][c] == 0){
            return 0;
        }
        grid[r][c] = 0;
        int area = 1;
        area += dfs(grid, r + 1, c);
        area += dfs(grid, r - 1, c);
        area += dfs(grid, r, c + 1);
        area += dfs(grid, r, c - 1);
        return area;
    }

    public static void main(String[] args) {
        int[][] testArr = new int[][]{{0,0,1,0,0,0,0,1,0,0,0,0,0},
                                    {0,0,0,0,0,0,0,1,1,1,0,0,0},
                                    {0,1,1,0,1,0,0,0,0,0,0,0,0},
                                    {0,1,0,0,1,1,0,0,1,0,1,0,0},
                                    {0,1,0,0,1,1,0,0,1,1,1,0,0},
                                    {0,0,0,0,0,0,0,0,0,0,1,0,0},
                                    {0,0,0,0,0,0,0,1,1,1,0,0,0},
                                    {0,0,0,0,0,0,0,1,1,0,0,0,0}};
        int res = maxAreaOfIsland(testArr);
        System.out.println(res);
    }
}
