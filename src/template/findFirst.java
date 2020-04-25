package template;

/**
 * 在按升序排列的有序数组nums中找到目标值target在数组中第一次出现的索引
 * @author superquanbin@gmail.com
 * @date 2020-04-21 07:20
 */
public class findFirst {
    public int findFirst(int[] nums, int target){
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
