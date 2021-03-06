package lc_20_04.lc_4_15;

/**
 * @author superquanbin@gmail.com
 * @date 2020-04-15 11:48
 */

public class validPalindrome {

    public static boolean validPalindrome (String s){

        for (int i = 0, j = s.length() - 1; i < j; i++, j--){
            if (s.charAt(i) != s.charAt(j)){
                return isPalindrome(s,i,j-1) || isPalindrome(s,i+1,j);
            }
        }
        return true;
    }

    public static boolean isPalindrome(String s, int i, int j){
        while(i < j){
            if (s.charAt(i++) != s.charAt(j--)){
                return false;
            }
        }
        return true;
    }
}
