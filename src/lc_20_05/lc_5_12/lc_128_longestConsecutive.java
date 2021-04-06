package lc_20_05.lc_5_12;

import java.util.HashMap;
import java.util.Map;

/**
 * 最长的连续序列
 * @author superquanbin@gmail.com
 * @date 2020-05-12 20:22
 */
public class lc_128_longestConsecutive {

    public int longestConsecutive(int[] nums){
        // 先利用一个map集合初始化数组中所有元素的连续序列为1
        Map<Integer, Integer> countForNum = new HashMap<>();
        for(int num : nums){
            countForNum.put(num, 1);
        }
        // 然后对数组中的元素，在map集合中一个一个的去修改它对应的值（即最长子序列的长度）
        for(int num : nums){
            forward(countForNum, num);
        }
        // 然后从修改过的map集合中找出拥有最长的子序列的键对应的值
        return maxCount(countForNum);
    }

    // 这就是修改map集合中每个数组元素对应的连续序列的长度
    public int forward(Map<Integer, Integer> countForNum, int num){
        // 我先看下我自己在map集合中是不是存在
        if(!countForNum.containsKey(num)){
            return 0;
        }
        // 然后把我自己对应的最长子序列的值取出来，准备盘它，哦不，改他～
        int cnt = countForNum.get(num);
        // 下面这个if判断的作用相当于把如果是已经判断过的直接返回，给上一步加上去，这样可以节省时间，避免重复计算
        if(cnt > 1){
            return cnt;
        }
        // 这就是不断的看我的自然数上相邻的下一个在不在这个map集合中，
        // 这个 +1 其实是加的我自己这个数，因为往后可能是无限多的，所以就是相当于把我自己带上，去后面探索还有多少相邻的子序
        cnt = forward(countForNum, num + 1) + 1;
        countForNum.put(num, cnt);
        return cnt;
    }
    // 然后从修改过后的map集合中找出数组元素对应的最长的连续序列
    private int maxCount(Map<Integer, Integer> countForNum){
        int max = 0;
        for(int num : countForNum.keySet()){
            max = Math.max(max, countForNum.get(num));
        }
        return max;
    }
}
