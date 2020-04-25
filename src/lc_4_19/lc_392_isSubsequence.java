package lc_4_19;

/**
 * @author superquanbin@gmail.com
 * @date 2020-04-19 18:10
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
            if(S[i] == T[j]){
                i++;
            }
            j++;
        }
        return i == m;
    }

    // 方法2：
    // 贪心算法
    public static boolean isSubsequence2(String s, String t){
        int index = -1;
        for(char c : s.toCharArray()){
            index = t.indexOf(c, index + 1);
            if(index == -1)
                return false;
        }
        return true;
    }
// int indexOf(String str, int fromIndex);
// 返回从 fromIndex 位置开始查找指定字符在字符串中第一次出现处的索引，
// 如果此字符串中没有这样的字符，则返回 -1。
// https://www.runoob.com/java/java-string-indexof.html

}


