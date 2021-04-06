package lc_20_04.lc_4_19;

import java.util.Arrays;

/**
 * 分发饼干
 * @author superquanbin@gmail.com
 * @date 2020-04-19 10:41
 */
public class lc_455_findContentChildren {

    public static int findContentChildren(int[] g, int[] s){
        if(g == null || s == null){
            return 0;
        }
        Arrays.sort(g);
        Arrays.sort(s);

        int gi = 0;
        int si = 0;
        while(gi < g.length && si < s.length){
            if(g[gi] <= s[si]){
                gi++;
            }
            si++;
        }
        return gi;
    }
}
