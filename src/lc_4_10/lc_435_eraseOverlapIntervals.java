package lc_4_10;

import java.util.Arrays;
import java.util.Comparator;

/**
 *
 * 无重叠区间
 * @author superquanbin@gmail.com
 * @date 2020-04-10 15:59
 */
public class lc_435_eraseOverlapIntervals {

    // Definition for an Interval
    public static class Interval{
        int start;
        int end;
        public Interval(){
            start = 0;
            end = 0;
        }
        public Interval(int s, int e){
            start = s;
            end = e;
        }
    }

    // 解法1：动态规划
    public static int eraseOverlapIntervals1(Interval[] intervals){

        if(intervals.length == 0)
            return 0;

        Arrays.sort(intervals, new Comparator<Interval>(){
            @Override
            public int compare(Interval o1, Interval o2) {
                // 如果o1和o2的起始点不相同的话那么谁的起始点在前就让他在比较结果中放在前面
                if (o1.start != o2.start)
                    return o1.start - o2.start;
                // 否则谁的终止点在前就让他在比较结果中放在前面
                return o1.end - o2.end;
            }
        });

        //memo[i]表示以intervals[i]为结尾的区间能构成的最长不重叠区间序列
        int[] memo = new int[intervals.length];
        Arrays.fill(memo, 1);
        for (int i = 1; i < intervals.length; i++)
            // memo[i]
            for (int j = 0; j < i; j++)
                if (intervals[i].start >= intervals[j].end)
                    memo[i] = Math.max(memo[i], 1 + memo[j]);

        int res = 0;
        for (int i = 0; i < memo.length; i++)
            res = Math.max(res, memo[i]);

        return intervals.length - res;
    }

    // 解法2：贪心算法
    public static int eraseOverlapIntervals2(Interval[] intervals){

        if (intervals.length == 0)
            return 0;

        Arrays.sort(intervals, new Comparator<Interval>(){
            @Override
            public int compare(Interval o1, Interval o2) {
                if (o1.end != o2.end)
                    return o1.end - o2.end;
                return o1.start;
            }
        });

        int res = 1;
        int pre = 0;
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i].start >= intervals[pre].end){
                res++;
                pre = i;
            }
        }
        return intervals.length - res;
    }

    public static void main(String[] args) {
        Interval[] interval1 = {new Interval(1,2),
                                new Interval(2,3),
                                new Interval(3,4),
                                new Interval(1,3)};
        //System.out.println(eraseOverlapIntervals1(interval1));
        System.out.println(eraseOverlapIntervals2(interval1));
    }
}
