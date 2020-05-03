package lc_5_1;

import java.util.Arrays;

/**
 * 打家劫舍
 * @author superquanbin@gmail.com
 * @date 2020-05-01 11:57
 */
public class lc_198_rob {
    // method one
    public int rob1(int[] nums){
        int pre2 = 0;
        int pre1 = 0;
        for(int i = 0; i < nums.length; i++){
            int cur = Math.max(pre2 + nums[i], pre1);
            pre2 = pre1;
            pre1 = cur;
        }
        return pre1;
    }

    // method two
    public int rob2(int[] nums) {
        if(nums == null || nums.length == 0){
            return 0;
        }
        int len = nums.length;
        int[] dp = new int[len + 1];
        dp[0] = 0;
        dp[1] = nums[0];
        // 这里要注意边界的控制，nums[i]会越界，正确的定位输入数组中的元素的是nums[i - 1]
        for(int i = 2; i <= len; i++){
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i - 1]);
        }
        return dp[len];
    }

    // method three
    // 定义一个备忘录数组，用来存放在每个走过的房间时抢到的最多金额
    int[] memo;
    public int rob3(int[] nums){
        // 初始化备忘录数组
        memo = new int[nums.length];
        Arrays.fill(memo, -1);
        // 抢！！！！！！！
        return rb(0, nums);
    }
    private int rb(int start, int[] nums){
        // 边界判断
        if(start >= nums.length)
            return 0;
        // 如果当前来到做过选择的房子，那么就从备忘录中直接取出记录下的当前位置最多能抢的值就行
        if(memo[start] != -1)
            return memo[start];
        // 当你站在start位置时，你要选择是抢下一间房子还是当前这间房子和下下间房子
        // 选择的依据是选能抢到最多金额的
        // 如果抢下一间房子会有得到更多的金额，就选下一间房子，跳过这一间
        // 如果选当前这一间和下下间会得到更多的金额就选当前这一间和下下间
        int res = Math.max(rb(start + 1, nums),
                           nums[start] + rb(start + 2, nums));
        // 记得填充备忘录，把当前位置的最多能抢到的金额存在备忘录中的当前房间位置的索引处
        memo[start] = res;
        return res;
    }

    public int rob4(int[] nums){
        int cur = 0;
        int pre = 0;
        int temp;
        for(int num : nums){
            temp = cur;
            cur = Math.max(pre + num, cur);
            pre = temp;
        }
        return cur;
    }

    public static void main(String[] args) {
        lc_198_rob tc = new lc_198_rob();
//        int res = tc.rob3(new int[]{2,7,9,3,1});
        int res = tc.rob4(new int[]{1,2,3,1});
//        int res = tc.rob2(new int[]{1,2,3,1});
        System.out.println(res);
    }
}
