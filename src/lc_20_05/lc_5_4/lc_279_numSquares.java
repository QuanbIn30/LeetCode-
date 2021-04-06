package lc_20_05.lc_5_4;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 完全平方数
 * @author superquanbin@gmail.com
 * @date 2020-05-04 12:27
 */
public class lc_279_numSquares {
    // 方法1：
    public int numSquares(int n){
        // 定义一个dp数组
        int[] dp = new int[n + 1];
        // 这个for循环从1开始遍历，可以遍历到等于n
        for(int i = 1; i <= n; i++){
            // 这个赋值行为是给每个数赋上最差的情况，就是当前i的结果集全都是1
            dp[i] = i;
            for(int j = 1; i - j * j >= 0; j++){
                // 注意：下面这个dp[i - j * j] + 1 其中的1，是代表我的结果集中还有"j"这个数，
                // 所以要加上一个1，
                // 就是我减去j * j 之后还能分多少个我不管，只要我能分出来这个j，就说明我至少结果集中要包含j这个数
                // 至于减去j * j 之后还能分出多少个数会在其他会和算出来存在dp数组中
                dp[i] = Math.min(dp[i], dp[i - j * j] + 1);
            }
        }
        return dp[n];
    }

    // 方法2：
    public int numSquarea(int n){

        Queue<Integer> queue = new LinkedList<>();
        HashSet<Integer> visited = new HashSet<>();
        int level = 0;
        queue.add(n);
        while(!queue.isEmpty()){
            int size = queue.size();
            level++; // 开始往下一层
            for(int i = 0; i < size; i++){
                int cur = queue.poll();
                for(int j = 1; j * j <= cur; j++){
                    int next = cur - j * j;
                    if(next == 0){
                        return level;
                    }
                    if(!visited.contains(next)){
                        queue.offer(next);
                        visited.add(next);
                    }
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        lc_279_numSquares tc = new lc_279_numSquares();
        int n = 12;
        int res = tc.numSquares(n);
        System.out.println(res);
    }
}
