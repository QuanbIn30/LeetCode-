package lc_20_05.lc_5_5;

import java.util.Arrays;

/**
 * 数组中出现次数多于n/2的元素
 * @author superquanbin@gmail.com
 * @date 2020-05-05 22:04
 */
public class lc_169_majorityElement {

    // 方法1
    public int majorityElement1(int[] nums){
        Arrays.sort(nums);
        return nums[nums.length / 2];
    }
}
