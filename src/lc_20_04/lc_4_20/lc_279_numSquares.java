package lc_20_04.lc_4_20;

import java.util.List;
import java.util.ArrayList;
import java.util.Queue;
import java.util.LinkedList;
/**
 * @author superquanbin@gmail.com
 * @date 2020-04-20 22:34
 */
public class lc_279_numSquares {
    public static int numSquares(int n){
        // 定义一个存放Integer类型的List链表
        List<Integer> squares = generateSquares(n); // squares是小于n的平方数列表
        Queue<Integer> queue = new LinkedList<>();
        boolean[] marked = new boolean[n + 1];
        queue.add(n);
        marked[n] = true;
        int level = 0;
        while(!queue.isEmpty()){
            int size = queue.size();
            level++;
            while(size-- > 0){
                int cur = queue.poll();
                for(int s : squares){
                    int next = cur - s;
                    if(next < 0){
                        break;
                    }
                    if(next == 0){
                        return level;
                    }
                    if(marked[next]){
                        continue;
                    }
                    marked[next] = true;
                    queue.add(next);
                }
            }
        }
        return level;
    }

    /**
     * 生成小于平方数序列
     */
    private static List<Integer> generateSquares(int n){
        List<Integer> squares = new ArrayList<>();
        int square = 1;
        int diff = 3;
        while(square <= n){
            squares.add(square);
            square += diff;
            diff += 2;
        }
        return squares;
    }

    public static void main(String[] args) {
        int n = 13;
        int res = numSquares(n);
        System.out.println(res);
    }
}
