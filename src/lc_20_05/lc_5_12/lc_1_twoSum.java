package lc_20_05.lc_5_12;

import java.util.HashMap;

/**
 * 两数之和
 * @author superquanbin@gmail.com
 * @date 2020-05-12 17:26
 */
public class lc_1_twoSum {

    public int[] twoSum(int[] nums, int target){
        HashMap<Integer, Integer> indexForNum = new HashMap<>();
        for(int i = 0; i < nums.length; i++){
            if(indexForNum.containsKey(target - nums[i])){
                return new int[]{indexForNum.get(target - nums[i]), i};
            }else{
                indexForNum.put(nums[i], i);
            }
        }
        return null;
    }
}
