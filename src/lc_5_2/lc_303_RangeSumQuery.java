package lc_5_2;

/**
 * @author superquanbin@gmail.com
 * @date 2020-05-02 09:19
 */
public class lc_303_RangeSumQuery {

    // 方法1：暴力法
    /*
    int[] data;

    public lc_303_RangeSumQuery(int[] nums) {
        data = nums;
    }

    public int sumRange(int i, int j) {
        int temp = 0;
        for(int m = i; m < j; m++){
            temp += data[m];
        }
        return temp;
    }

     */

    // 方法2：
    /*
    // Pair.create()方法好像挂了
    private Map<Pair<Integer, Integer>, Integer> map  = new HashMap<>();
    public lc_303_RangeSumQuery(int[] nums){
        for (int i = 0; i < nums.length; i++) {
            int sum = 0;
            for (int j = i; j < nums.length; j++) {
                sum += nums[i];
                map.put(Pair.create(i, j), nums);
            }
        }
    }
    */

    // 方法3：缓存
    // sum[k] = nums[0... k - 1] 的累计和
    int[] sum;
    public lc_303_RangeSumQuery(int[] nums){
        sum = new int[nums.length + 1];
        for(int i = 0; i < nums.length; i++){
            sum[i + 1] = sum[i] + nums[i];
        }
    }

    public int sumRange(int i, int j){
        return sum[j + 1] - sum[i];
    }

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * int param_1 = obj.sumRange(i,j);
 */
}
