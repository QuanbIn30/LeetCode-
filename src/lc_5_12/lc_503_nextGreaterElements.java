package lc_5_12;

import java.util.Arrays;
import java.util.Stack;

/**
 * 下一个更大元素II
 * @author superquanbin@gmail.com
 * @date 2020-05-12 12:06
 */
public class lc_503_nextGreaterElements {

    public int[] nextGreaterElements(int[] nums){
        // 定义一个栈用来作为单调栈
        Stack<Integer> stack = new Stack<>();
        // 定义一个与传入的数组长度相同的数组，用来存放结果集
        int len = nums.length;
        int[] result = new int[len];
        Arrays.fill(result, -1);
        // 遍历数组
        for(int i = 0; i < len; i++){
            // 如果栈不为空，且当前遍历到的元素比栈顶元素要大，
            // 则将栈顶元素弹出，并且在它对应的结果集的位置存放当前遍历到的元素
            while(!stack.isEmpty() && nums[i] > nums[stack.peek()]){
                int pre = stack.pop();
                result[pre] = nums[i];
            }
            // 将当前遍历到的元素压入栈中
            stack.push(i);
        }
        while(!stack.isEmpty()) {
            int tmp = stack.pop();
            for (int i = 0; i < tmp; i++) {
                if (nums[i] > nums[tmp]) {
                    result[tmp] = nums[i];
                    break;
                }
            }
        }
        return result;
    }
}
