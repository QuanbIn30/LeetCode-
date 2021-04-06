package lc_20_04.lc_4_19;

import java.util.Scanner;

/**
 * 买卖股票最大收益I
 * @author superquanbin@gmail.com
 * @date 2020-04-19 16:01
 */
public class lc_121_maxProfitI {

    // 方法1：
    // 贪心算法：
    // 只要记录前面的最小价格，将这个最小价格作为买入价格，
    // 然后将当前的价格作为售出价格，查看当前收益是不是最大收益
    public static int maxProfit1(int[] prices){
        // 判断输入的数组的长度是否为0
        int n = prices.length;
        if(n == 0)
            return 0;

        // 记录前面的最小价格
        // 初始时以第一天的价格作为最小价格
        int soFarMin = prices[0];
        int max = 0;

        // 遍历数组并且更新前面最小的价格和最大收益
        for(int i = 1; i < n; i++){
            if(soFarMin > prices[i])
                soFarMin = prices[i];
            else
                max = Math.max(max, prices[i] - soFarMin);
        }
        // 返回最大收益
        return max;
    }

    public static void main(String[] args) {
        System.out.println("please input array's element~");
        Scanner sc = new Scanner(System.in);
        String[] nums = null;
        nums = sc.nextLine().split(" ");
        int num[] = new int[nums.length];
        for(int i = 0; i < nums.length; i++){
            num[i] = Integer.valueOf(nums[i]);
        }

        int res = maxProfit1(num);
        System.out.println(res);
    }
}
