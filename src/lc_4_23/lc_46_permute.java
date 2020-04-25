package lc_4_23;

import java.util.ArrayList;
import java.util.List;

/**
 * 全排列
 * @author superquanbin@gmail.com
 * @date 2020-04-23 21:58
 */
public class lc_46_permute {
    public List<List<Integer>> permute (int[] nums){
        // 定义一个存放链表的链表permutes用来存放结果集
        List<List<Integer>> permutes = new ArrayList<>();
        // 定义一个链表用来临时存放结果
        List<Integer> permuteList = new ArrayList<>();
        // 定义一个boolean类型的数组用来标记当前链路有哪些字符已经走过了
        boolean[] hasVisited = new boolean[nums.length];
        backtracking(permuteList,permutes, nums,hasVisited);
        return permutes;
    }

    // 回溯
    private void backtracking(List<Integer> permuteList, List<List<Integer>> permutes,
                              int[] nums, boolean[] visited){

        // 如果临时结果集的长度与输入的字符串长度一样，则说明当前链路已经符合结果的要求了，
        // 可以作为结果添加进最终的结果集中
        if(permuteList.size() == nums.length){
            permutes.add(new ArrayList<>(permuteList));
            return;
        }

        for(int i = 0; i < visited.length; i++){
            if(visited[i]){
                continue;
            }
            visited[i] = true;
            permuteList.add(nums[i]);
            backtracking(permuteList,permutes,nums,visited);
            permuteList.remove(permuteList.size() - 1);
            visited[i] = false;
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,2,3};
        lc_46_permute testclass = new lc_46_permute();
        List<List<Integer>> res = testclass.permute(nums);
        System.out.println(res);
    }
}
