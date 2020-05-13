package lc_5_12;

import java.util.HashMap;
import java.util.Map;

/**
 * 最长回文串
 * @author superquanbin@gmail.com
 * @date 2020-05-12 21:11
 */
public class lc_409_longestPalindrome {
    // 方法1
    public int longestPalindrome1(String s){
        Map<Character, Integer> cnts = new HashMap<>();
        for(char c : s.toCharArray()){
            if(cnts.containsKey(c)){
                cnts.put(c, cnts.get(c) + 1);
            }else{
                cnts.put(c, 1);
            }
        }
        int len = 0;
        for(char n : cnts.keySet()){
            if(cnts.get(n) % 2 == 0){
                int tmp = cnts.get(n);
                len += tmp;
            }
            if(cnts.get(n) > 2 && cnts.get(n) % 2 == 1){
                int tmp2 =  cnts.get(n) - 1;
                len += tmp2;
            }
        }
        return len == s.length() ? len : len + 1;
    }

    // 方法2
    public int longestPalindrome2(String s){
        int[] cnts = new int[256];
        for(char c : s.toCharArray()){
            cnts[c]++;
        }
        int len = 0;
        for(int n : cnts){
            len += (n / 2) * 2;
        }
        if(len < s.length()){
            len++;
        }
        return len;
    }

    // 贴一个比较优秀的代码风格，代码思路同方法2
    public int longestPalindrome3(String s) {
        int[] cnt = new int[58];
        for (char c : s.toCharArray()) {
            cnt[c - 'A'] += 1;
        }

        int ans = 0;
        for (int x: cnt) {
            // 字符出现的次数最多用偶数次。
            ans += x - (x & 1);
        }
        // 如果最终的长度小于原字符串的长度，说明里面某个字符出现了奇数次，那么那个字符可以放在回文串的中间，所以额外再加一。
        return ans < s.length() ? ans + 1 : ans;
    }

    public static void main(String[] args) {
        lc_409_longestPalindrome tc = new lc_409_longestPalindrome();
        String s = "abccccdd";
        int res = tc.longestPalindrome1(s);
        System.out.println(res);
    }
}
