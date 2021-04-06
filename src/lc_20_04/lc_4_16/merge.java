package lc_20_04.lc_4_16;

import java.util.Scanner;

/**
 * 合并两个有序数组
 * @author superquanbin@gmail.com
 * @date 2020-04-16 11:39
 */
public class merge {

    // 方法1
    public static void merge1(int[] nums1, int m, int[] nums2, int n){
        int i = 0;
        int j = 0;
        int k = 0;
        int[] help = new int[nums1.length];
        while(i < m && j < n){
            help[k++] = nums1[i] < nums2[j] ? nums1[i++] : nums2[j++];
        }

        while(i < m){
            help[k++] = nums1[i++];
        }

        while(j < n){
            help[k++] = nums2[j++];
        }

        for (int l = 0; l < nums1.length; l++) {
            nums1[l] = help[l];
        }
    }

    // 方法2
    public static void merge2(int[] nums1, int m, int[] nums2, int n){
        int p = m-- + n-- - 1;
        while(m >= 0 && n >= 0){
            nums1[p--] = nums1[m] > nums2[n] ? nums1[m--] : nums2[n];
        }
        while(n >= 0){
            nums1[p--] = nums2[n--];
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNextInt()){

        }
    }
}
