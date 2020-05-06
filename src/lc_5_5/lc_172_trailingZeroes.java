package lc_5_5;

/**
 * 阶乘后的零
 * @author superquanbin@gmail.com
 * @date 2020-05-05 16:17
 */
public class lc_172_trailingZeroes {

    public int trailingZeroes(int n){
        int count = 0;
        while(n > 0){
            n = n / 5;
            count += n;

        }
        return count;
    }

    public static void main(String[] args) {
        int n = 125;
        lc_172_trailingZeroes tc = new lc_172_trailingZeroes();
        int res = tc.trailingZeroes(n);
        System.out.println(res);
    }
}
