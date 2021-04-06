package lc_20_09.lc_9_8;

/**
 * 寻找旋转排序数组中的最小值
 * @author MHLEVEL
 * @date 2020-09-08 19:50
 */
public class lc_153_findMin {

    // 方法1
    public static int findMin(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] > nums[right]) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return nums[left];
    }

    // 方法2
    public static int findMin2(int[] nums) {
        int len = nums.length;
        if (len == 0) {
            throw new IllegalArgumentException("数组为空，无最小元素");
        }
        int left = 0;
        int right = len - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            // int mid = (left + right) >>> 1;
            if (nums[mid] > nums[right]) {
                left = mid + 1;
            } else {
                // 因为题目中说：你可以假设数组中不存在重复元素。
                // 此时一定有 nums[mid] < nums[right]
                right = mid;
            }
        }
        // 一定存在最小元素，因此无需再做判断
        return nums[left];
    }

    public static void main(String[] args) {
        int[] arr = new int[]{4,5,6,7,1,2};
//        System.out.println(findMin(arr));
        System.out.println(findMin2(arr));
    }

}