package lc_20_04.lc_4_19;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 无重叠区间
 * 题目描述：计算让一组区间不重叠所需要移除的区间个数
 * 解法：
 * 先计算最多能组成不重叠的区间个数，然后用区间总数减去不重叠区间的个数
 * 在每次选择中，区间结尾最为重要，选择的区间结尾越小，留给后面的空间越大，
 * 那么后面可选则的区间个数越多
 * 按区间结尾进行排序，每次选择结尾最小，并且和前一个区间不重叠的区间
 * @author superquanbin@gmail.com
 * @date 2020-04-19 11:02
 */
public class lc_435_eraseOverlapIntervals {

    public int eraseOverlapIntervals(int[][] intervals){

        // 先判断如果整个区间都是空的话直接返回0
        if(intervals.length == 0){
            return 0;
        }

        // 然后将区间按照区间尾从小到大的顺序进行排序
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1] - o2[1];
            }
        });

        // 然后遍历一遍区间数组，如果下一个区间的头比上一个区间的尾要大就符合无覆盖的条件
        int cnt = 1;
        int end = intervals[0][1];
        for(int i = 1; i < intervals.length; i++){
            if(intervals[i][0] < end){
                continue;
            }
            end = intervals[i][1];
            cnt++;
        }
        // 减去符合条件的区间个数就是要删除的区间个数
        return intervals.length - cnt;
    }
}
