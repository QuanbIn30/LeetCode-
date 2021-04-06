package lc_20_04.lc_4_20;

import java.util.Scanner;

/**
 * 求开方
 * @author superquanbin@gmail.com
 * @date 2020-04-20 08:37
 */
public class lc_69_mySqrt {

    public static int mySqrt(int x){
        if(x <= 1)
            return x;
        int l = 1;
        int h = x;
        while(l <= h){
            int mid = l + (h - l) / 2;
            int sqrt = x / mid;
            if(sqrt == mid){
                return mid;
            }else if(mid > sqrt){
                h = mid - 1;
            }else{
                l = mid + 1;
            }
        }
        return h;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        int res = mySqrt(num);
        System.out.println(res);
    }
}
