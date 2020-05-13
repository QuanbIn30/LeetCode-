package lc_5_12;

/**
 * @author superquanbin@gmail.com
 * @date 2020-05-12 20:57
 */
public class lc_242_isAnagram {

    public boolean isAnagram (String s, String t){
        // 先建一个长度为26的数组，用来对应26个小写字母的位置
        int[] cnts = new int[26];
        // 然后巧妙的地方来了！
        // 先遍历一个字符串，把字符串当中出现的元素对应的出现次数在数组cnts上改了，
        // 这边是增加
        for(char c : s.toCharArray()){
            cnts[c - 'a']++;
        }
        // 接着遍历另一个字符串，把这个字符串中出现的元素对应的出现次数在数组上改了
        // 注意！！ 这是减少
        for(char c : t.toCharArray()){
            cnts[c - 'a']--;
        }
        // 然后如果数组中还存在不为0的元素的话，则说明了两边字符串的含有的字符（包括字符出现的次数）不是完全相同
        for(int n : cnts){
            if(n != 0){
                return false;
            }
        }
        return true;
    }
}
