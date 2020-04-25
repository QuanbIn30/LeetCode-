package exam; /**
 * @author superquanbin@gmail.com
 * @date 2020-04-10 19:02
 */

import java.util.Scanner;

/**
 * 已知包含 n 个元素的整数数组（可能包含负数），
 * 设计算法找出一个连续子序列 A(i)...A(j)，使其元素之和最大。
 */
public class bianlifeng {

    public static int solution(int[] arr){

        int i = 0, j = 2;
        int tmp = 0;
        int sum = 0;

        if(arr == null || arr.length == 0){
            return 0;
        }

        if(arr.length <= 3){

            for (int m = 0; m < arr.length; m++) {
                sum += arr[i];
            }
            return sum;
        }

        while(j < arr.length){
            for (int k = i; k <= j; k++) {
                tmp += arr[k];
            }
            sum = Math.max(sum,tmp);
            i++;
            j++;
            tmp = 0;
        }

        return sum;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] arr = new int[1];
        int[] tmp = new int[1];
        while(sc.hasNextInt()){
             tmp = new int[arr.length + 1];
            for (int i = 0; i < arr.length; i++) {
                tmp[i] = arr[i];
            }
            tmp[arr.length] = sc.nextInt();
            arr = tmp;
        }
        int res = solution(arr);
        System.out.println(res);
    }
}
