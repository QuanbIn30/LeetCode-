package lc_5_1;

import java.util.Arrays;

/**
 * @author superquanbin@gmail.com
 * @date 2020-05-01 15:13
 */
public class lc_213_rob {

    // method one
    public int rob1(int[] nums){
        if(nums == null || nums.length == 0){
            return 0;
        }
        int n = nums.length;
        if(nums.length == 1){
            return nums[0];
        }
        // Arrays.copyOfRange()中的参数from和to要注意!!!!!
        // 新产生的数组包括愿数组from索引处的元素，但是不包括to索引处的元素
        // [from, to)
        return Math.max(dp1(Arrays.copyOfRange(nums,0,n - 1)),
                           dp1(Arrays.copyOfRange(nums,1,n)));



    }
    private int dp1(int[] nums){
        int pre = 0;
        int cur = 0;
        for(int num : nums){
            int temp = cur;
            cur = Math.max(pre + num, cur);
            pre = temp;
        }
        return cur;
    }

    // method two
    public int rob2(int[] nums) {
        // 国际惯例，先判断一下输入的欺骗性
        if(nums == null || nums.length == 0)return 0;
        // 如果输入的数组长度是1，那么直接返回其中的哪一个唯一的元素就行
        if(nums.length == 1) return nums[0];
        // 因为这个是环形打家劫舍，所以如果抢了第一家就不能抢最后一家，因为他们是连起来的，同理，如果抢了最后一家，就不能抢第一家
        int res =  Math.max(dp2(Arrays.copyOfRange(nums,0,nums.length - 1)),
                dp2(Arrays.copyOfRange(nums,1,nums.length)));
        return res;
    }
    // 因为只需要最终的结果，所以这个动态规划的过程也就不要保留中间的过程得到的最优解，所以不必用一个数组记录中间过程的最优解，
    // 可以用两个变量交替记录当前值和前一个值
    private int dp2(int[] nums){
        int cur = 0;
        int pre = 0;
        // 这里我想形象的说下cur和pre这两个变量在下面这个for循环中是如何工作的，很好理解
        // 进入for循环之后，cur叫来一个小老弟就是temp（一看temp这名字，临时工嘛～），叫这个临时工temp先把我的数拿着
        // 然后我去那Math.max()运算完之后的数，因为我得拿最大的，然后cur的小弟pre这个老哥就来接管temp得数了，他对temp说：来给我吧～
        // temp这个临时工把它帮大哥cur拿着的数给pre之后，temp就可以离场了，你走吧～，下次循环再见
        // 这一次存还结束之后得到的结果就是，pre拿着之前老大哥cur上一轮的数，cur拿到了新的最大的或者和一轮一样的数
        for(int num : nums){
            int temp = cur;
            cur = Math.max(pre + num, cur);
            pre = temp;
        }
        return cur;
    }

    // method three
    public int rob3(int[] nums){
        return rb(0, nums);
    }
    private int rb(int start, int[] nums){
        if (start >= nums.length) {
            return 0;
        }
        int res = Math.max(rb(start + 1, nums),
                           nums[start] + rb(start +  2, nums));
        return res;
    }


    public static void main(String[] args) {
        lc_213_rob tc = new lc_213_rob();
        int[] arr = new int[]{1,2,3,1};
//        int res = tc.rob1(arr);
        int res = tc.rob2(arr);
        System.out.println(res);
    }
}
