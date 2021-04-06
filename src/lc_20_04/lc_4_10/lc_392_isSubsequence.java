package lc_20_04.lc_4_10;

import java.util.List;
import java.util.Map;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * 判断子序列
 * @author superquanbin@gmail.com
 * @date 2020-04-10 11:40
 */
public class lc_392_isSubsequence {

    // 方法1：
    // 双指针法
    public static boolean isSubsequence1(String s, String t){

        char[] S = s.toCharArray();
        char[] T = t.toCharArray();
        int i = 0;
        int j = 0;
        int m = S.length;
        int n = T.length;

        while(i < m && j < n){
            if (S[i] == T[j]){
                i++;
                j++;
            }else
                j++;
        }
        return i == m;
    }

    // 方法2：
    // public int indexOf(int ch, int fromIndex):
    // 返回从 fromIndex 位置开始查找指定字符在字符串中第一次出现处的索引，如果此字符串中没有这样的字符，则返回 -1。
    public static boolean isSubsequence2(String s, String t){

        char[] arr = s.toCharArray();

        int j = -1;
        for (int i = 0; i < arr.length; i++) {
            j = t.indexOf(arr[i],j + 1);
            if (j == -1)
                return false;
        }
        return true;
    }

    // 后续：
    // 如果有大量输入的 S，称作S1, S2, ... , Sk 其中 k >= 10亿，你需要依次检查它们是否为 T 的子序列。在这种情况下，你会怎样改变代码？
    // 首先对长字符串t进行预处理生成易于搜索的内容来提高效率，将t中出现的所有的字母的下标存储在map中，
    // key : character字符串  value : List所有出现的下标
    public static boolean isSubsequence3(String s, String t){

        if(s == null || t == null)
            return false;

        Map<Character, List<Integer>> map = new HashMap<>(); // <character , index>

        // 处理t
        for (int i = 0; i < t.length(); i++) {
            // 得到i索引处的字符
            char curr = t.charAt(i);
            // 判断如果当前字符在map中不存在则将其加入进去
            if(!map.containsKey(curr)){
                map.put(curr, new ArrayList<Integer>());
            }
            // 如果当前字符在map中存在则把当前索引i添加进当前字符在map中对应的值list中
            map.get(curr).add(i);
        }

        int prev = -1; // 前一个字符的下标
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(map.get(c) == null){
                return false;
            }else{
                List<Integer> list = map.get(c);
                prev = binarySearch(prev,list,0,list.size() - 1);
                if (prev == -1)
                    return false;
                prev++;
            }
        }
        return true;
    }

    public static int binarySearch(int index, List<Integer> list, int start, int end){
        while(start <= end){
            int mid = start + (end - start) / 2;
            if(list.get(mid) < index)
                start = mid + 1;
            else
                end = mid - 1;
        }
        return start == list.size() ? -1 : list.get(start);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("please input a string line");
        String s = sc.nextLine();
        System.out.println("please input another string line");
        String t = sc.nextLine();
//        boolean flag = isSubsequence1(s,t);
        boolean flag = isSubsequence2(s,t);
//        boolean flag = isSubsequence3(s,t);
        System.out.println(flag);
    }
}
