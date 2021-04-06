package lc_20_04.lc_4_10;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author superquanbin@gmail.com
 * @date 2020-04-10 18:19
 */
public class lc_452_findMinArrowShots {
    public static int findMinArrowShots(int[][] points){
        if (points.length == 0){
            return 0;
        }
        Arrays.sort(points, Comparator.comparingInt(o -> o[1]));
        int cnt = 1, end = points[0][1];
        for (int i = 1; i < points.length; i++){
            if (points[i][0] <= end){
                continue;
            }
            cnt++;
            end = points[i][1];
        }
        return cnt;
    }
}
