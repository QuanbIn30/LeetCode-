package lc_4_20;

import java.util.Scanner;

/**
 * 有序数组的Single Element
 * @author superquanbin@gmail.com
 * @date 2020-04-20 09:42
 */
public class lc_540_singleNonDuplicate {

    public static int singleNonDuplicate (int[] nums){

        int l = 0;
        int h = nums.length - 1;
        while(l < h){
            int m = l + (h - l) / 2;
            if(m % 2 == 1){
                m--;
            }
            if(nums[m] == nums[m + 1]){
                l = m + 2;
            }else{
                h = m;
            }
        }
        return nums[l];
    }

    public static void main(String[] args) {
        System.out.println("please input array's element~");
        Scanner sc = new Scanner(System.in);
        String[] nums = null;
        nums = sc.nextLine().split(",");
        int[] num = new int[nums.length];
        for(int i = 0; i < num.length; i++){
            num[i] = Integer.valueOf(nums[i]);
        }
        int res = singleNonDuplicate(num);
        System.out.println(res);
    }
}
