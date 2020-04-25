package lc_4_19;

/**
 * 非递减数列
 * @author superquanbin@gmail.com
 * @date 2020-04-19 18:34
 */
public class lc_665_checkPossibility {

    public static boolean checkPossibility(int[] nums){
        // 声明一个变量记录数组改变了多少次
        int cnt = 0;

        // 遍历数组
        for(int i = 1; i < nums.length && cnt < 2; i++){
            if(nums[i] >= nums[i - 1]){
                continue;
            }
            cnt++;
            if(i - 2 >= 0 && nums[i - 2] > nums[i]){
                nums[i] = nums[i - 1];
            }else{
                nums[i - 1] = nums[i];
            }
        }
        return cnt <= 1;
    }
}
