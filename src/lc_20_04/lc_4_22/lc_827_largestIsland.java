package lc_20_04.lc_4_22;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 填海造陆
 * 题意：在二维地图上， 0代表海洋， 1代表陆地，我们最多只能将一格 0 海洋变成 1变成陆地。
 *      进行填海之后，地图上最大的岛屿面积是多少？（上、下、左、右四个方向相连的 1 可形成岛屿）
 * @author superquanbin@gmail.com
 * @date 2020-04-22 09:19
 */
public class lc_827_largestIsland {

    int[] dr = new int[]{-1,0,1,0};
    int[] dc = new int[]{0,-1,0,1};
    int[][] grid;
    int N;

    // 方法1：
    // 思路：对于每个连通块，将所有格子赋值为index，并记录他们的大小 area[index] = dfs(...)
    //      然后对于每个0，查看周围的邻居编号在seen并将这个区域的大小加入结果，改变seen的值，这就是当前节点的面积大小
    //      在其中找到最大的
    public int largestIsland(int[][] grid){

        this.grid = grid;
        N = grid.length;

        int index = 2; // 因为原本的岛屿标记是1，如果要区分标记每块岛屿，索引就要从2开始
        int[] area = new int[N * N + 2];

        for(int r = 0; r < N; ++r){
            for (int c = 0; c < N; ++c) {
                if(grid[r][c] == 1){
                    // area[index]的作用是记录索引为index的区域的面积
                    // dfs(r,c,index++)的作用是找出相连的陆地，并且将这块相连的陆地的索引标记为index
                    area[index] = dfs(r, c, index++);
                }
            }
        }

        // 定义一个变量ans来记录最大的岛屿面积
        int ans = 0;
        // 这个for循环遍历得到area数组中记录的最大的岛屿面积
        for(int x : area) {
            ans = Math.max(ans, x);
        }
        // 这个for循环是在遍历海洋
        for(int r = 0; r < N; ++r){
            for (int c = 0; c < N; ++c){
                // 判断当前块是不是海洋，等于0是海洋，否则不是
                if(grid[r][c] == 0){
                    // 当前块是海洋的话就定义一个Set集合
                    Set<Integer> seen = new HashSet();
                    // 遍历当前块相邻的上下左右块
                    for(Integer move : neighbors(r, c)){
                        // 判断有没有相邻块的索引大于1
                        if(grid[move / N][move % N] > 1){
                            // 有的话就把那一块的索引添加进集合
                            seen.add(grid[move / N][move % N]);
                        }
                    }
                    int bns = 1;
                    // 遍历集合得到相邻岛屿加起来的面积
                    for(int i : seen){
                        bns += area[i];
                    }
                    // 比较得到当前最大的岛屿面积
                    ans = Math.max(ans, bns);
                }
            }
        }
        return ans;
    }

    public int dfs(int r, int c, int index){
        int ans = 1;
        grid[r][c] = index;
        for(Integer move : neighbors(r, c)){
            if(grid[move / N][move % N] == 1){
               grid[move / N][move % N] = index;
               ans += dfs(move / N, move % N, index);
            }
        }
        return ans;
    }

    // 这个neighbor(int r, int c)方法的作用就是将格子grid[r,c]的上下左右没有越界的点都添加进一个链表ans中
    // 所以排除与grid[r,c]相邻的越界的点，这个ans链表最多就4个元素
    public List<Integer> neighbors(int r, int c){
        List<Integer> ans = new ArrayList<>();
        for(int k = 0; k < 4; ++k){
            int nr = r + dr[k];
            int nc = c + dc[k];
            if(0 <= nr && nr < N && 0 <= nc && nc < N){
                ans.add(nr * N + nc);
            }
        }
        return ans;
    }
}
