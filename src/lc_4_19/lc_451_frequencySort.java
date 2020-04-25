package lc_4_19;

import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;

/**
 * 按照字符出现的次数对字符串进行排序
 * @author superquanbin@gmail.com
 * @date 2020-04-19 09:32
 */
public class lc_451_frequencySort {

    // 方法1：
    public static String frequencySort1(String s){

        // 将当前字符串拆分成字符数组并且用一个map集合存放起来，以字符为键，字符出现的频次为值
        Map<Character, Integer> frequencyForNum = new HashMap<>();
        for(char c : s.toCharArray())
            frequencyForNum.put(c, frequencyForNum.getOrDefault(c, 0) + 1);

        // 新建一个链表数组，数组索引值代表当前索引处存放的字符出现的频次
        List<Character>[] frequencyBucket = new ArrayList[s.length() + 1];
        for (char c : frequencyForNum.keySet()){
            int f = frequencyForNum.get(c);
            if(frequencyBucket[f] == null){
                frequencyBucket[f] = new ArrayList<>();
            }
            frequencyBucket[f].add(c);
        }

        // 将frequencyBucket数组从后往前遍历
        StringBuilder str = new StringBuilder();
        for(int i = frequencyBucket.length - 1; i >= 0; i--){
            if(frequencyBucket[i] == null){
                continue;
            }
            for(char c : frequencyBucket[i]){
                for(int j = 0; j < i; j++){
                    str.append(c);
                }
            }
        }
        return str.toString();
    }
}
