package lc_20_04.lc_4_20;

import javafx.util.Pair;

import java.util.Queue;
import java.util.LinkedList;

/**
 * 计算在网格中从原点到特定点的最短路径长度
 * @author superquanbin@gmail.com
 * @date 2020-04-20 19:40
 */
public class lc_1091_shortestPathBinaryMatrix {

    // 方法1：BFS
    public static int shortestPathBinaryMatrix1 (int[][] grid){
        if(grid == null || grid.length == 0 || grid[0].length == 0){
            return -1;
        }

        // 定义一个二维数组
        int[][] direction = {{1, -1}, {1, 0}, {1, 1}, {0, -1}, {0, 1}, {-1, -1}, {-1, 0}, {-1, 1}};
        // 定义两个int型变量记录传入的参数二维数组gird的长宽信息
        int m = grid.length;
        int n = grid[0].length;

        // 定义一个存放pair类型的队列，其中pair数据中的键值都为Integer类型
        Queue<Pair<Integer, Integer>> queue = new LinkedList<>();
        queue.add(new Pair<>(0,0));
        int pathLength = 0;
        while(!queue.isEmpty()){
            int size = queue.size();
            pathLength++;
            while(size-- > 0){
                Pair<Integer, Integer> cur = queue.poll();
                // 定义两个int型的变量记录当前遍历到的pair的键和值
                int cr = cur.getKey();
                int cc = cur.getValue();
                if(grid[cr][cc] == 1){
                    continue;
                }
                if(cr == m - 1 && cc == n - 1){
                    return pathLength;
                }
                grid[cr][cc] = 1; // 标记
                for(int[] d : direction){
                    int nr = cr + d[0], nc = cc + d[1];
                    if(nr < 0 || nr >= m || nc < 0 || nc >= n){
                        continue;
                    }
                    queue.add(new Pair<>(nr, nc));
                }
            }
        }
        return -1;
    }

    // 方法2：其实也是BFS，只是代码和方法1有些许不一样
    public static int shortestPathBinaryMatrix2(int[][] grid) {
        // 先判断如果左上角第一个点就是1的话可以直接不用走了，直接返回-1
        if (grid[0][0] == 1) {
            return -1;
        }

        // 定义一个int型的变量初始化值为二维数组的边的长度
        final int N = grid.length;
        final int[][] DIRECTIONS = new int[][]{{-1, 0}, {0, 1}, {1, 0}, {0, -1}, {-1, -1}, {-1, 1}, {1, -1}, {1, 1}};
        boolean[][] visited = new boolean[N][N];
        // 创建队列用于保存每一个可以走的步
        LinkedList<int[]> queue = new LinkedList<>();
        queue.add(new int[]{0, 0});
        int depth = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            depth++;
            for (int i = 0; i < size; i++) {
                int[] node = queue.removeFirst();
                if (node[0] == N - 1 && node[1] == N - 1) {
                    return depth;
                }
                for (int[] direction : DIRECTIONS) {
                    int x = node[0] + direction[0];
                    int y = node[1] + direction[1];
                    // 排除：1、越界 2、已访问 3、阻塞
                    if (x < 0 || x >= N || y < 0 || y >= N || visited[x][y] || grid[x][y] == 1) {
                        continue;
                    }
                    visited[x][y] = true;
                    queue.addLast(new int[]{x, y});
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[][] arr = new int[][]{{0,0,0},{1,1,0},{1,1,0}};
        int res = shortestPathBinaryMatrix2(arr);
        System.out.println(res);
    }
}
