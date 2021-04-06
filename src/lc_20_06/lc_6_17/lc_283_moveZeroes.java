package lc_20_06.lc_6_17;

/**
 * 把数组中的0移动到末尾
 * @author superquanbin@gmail.com
 * @date 2020-06-17 15:09
 */
public class lc_283_moveZeroes {

    public void moveZeroes(int[] nums) {
        int idx = 0;
        for(int num : nums){
            if(num != 0){
                nums[idx++] = num;
            }
        }
        while(idx < nums.length){
            nums[idx++] = 0;
        }
    }

    public static void main(String[] args) {

    }
}
