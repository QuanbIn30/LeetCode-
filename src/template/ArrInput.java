package template;

import java.util.Scanner;

/**
 *
 * Java输入不知道长度的数组
 * @author superquanbin@gmail.com
 * @date 2020-04-16 12:22
 */
public class ArrInput {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] nums = null;
        nums = sc.nextLine().split(" ");
        int num[] = new int[nums.length];
        for (int i = 0; i < num.length; i++){
            num[i] = Integer.valueOf(nums[i]);
        }
        System.out.println(printArr(num));
    }
    public static String printArr(int[] arr){
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (int i = 0; i < arr.length; i++){
            sb.append(arr[i] + ", ");
        }
        sb.append("]");
        return sb.toString();
    }
}
