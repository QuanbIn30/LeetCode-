package lc_20_04.lc_4_26;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author superquanbin@gmail.com
 * @date 2020-04-26 09:55
 */
public class lc_47_permuteUnique {

    List<List<Integer>> permutes = new ArrayList<>();

    public List<List<Integer>> permuteUnique(int[] nums){
        List<Integer> permuteList = new ArrayList<>();
        boolean[] hasVisited = new boolean[nums.length];
        Arrays.sort(nums);
        backtracking(permutes, permuteList, hasVisited, nums);
        return permutes;
    }

    private void backtracking(List<List<Integer>> permutes, List<Integer> permuteList,
                              boolean[] visited, int[] nums){
        if(permuteList.size() == nums.length){
            permutes.add(new ArrayList<>(permuteList));
            return;
        }
        // do select
        for(int i = 0; i < nums.length; i++){
            if (i != 0 && nums[i] == nums[i - 1] && !visited[i - 1]) {
                continue;  // 防止重复
            }
            if (visited[i]){
                continue;
            }
            visited[i] = true;
            permuteList.add(nums[i]);
            backtracking(permutes,permuteList,visited,nums);
            // redo select
            permuteList.remove(permuteList.size() - 1);
            visited[i] = false;
        }
    }

    public static void main(String[] args) {
        lc_47_permuteUnique testclass = new lc_47_permuteUnique();
        int[] input = new int[]{1,2,1};
        List<List<Integer>> res = testclass.permuteUnique(input);
        System.out.println(res);

    }
}
