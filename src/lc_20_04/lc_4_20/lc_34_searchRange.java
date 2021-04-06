package lc_20_04.lc_4_20;

/**
 * 查找区间
 * @author superquanbin@gmail.com
 * @date 2020-04-20 10:59
 */
public class lc_34_searchRange {
    public static int[] searchRange(int[] nums, int target){
        int first = findFirst(nums, target);
        int last = findFirst(nums,target + 1) - 1;
        if(first == nums.length || nums[first] != target){
            return new int[]{-1, -1};
        }else{
            return new int[]{first, Math.max(first,last)};
        }
    }

    private static int findFirst(int[] nums, int target){
        int l = 0;
        int h = nums.length;
        while(l < h){
            int m = l + (h - l) / 2;
            if(nums[m] >= target){
                h = m;
            }else{
                l = m + 1;
            }
        }
        return l;
    }

}
