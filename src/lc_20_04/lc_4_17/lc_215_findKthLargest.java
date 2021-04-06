package lc_20_04.lc_4_17;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

/**
 *
 * 数组中的第k个最大元素
 * @author superquanbin@gmail.com
 * @date 2020-04-17 10:34
 */
public class lc_215_findKthLargest {

    // 方法1：
    // 排序
    public static int findKthLargest1(int[] nums, int k){
        Arrays.sort(nums);
        return nums[nums.length - k];
    }

    // 方法2：
    // 堆
    public static int findKthLargest2(int[] nums, int k){
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int val : nums){
            pq.add(val);
            if(pq.size() > k){
                pq.poll();
            }
        }
        return pq.peek();
    }

    // 方法3：
    // 利用快速选择的partition过程
    // 时间复杂度O(N),空间复杂度O(1)
    public static int findKthLargest3(int[] nums, int k){

        k = nums.length - k;
        int l = 0;
        int h = nums.length - 1;
        while(l < h){
            // 第一次partition之后得到的j = 3
            int j = partition(nums,l,h);
            if(j == k){
                break;
            }else if(j < k){
                l = j + 1;
            }else{
                h = j - 1;
            }
        }
        return nums[k];
    }

    private static int partition(int[] a, int l, int h){
        int i = l;
        int j = h + 1;
        while(true){
            while(a[++i] < a[l] && i < h);
            while(a[--j] > a[l] && j > l);
            if(i >= j)
                break;
            swap(a,i,j);
        }
        swap(a,l,j);
        return j;
    }

    private static void swap(int[] arr, int i, int j){
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    public static void main(String[] args) {
        System.out.println("please input array's element and split by space");
        // 这里的Java输入不确定长度的数组的方法是"字符串数组转换为整型数组"
        Scanner sc = new Scanner(System.in);
        String[] nums = null;
        nums = sc.nextLine().split(" ");
        int[] num = new int[nums.length];
        for(int i = 0; i < num.length; i++)
            num[i] = Integer.valueOf(nums[i]);

        int ans = findKthLargest3(num,2);
        System.out.println(ans);
    }

}
