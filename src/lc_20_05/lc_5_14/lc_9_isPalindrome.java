package lc_20_05.lc_5_14;

/**
 * 判断一个整数是不是回文数
 * @author superquanbin@gmail.com
 * @date 2020-05-14 10:35
 */
public class lc_9_isPalindrome {

    public boolean isPalindrome(int x){
        if (x == 0) {
            return true;
        }
        if (x < 0 || x % 10 == 0) {
            return false;
        }
        int right = 0;
        while (x > right) {
            right = right * 10 + x % 10;
            x /= 10;
        }
        return x == right || x == right / 10;
    }
}
