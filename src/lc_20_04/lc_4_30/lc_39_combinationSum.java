package lc_20_04.lc_4_30;

import java.util.ArrayList;
import java.util.List;

/**
 * 组合求和
 *
 * 回溯模版：
 * result = []
 * def backtrack(路径, 选择列表):
        *     if 满足结束条件:
        *         result.add(路径)
        *         return
        *
        *     for 选择 in 选择列表:
        *         做选择
        *         backtrack(路径, 选择列表)
        *         撤销选择
        * @author superquanbin@gmail.com
 * @date 2020-04-30 10:15
        */
public class lc_39_combinationSum {
    public List<List<Integer>> combinationSum (int[] candidates, int target){
        List<List<Integer>> combinations = new ArrayList<>();
        backtracking(new ArrayList<>(), combinations, 0, target, candidates);
        return combinations;
    }
    private void backtracking(List<Integer> tempCombination, List<List<Integer>> combinations,
                              int start, int target, int[] candidates){
        if(target == 0){
            combinations.add(new ArrayList<>(tempCombination));
            return;
        }
        for(int i = start; i < candidates.length; i++){
            if(candidates[i] <= target){
                tempCombination.add(candidates[i]);
                backtracking(tempCombination, combinations, i, target - candidates[i], candidates);
                tempCombination.remove(tempCombination.size() - 1);
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = new int[]{2,3,6,7};
        lc_39_combinationSum testclass = new lc_39_combinationSum();
        List<List<Integer>> res = testclass.combinationSum(arr,7);
        System.out.println(res);
    }
}
