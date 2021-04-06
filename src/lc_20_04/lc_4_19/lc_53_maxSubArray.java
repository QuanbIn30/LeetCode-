package lc_20_04.lc_4_19;

/**
 * 最大子序和
 * @author superquanbin@gmail.com
 * @date 2020-04-19 20:42
 */
public class lc_53_maxSubArray {

    public static int maxSubArray (int[] nums){
        // 判断输入的字符串是否为空
        if(nums == null || nums.length == 0)
            return 0;

        // 定义两个int型的变量记录当前子序和和当前最大子序和
        int preSum = nums[0];
        int maxSum = preSum;

        // 遍历数组更新当前子序和和当前最大子序和
        for(int i = 1; i < nums.length; i++){
            preSum = preSum > 0 ? preSum + nums[i] : nums[i];
            maxSum = Math.max(maxSum, preSum);
        }
        return maxSum;
    }
}
