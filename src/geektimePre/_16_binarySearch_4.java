package geektimePre;

/**
 * 查找最后一个小于等于给定值的元素
 * @author MHLEVEL
 * @date 2020-09-08 11:01
 */
public class _16_binarySearch_4 {

    public int bsearch(int[] a, int n, int value){
        int low = 0;
        int high = n - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if(a[mid] > value){
                high = mid - 1;
            } else {
                if(mid == n - 1 || a[mid + 1] > value)
                    return mid;
                else{
                    low = mid + 1;
                }
            }
        }
        return -1;
    }
}
