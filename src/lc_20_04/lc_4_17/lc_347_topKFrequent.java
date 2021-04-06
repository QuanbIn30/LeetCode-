package lc_20_04.lc_4_17;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 出现频率最多的k个元素
 * @author superquanbin@gmail.com
 * @date 2020-04-17 15:34
 */
public class lc_347_topKFrequent {

    // 方法1：
    // 同排序
    public List<Integer> topKFrequent1(int[] nums, int k) {
        Map<Integer, Integer> frequencyForNum = new HashMap<>();
        for(int num : nums){
            frequencyForNum.put(num, frequencyForNum.getOrDefault(num,0) + 1);
        }
        List<Integer>[] buckets = new ArrayList[nums.length + 1];

        for(int key : frequencyForNum.keySet()){
            int frequency = frequencyForNum.get(key);
            if(buckets[frequency] == null){
                buckets[frequency] = new ArrayList<>();
            }
            buckets[frequency].add(key);
        }
        List<Integer> topk = new ArrayList<>();
        for(int i = buckets.length - 1; i >= 0 && topk.size() < k; i--){
            if(buckets[i] == null){
                continue;
            }
            if(buckets[i].size() <= (k - topk.size())){
                topk.addAll(buckets[i]);
            }else{
                topk.addAll(buckets[i].subList(0,k - topk.size()));
            }
        }
        return topk;
    }
}
