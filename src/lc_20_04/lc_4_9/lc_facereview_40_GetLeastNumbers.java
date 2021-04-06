package lc_20_04.lc_4_9;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;
import java.util.PriorityQueue;

/**
 *
 * 最小的k个数
 * @author superquanbin@gmail.com
 * @date 2020-04-09 08:47
 */
public class lc_facereview_40_GetLeastNumbers {

    public static int[] getLeastNumbers(int[] arr, int k){

        PriorityQueue<Integer> q = new PriorityQueue<>(new numComparator());
        for (int i = 0; i < arr.length; i++){
            if(q.isEmpty() || q.size() < k){
                q.add(arr[i]);
            }else if(arr[i] < q.peek()){
                q.poll();
                q.add(arr[i]);
            }
        }
        int[] res = new int[k];
        int i = 0;
        while(!q.isEmpty()){
            res[i++] = q.poll();
        }

        return res;
    }

    public static class numComparator implements Comparator<Integer>{

        @Override
        public int compare(Integer o1, Integer o2) {
            return o1 - o2;
        }
    }

    public static String printArr (int[] arr) {

        int len = arr.length;
        if(len < 0 || arr == null){
            return " ";
        }
        StringBuilder sb = new StringBuilder();
        int i = 0;
        sb.append("[");
        for (int j = 0; j < len; j++) {
            sb.append(" " + arr[i]);
        }
        sb.append(" ]");
        return sb.toString();
    }

    public static void main(String[] args) {

        int arrLength = 8;
        int[] a = new int[arrLength];
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入8个数字作为数组arr的元素，并已回车结束~");
        for (int i = 0; i < a.length; i++){
            a[i] = sc.nextInt();
        }
        int[] ans = getLeastNumbers(a,3);
        System.out.println(Arrays.toString(ans));

    }
}
