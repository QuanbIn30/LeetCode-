package lc_20_04.lc_4_15;

/**
 *
 * 在一个有序数组中找到两个数其和为目标数并返回这两个数的下标
 * @author superquanbin@gmail.com
 * @date 2020-04-15 08:42
 */
public class towSum {

    public static int[] towSum(int[] arr, int target) {
        int i = 0;
        int j = arr.length - 1;
        while(i < j){
            if(arr[i] + arr[j] == target){
                return new int[]{i+1,j+1};
            }else if(arr[i] + arr[j] < target){
                i++;
            }else{
                j--;
            }
        }
        return null;
    }

    public static String printArr(int[] arr){
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (int i = 0; i < arr.length - 1; i++) {
            sb.append(arr[i] + ", ");
        }
        sb.append(arr[arr.length - 1]);
        sb.append("]");
        return sb.toString();
    }

    public static void main(String[] args) {
        int[] arr = new int[]{2,4,5,6,8,11,34};
        int[] res = towSum(arr,16);
        String ans = printArr(res);
        System.out.println(ans);
    }
}
