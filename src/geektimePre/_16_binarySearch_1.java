package geektimePre;

/**
 * 查找第一个值等于给定值的元素
 * @author MHLEVEL
 * @date 2020-09-08 10:59
 */
public class _16_binarySearch_1 {

    public static int bsearch(int[] a, int n, int value){
        int low = 0;
        int high = n - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (a[mid] > value) {
                high = mid - 1;
            } else if (a[mid] < value) {
                low = mid + 1;
            } else {
                // 下面这一段判断是关键，如果mid等于0，则说明已经是数组的第一个数了，直接返回mid，
                // 如果 mid - 1 不等于value，那么说明 mid 前面的数比value小，a[mid] 就是第一个等于 value 的数。
                // 否则将 high 更新为mid - 1，同时新的区间更新为[low, mid - 1];
                if(mid == 0 || a[mid - 1] != value){
                    return mid;
                } else {
                    high = mid - 1;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{2,5,12,22,22,22,61,61,109};
        int index = bsearch(arr, arr.length, 61);
        System.out.println(index);
    }
}
