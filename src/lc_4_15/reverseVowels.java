package lc_4_15;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;

/**
 * 反转字符串中的元音字符
 * @author superquanbin@gmail.com
 * @date 2020-04-15 11:04
 */
public class reverseVowels {
    private static final HashSet<Character> vowels = new HashSet<>(
            Arrays.asList('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'));

    // 方法1：
    // 双指针法
    public static String reverseVowels(String s){
        if(s == null)
            return null;
        int i = 0;
        int j = s.length() - 1;
        char[] result = new char[s.length()];
        while(i <= j){
            char ci = s.charAt(i);
            char cj = s.charAt(j);
            if(!vowels.contains(ci)){
                result[i++] = ci;
            }else if(!vowels.contains(cj)){
                result[j--] = cj;
            }else{
                result[i++] = cj;
                result[j--] = ci;
            }
        }
        return new String(result);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        String ans = reverseVowels(s);
        System.out.println(ans);
    }
}
