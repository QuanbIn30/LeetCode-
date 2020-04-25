package lc_4_10;

import java.util.Arrays;
import java.util.Scanner;

/**
 *
 * 分发饼干
 * @author superquanbin@gmail.com
 * @date 2020-04-10 11:12
 */
public class lc_455_findContentChildren {

    // 解法1：双指针
    public static int findContentChildren(int[] g, int[] s){

        Arrays.sort(g);
        Arrays.sort(s);

        int gi = g.length - 1;
        int si = s.length - 1;
        int res = 0;

        while(gi >=0 && si >= 0){
            if (s[si] >= g[gi]){
                res++;
                si--;
            }
            gi--;
        }
        return res;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] g = new int[5];
        System.out.println("plese input 5 numbers for array g!");
        for (int i = 0; i < 5; i++){
            g[i] = sc.nextInt();
        }
        int[] s = new int[5];
        System.out.println("plese input 5 numbers for array s!");
        for (int i = 0; i < 5; i++) {
            s[i] = sc.nextInt();
        }

        int ans = findContentChildren(g,s);
        System.out.println(ans);
    }
}
