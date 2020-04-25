package lc_4_22;

import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;

/**
 * 能到达的大西洋和太平洋的区域
 * @author superquanbin@gmail.com
 * @date 2020-04-22 15:48
 */
public class lc_417_pacificAtlantic {
    private int m, n;
    private int[][] matrix;
    private int[][] direction = {{0,1},{0,-1},{1,0},{-1,0}};

    public List<List<Integer>> pacificAtlantic(int[][] matrix){
        // 定义一个存放结果的链表
        List<List<Integer>> ret = new ArrayList<>();
        // 国际惯例，先判断输入的欺骗性
        if(matrix == null || matrix.length == 0)
            return ret;

        // 给m、n赋值
        m = matrix.length;
        n = matrix[0].length;
        this.matrix = matrix;
        // 新建两个boolean类型的数组矩阵
        boolean[][] canReachP = new boolean[m][n];
        boolean[][] canReachA = new boolean[m][n];

        // for循环遍历矩阵matrix的左右两列
        for (int i = 0; i < m; i++){
            dfs(i,0,canReachP);
            dfs(i,n - 1,canReachA);
        }
        // for循环遍历矩阵matrix的上下两行
        for (int i = 0; i < n; i++){
            dfs(0, i,canReachP);
            dfs(m - 1, i, canReachA);
        }
        // 两层for循环遍历整个矩阵将其中可达性为true的添加进ret
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if(canReachA[i][j] && canReachP[i][j]){
                    ret.add(Arrays.asList(i,j));
                }
            }
        }
        // 返回ret
        return ret;
    }

    // dfs
    private void dfs(int r, int c, boolean[][] canReach){
        // 如果当前格子（暂且叫"格子"吧～）可达性为true则直接返回
        if(canReach[r][c])
            return;
        // 否则将当前格子的可达性设置为true
        canReach[r][c] = true;
        // 然后递归看当前格子相邻的上下左右格子是不是能继续将它的可达性设置为true
        for(int[] d : direction){
            int nextR = d[0] + r;
            int nextC = d[1] = c;
            if(nextR < 0 || nextR >= m || nextC < 0 || nextC >= n
                    || matrix[r][c] > matrix[nextR][nextC]){
                continue;
            }
            dfs(nextR,nextC,canReach);
        }
    }
}
