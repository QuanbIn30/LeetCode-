package lc_5_5;

import java.util.Arrays;

/**
 * 最少移动次数使数组元素相等
 * @author superquanbin@gmail.com
 * @date 2020-05-05 21:45
 */
public class lc_462_minMoves2 {

    public int minMoves2(int[] nums){
        Arrays.sort(nums);
        int sum = 0;
        for(int num : nums){
            sum += Math.abs(nums[nums.length / 2] - num);
        }
        return sum;
    }

    public static void main(String[] args) {
        lc_462_minMoves2 tc = new lc_462_minMoves2();
        int[] arr = new int[]{1,2,3,4,5};
        int res = tc.minMoves2(arr);
        System.out.println(res);
    }
}
