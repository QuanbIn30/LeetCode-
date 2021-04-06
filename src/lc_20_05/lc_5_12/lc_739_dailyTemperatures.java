package lc_20_05.lc_5_12;

import java.util.Stack;

/**
 * 每日温度
 * @author superquanbin@gmail.com
 * @date 2020-05-12 10:49
 */
public class lc_739_dailyTemperatures {

    // 方法1：针对每个温度值，依次向后搜索
    public int[] dailyTemperatures1(int[] T){
        int length = T.length;
        int[] result = new int[length];
        for(int i = 0; i < length; i++){
            int current = T[i];
            if(current < 100){
                for(int j = i + 1; j < length; j++){
                    if(T[j] > current){
                        result[i] = j - i;
                        break;
                    }
                }
            }
        }
        return result;
    }

    // 方法2：利用单调栈
    public int[] dailyTemperatures(int[] T) {
        // 定义一个栈用来存储数组的下标
        Stack<Integer> stack = new Stack<>();
        // 定义一个与传入的数组长度相同的数组，用来存放结果集
        int length = T.length;
        int[] result = new int[length];

        // 遍历数组的元素
        for (int i = 0; i < length; i++) {
            // 栈中不为空，且当前遍历到的元素大于栈顶元素
            while (!stack.isEmpty() && T[i] > T[stack.peek()]) {
                // 获取栈顶元素（注意，栈里存储的是数组的下表）
                int pre = stack.pop();
                // 这是将结果存入结果集的数组中
                result[pre] = i - pre;
            }
            // 然后要将当前遍历到的元素压入栈中
            stack.add(i);
        }
        return result;
    }
}
