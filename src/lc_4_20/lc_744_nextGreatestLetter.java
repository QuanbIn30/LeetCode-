package lc_4_20;

import java.util.Scanner;
/**
 * 寻找大于给定元素的最小元素
 * @author superquanbin@gmail.com
 * @date 2020-04-20 08:58
 */
public class lc_744_nextGreatestLetter {

    public static char nextGreatestLetter(char[] letters, char target){
        int n = letters.length;
        int l =0;
        int h = n - 1;
        while(l <= h){
            int m = l + (h - l) / 2;
            if(letters[m] <= target){
                l = m + 1;
            }else{
                h = m - 1;
            }
        }
        return l < n ? letters[l] : letters[0];
    }


}
