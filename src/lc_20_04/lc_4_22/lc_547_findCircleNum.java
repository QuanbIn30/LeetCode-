package lc_20_04.lc_4_22;

/**
 * @author superquanbin@gmail.com
 * @date 2020-04-22 12:44
 */
public class lc_547_findCircleNum {
    int n;
    public int findCircleNum(int[][] M){
        n = M.length;
        int circleNum = 0;
        boolean[] visited = new boolean[n];
        for(int i = 0; i < n; i++){
            if(!visited[i]){
                dfs(M, i, visited);
                circleNum++;
            }
        }
        return circleNum;
    }

    private void dfs(int[][] grid, int i, boolean[] visited){
        visited[i] = true;
        for (int j = 0; j < n; j++) {
            if(grid[i][j] == 1 && !visited[j]){
                dfs(grid, j, visited);
            }
        }
    }
}
