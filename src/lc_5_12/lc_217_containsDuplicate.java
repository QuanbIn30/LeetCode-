package lc_5_12;

import java.util.HashSet;

/**
 * 存在重复元素
 * @author superquanbin@gmail.com
 * @date 2020-05-12 17:43
 */
public class lc_217_containsDuplicate {

    HashSet<Integer> set = new HashSet<>();

    public boolean containsDuplicate(int[] nums){
        for(int i = 0; i < nums.length; i++){
            if(set.contains(nums[i])){
                return true;
            }else{
                set.add(nums[i]);
            }
        }
        return false;
    }
}
