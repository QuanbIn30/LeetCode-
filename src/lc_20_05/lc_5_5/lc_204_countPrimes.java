package lc_20_05.lc_5_5;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 计数质数
 * 统计所有小于非负整数 n 的质数的数量。
 * @author superquanbin@gmail.com
 * @date 2020-05-05 09:00
 */
public class lc_204_countPrimes {

    // 方法1
    public int countPrimes1(int n){

        int result = 0;
        boolean[] b = new boolean[n];   // 初始化默认值都为 false，为质数标记
        if(2 < n) result++; // 如果大于 2 则一定拥有 2 这个质数

        for(int i = 3; i < n; i += 2){  // 从 3 开始遍历，且只遍历奇数
            if(!b[i]){  // 是质数
                for(int j = 3; i * j < n; j += 2){
                    b[i * j] = true;    // 将当前质数的奇数倍都设置成非质数标记 true
                }
                result++;   // 质数个数 +1
            }
        }
        return result;
    }

    // 方法2:厄拉多塞筛法（和方法1一样，只是代码有一点点不一样）
    public int countPrimes2(int n){
        boolean[] isPrim = new boolean[n];
        Arrays.fill(isPrim, true);
        for(int i = 2; i * i < n; i++){
            if(isPrim[i]){
                // 下面这个for循环的作用是把i的整数倍都标记为false
                for(int j = i * i; j < n; j += i){
                    isPrim[j] = false;
                }
            }
        }

        int count = 0;
        for(int i = 2; i < n; i++){
            if(isPrim[i])
                count++;
        }
        return count;
    }

    public static void main(String[] args) {
        lc_204_countPrimes tc = new lc_204_countPrimes();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
//        int res = tc.countPrimes1(n);
        int res = tc.countPrimes2(n);
        System.out.println(res);
    }

}
