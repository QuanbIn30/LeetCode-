package lc_20_05.lc_5_12;

import java.util.HashMap;
import java.util.Map;

/**
 * 最长和谐序列
 * @author superquanbin@gmail.com
 * @date 2020-05-12 20:03
 */
public class lc_594_findLHS {

    public int findLHS(int[] nums){
        Map<Integer, Integer> countForNum = new HashMap<>();
        for(int num : nums){
            countForNum.put(num, countForNum.getOrDefault(num, 0) + 1);
        }
        int longest = 0;
        // map.keySet() -> 返回此映射中包含的键的 Set 视图
        for(int num : countForNum.keySet()){
            if(countForNum.containsKey(num + 1)){
                longest = Math.max(longest, countForNum.get(num + 1) + countForNum.get(num));
            }
        }
        return longest;
    }
}
