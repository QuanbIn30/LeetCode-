package lc_20_04.lc_4_19;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 用最少数量的箭引爆气球
 * @author superquanbin@gmail.com
 * @date 2020-04-19 12:11
 */
public class lc_452_findMinArrowShots {
    public static int findMinArrowShots(int[][] points){
        // 先判断如果区间为空则直接返回0
        if(points.length == 0){
            return 0;
        }

        // 然后将区间按照区间尾从小到大的顺序排序
        Arrays.sort(points, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1] - o2[1];
            }
        });

        // 遍历一遍区间，如果当前区间头大于前一个区间尾则是无覆盖区间，此时代表无覆盖区间的cnt++
        int cnt = 1;
        int end = points[0][1];
        for(int i = 1; i < points.length; i++){
            if(points[i][0] <=  end){
                continue;
            }
            end = points[i][1];
            cnt++;
        }
        // 最后返回cnt即可
        return cnt;
    }

}
