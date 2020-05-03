package lc_4_30;

import java.util.ArrayList;
import java.util.List;

/**
 * @author superquanbin@gmail.com
 * @date 2020-04-30 23:07
 */
public class lc_216_combinationSum3 {
        public List<List<Integer>> combinationSum3(int k, int n) {
            // 国际惯例 判断一下输入的欺骗性
            if(n == 0){
                return null;
            }
            // 定义两个变量用于存放最终结果集和临时结果集
            List<List<Integer>> res = new ArrayList<>();
            List<Integer> tempres = new ArrayList<>();
            int circleLength = 1;
            // 定义一个元素为1～9的数字元素的数组
            int[] nums = new int[]{1,2,3,4,5,6,7,8,9};
            // dfs盘它
            dfs(res, tempres, 0, n, nums, 9,circleLength, k);
            // 返回最终结果集
            return res;
        }

        private void dfs(List<List<Integer>> res, List<Integer> tempres, int begin,
                         int residue, int[] nums, int len, int circleLength, int k){
            // 先判断一下当前剩余的数是不是已经等于0了，如果是的话就可以添加到最终结果集中，然后返回了
            if(residue == 0 && tempres.size() == k){
                res.add(new ArrayList<>(tempres));
                return;
            }

            if(circleLength > k){
                return;
            }
            // 否则的话for循环搞他，在可选择列表中做选择
            for(int i = begin; i < len; i++){
                // 判断当前剩余数减去当前遍历到的数是不是 < 0 了，如果是的话直接break退出
                if(residue - nums[i] < 0){
                    break;
                }

                // 往临时结果集中存入当前遍历到的数
                tempres.add(nums[i]);
                // 继续dfs在剩余可选择列表中做选择
                dfs(res, tempres, i + 1, residue - nums[i], nums, len, circleLength + 1, k);
                // 删除临时结果集中最后一个数，并且控制结果数组长度的变量 - 1
                tempres.remove(tempres.size() - 1);
                circleLength -= 1;
            }

        }

    public static void main(String[] args) {
        lc_216_combinationSum3 testclass = new lc_216_combinationSum3();
        int n = 7;
        int k = 3;
        List<List<Integer>> res = testclass.combinationSum3(k,n);
        System.out.println(res);
    }
}
