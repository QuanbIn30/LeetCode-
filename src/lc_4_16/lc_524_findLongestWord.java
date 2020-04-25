package lc_4_16;

import java.util.LinkedList;
import java.util.List;

/**
 *
 * 最长子序列
 * 题目描述：删除s中的一些字符，使得它构成字符串列表d中一个字符串，找出能构成的最长字符串。
 * 如果有多个相同的结果，返回字典序最小的字符串
 * @author superquanbin@gmail.com
 * @date 2020-04-16 21:16
 */
public class lc_524_findLongestWord {
    public static String findLongestWord(String s, List<String> d){

        String longestWord = "";

        for(String target : d){
            int l1 = longestWord.length();
            int l2 = target.length();
            if(l1 > l2 || (l1 == l2 && longestWord.compareTo(target) < 0)){
                continue;
            }

            if(isSubstr(s, target)){
                longestWord = target;
            }

        }
        return longestWord;
    }

    private static boolean isSubstr(String s, String target){
        int i = 0;
        int j = 0;
        while(i < s.length() && j < target.length()){
            if(s.charAt(i) == target.charAt(j)){
                j++;
            }
            i++;
        }
        return j == target.length();
    }
}
