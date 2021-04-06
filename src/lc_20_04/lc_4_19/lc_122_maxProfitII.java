package lc_20_04.lc_4_19;

/**
 * 买卖股票收益最大II
 * @author superquanbin@gmail.com
 * @date 2020-04-19 16:51
 */
public class lc_122_maxProfitII {

    public static int maxProfit1(int[] prices){
        int profit = 0;
        for(int i = 1; i < prices.length; i++){
            if(prices[i] > prices[i - 1]){
                profit += (prices[i] - prices[i - 1]);
            }
        }
        return profit;
    }
}
