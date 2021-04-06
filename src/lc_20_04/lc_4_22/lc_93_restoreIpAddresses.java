package lc_20_04.lc_4_22;

import java.util.ArrayList;
import java.util.List;

/**
 * @author superquanbin@gmail.com
 * @date 2020-04-22 22:34
 */
public class lc_93_restoreIpAddresses {

    // 方法1：
    public List<String> restoreIpAddresses1(String s){
        List<String> addresses = new ArrayList<>();
        StringBuilder tempAddress = new StringBuilder();
        doRestore(0, tempAddress, addresses, s);
        return addresses;
    }

    private void doRestore(int k, StringBuilder tempAddress, List<String> addresses, String s){
        if(k == 4 || s.length() == 0){
            if(k == 4 && s.length() == 0){
                addresses.add(tempAddress.toString());
            }
            return;
        }
        for(int i = 0; i < s.length() && i <= 2; i++){
            if(i != 0 && s.charAt(0) == '0'){
                break;
            }
            String part = s.substring(0, i + 1);
            if(Integer.valueOf(part) <= 255){
                if(tempAddress.length() != 0){
                    part = "." + part;
                }
                tempAddress.append(part);
                doRestore(k + 1, tempAddress, addresses, s.substring(i + 1));
                tempAddress.delete(tempAddress.length() - part.length(), tempAddress.length());
            }
        }
    }


    // 方法2：摘自leetcode-93-讨论区-"早先生"
    public List<String> restoreIpAddresses2(String s) {
        if (s == null || s.length() < 4) return new ArrayList<>();

        List<String> result = new ArrayList<>();
        restoreIpAddresses(s, 0, new ArrayList<>(), result);
        return result;
    }

    public void restoreIpAddresses(String s, int index, List<String> list, List<String> result) {
        // 预期结果能有的最大长度 最多能有4格，每个3位。 list是已占有的格数
        int maxLength = (4 - list.size()) * 3;
        // 如果原字符串剩余字符 大于预期最大长度 不符合要求
        if (s.length() - index > maxLength) {
            return;
        }
        // 满足条件
        if (list.size() == 4 && s.length() == index) {
            // 拼接处结果
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < list.size(); i++) {
                if (i == 0)
                    sb.append(list.get(i));
                else
                    sb.append(".").append(list.get(i));
            }
            result.add(sb.toString());
        }
        for (int i = index + 1; i <= index + 3 && i <= s.length(); i++) {
            String ip = s.substring(index, i);
            // 大于255 不符合ip规则
            if (Integer.parseInt(ip) > 255)
                continue;
            // 大于1位数时 0不能为头
            if (ip.length() > 1 && "0".equals(ip.substring(0 , 1)))
                continue;
            list.add(ip);
            restoreIpAddresses(s, i, list, result);
            list.remove(list.size() - 1);
        }
    }


    // 方法3：摘自leetcode-93-题解-官方题解的评论-"DeerHunter"
    /**
     * 回溯法
     */
    public static class Solution1 {
        private List<String> results;
        private StringBuilder sb;
        private char[] chars;

        public List<String> restoreIpAddresses(String s) {
            results = new ArrayList<>();
            sb = new StringBuilder();
            chars = s.toCharArray();
            dfs(0, 0);
            return this.results;
        }

        /**
         * 回溯查找可能的ip数字
         *
         * @param count 当前已经确定的数字
         * @param i     下一个待处理的字符下标
         */
        private void dfs(int count, int i) {
            // 找到了4个数字，并且字符刚好用完，标志着我们找到了一个解
            if (count == 4 && i == chars.length) {
                results.add(sb.toString());
                return;
            }

            int remainCount = 4 - count;
            int remainsChars = chars.length - i;
            // 判断剩余的字符是否有解
            if (remainCount > remainsChars || remainCount * 3 < remainsChars) {
                return;
            }

            int len = sb.length();
            // 不允许出现以0开头的多位数
            int maxLen = chars[i] == '0' ? 1 : 3;
            for (int j = 0; j < maxLen && i + j < chars.length; j++) {
                // 取三位数时，需要判断是否超出255
                if (j == 2 && (chars[i] - '0') * 100 + (chars[i + 1] - '0') * 10 + chars[i + 2] - '0' > 255) {
                    continue;
                }
                for (int k = 0; k <= j; k++) {
                    sb.append(chars[i + k]);
                }
                // 第四个数字后面不需要加点
                if (count < 3) {
                    sb.append('.');
                }
                dfs(count + 1, i + j + 1);
                // 因为第四个数字后面不需要加点，回溯时少删除一位
                sb.delete(len, count < 3 ? len + j + 2 : len + j + 1);
            }
        }
    }
}
