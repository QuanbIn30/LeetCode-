package lc_4_20;

/**
 * 旋转数组的最小数字
 * @author superquanbin@gmail.com
 * @date 2020-04-20 10:51
 */
public class lc_153_findMin {
    public static int findMin(int[] nums){
        int l = 0;
        int h = nums.length - 1;
        while(l < h){
            int m = l + (h - l) / 2;
            if(nums[m] < nums[h]){
                h = m;
            }else{
                l = m + 1;
            }
        }
        return nums[l];
    }
}
