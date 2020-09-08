package geektimePre;

/**
 * 查找最后一个值等于给定值的元素
 * @author MHLEVEL
 * @date 2020-09-08 11:00
 */
public class _16_binarySearch_2 {

    public static int bsearch(int[] a, int n, int value){
        int low = 0;
        int high = n - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (a[mid] < value) {
                low = mid + 1;
            } else if (a[mid] > value) {
                high = mid - 1;
            } else {
                if(mid == n - 1 || a[mid + 1] != value) {
                    return mid;
                } else {
                    low = mid + 1;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{2,33,33,45,98,101,102,102,102,130};
        System.out.println(bsearch(arr, arr.length, 102));
    }
}
