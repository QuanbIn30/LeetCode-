package lc_4_30;

import java.util.*;

/**
 * 含有相同元素的组合求和
 * @author superquanbin@gmail.com
 * @date 2020-04-30 11:48
 */
public class lc_40_combinationSum2 {

    // Method one
    public List<List<Integer>> combinationSum2_1(int[] candidates, int target) {
        List<List<Integer>> combinations = new ArrayList<>();
        Arrays.sort(candidates);
        backtracking(new ArrayList<>(), combinations, new boolean[candidates.length], 0, target, candidates);
        return combinations;
    }

    private void backtracking(List<Integer> tempCombination, List<List<Integer>> combinations,
                              boolean[] hasVisited, int start, int target, final int[] candidates){
        if(target == 0){
            combinations.add(new ArrayList<>(tempCombination));
            return;
        }
        // 在可选择列表中选择
        for(int i = start; i < candidates.length; i++){
            // 剪枝策略就是寻找过滤条件，提前减少不必要的搜索路径。
            // 应用剪枝优化的核心问题是设计剪枝判断方法
            if(i >= 1 && candidates[i] == candidates[i - 1] && !hasVisited[i - 1]){
                continue;
            }
            if(candidates[i] <= target){
                tempCombination.add(candidates[i]);
                hasVisited[i] = true;
                // 继续做选择
                backtracking(tempCombination, combinations, hasVisited, i + 1, target - candidates[i], candidates);
                // 撤销选择
                hasVisited[i] = false;
                tempCombination.remove(tempCombination.size() - 1);
            }
        }
    }


    // Method tow
    public List<List<Integer>> combinationSum2_2(int[] candidates, int target){
        int len = candidates.length;
        List<List<Integer>> res = new ArrayList<>();
        if(len == 0){
            return res;
        }
        // Sorted the input array
        Arrays.sort(candidates);
        Deque<Integer> path = new ArrayDeque<>(len);
        dfs(candidates, len, 0, target, path, res);
        return res;
    }

    private void dfs(int[] candidates, int len, int begin, int residue,
                     Deque<Integer> path, List<List<Integer>> res){

        if(residue == 0){
            res.add(new ArrayList<>(path));
            return;
        }

        for(int i = begin; i < len; i++){
            if(residue - candidates[i] < 0){
                break;
            }
            if(i >= 1 && candidates[i] == candidates[i - 1]){
                continue;
            }
            path.addLast(candidates[i]);
            dfs(candidates, len, begin, residue, path, res);
            path.removeLast();
        }
    }

    // method three
        public List<List<Integer>> combinationSum2_3(int[] candidates, int target){
            // 国际惯例，判断以下输入的欺骗性
            if(candidates == null || candidates.length == 0)
                return null;

            int len = candidates.length;

            // 然后要新建几个变量用来存最终结果集和临时结果集
            List<List<Integer>> res = new ArrayList<>();
            List<Integer> tempres = new ArrayList<>(len);
            // 因为解集要不包含重复的元素，这就提示我们要先对数组排个序（升序和降序均可）
            Arrays.sort(candidates);
            // 回溯搞他
            dfs(res, tempres, 0, target, candidates, len);
            // 返回结果
            return res;
        }

        // 回溯
        private void dfs(List<List<Integer>> res, List<Integer> tempres, int begin, int residue, int[] candidates, int len){
            // 先看剩余数是不是已经 < 0了，是的话就将临时结果集（或者叫路径）存进最终结果集中，直接返回
            if(residue == 0){
                res.add(new ArrayList<>(tempres));
                return;
            }

            // 然后for循环搞他，for循环的作用就是在可选列表中做选择
            for(int i = begin; i < len; i++){
                // 如果剩余数 - 当前遍历到的数 < 0，就可以直接break跳出这次循环了，这是这次遍历中的大剪枝
                if(residue - candidates[i] < 0){
                    break;
                }
                // 如果当前遍历到了第i个数，且i > begin ，当前数等于数组中的前一个数，那么直接跳过这个数
                if(i > begin && candidates[i] == candidates[i - 1]){
                    continue;
                }
                tempres.add(candidates[i]);
                dfs(res, tempres, i + 1, residue - candidates[i], candidates, len);
                tempres.remove(tempres.size() - 1);
            }

        }

        // method four
            public List<List<Integer>> combinationSum2(int[] candidates, int target) {
                // 国际惯例，判断一下输入的欺骗性
                if(candidates == null || candidates.length == 0){
                    return null;
                }
                int len = candidates.length;
                // 然后定义两个变量存放最终结果集和临时结果集
                List<List<Integer>> res = new ArrayList<>();
                List<Integer> tempres = new ArrayList<>();
                // 因为题意指出不能有重复解，所以给输入的数组排个序
                Arrays.sort(candidates);
                // 回溯搞他
                dfs(res, tempres, 0, target, len, candidates);
                // 返回最终结果集
                return res;
            }

            private void dfs(List<List<Integer>> res, List<Integer> tempres, int begin, int residue, int len, int[] candidates){
                // 判断剩余数是不是等于0,等于0就说明当前临时结果集（或者叫路径）中的结果符合题目要求，可以返回了
                if(residue == 0){
                    res.add(new ArrayList<>(tempres));
                    return;
                }
                // 否则的话for循环搞他，在可选列表中做选择
                for(int i = begin; i < len; i++){
                    // 判断当前当前剩余数减去当前遍历到的数是不是 < 0 了，是的话就直接break退出
                    if(residue - candidates[i] < 0){
                        break;
                    }
                    // 判断当前是不是遍历到了比begin大的索引处，是的话就对比一下当前数组中被遍历到的数是不是和他的前一个索引处的数相等，是的话直接continue跳过此轮循环
                    if(i > begin && candidates[i] == candidates[i - 1]){
                        continue;
                    }
                    tempres.add(candidates[i]);
                    // dfs继续搞他（继续在剩余的可选列表中做选择），不过要主要begin要 + 1 ，而且剩余数也就是residue要减去当前这一轮遍历到的数
                    dfs(res, tempres, i + 1, residue - candidates[i], len, candidates);
                    // 删除临时结果集中最后一个元素，这是回溯中的撤销选择
                    tempres.remove(tempres.size() - 1);
                }
            }

    public static void main(String[] args) {
        lc_40_combinationSum2 testclass = new lc_40_combinationSum2();
        int[] arr = new int[]{10,1,2,7,6,1,5};
        int target = 8;
        List<List<Integer>> res = testclass.combinationSum2_3(arr, target);
        System.out.println(res);
    }
}
