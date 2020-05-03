package lc_5_3;

/**
 * 等差数列划分
 * @author superquanbin@gmail.com
 * @date 2020-05-03 11:09
 */
public class lc_413_numberOfArithmeticSlices {

    // 方法1：
    public int numberOfArithmeticSlices1(int[] A){
        if(A == null || A.length == 0){
            return 0;
        }
        int n = A.length;
        int[] dp = new int[n];
        for(int i = 2; i < n; i++){
            if(A[i] - A[i - 1] == A[i - 1] - A[i - 2]){
                dp[i] = dp[i - 1] + 1;
            }
        }
        int total = 0;
        for(int cnt : dp){
            total += cnt;
        }
        return total;
    }

    // 方法2：暴力法
    public int numberOfArithmeticSlices2(int[] A){
        int count = 0;
        // 变量s控制的是子数组的起始位置
        for(int s = 0; s < A.length - 2; s++){
            int d = A[s + 1] - A[s];
            // 变量e控制的是子数组的长度
            for(int e = s + 2; e < A.length; e++){
                int i;
                // 对子数组长度和起始位置的控制就是在下面这个for循环实现的
                for(i = s + 1; i <= e; i++){
                    if(A[i] - A[i - 1] != d)
                        break;
                }
                if(i > e){
                    count++;
                }
            }
        }
        return count;
    }

    // 方法3：暴力法，对方法2的优化
    public int numberOfArithmeticSlices3(int[] A){
        int count = 0;
        // s 控制子数组的起始位置
        for(int s = 0; s < A.length - 2; s++){
            int d = A[s + 1] - A[s];
            // e 控制子数组的长度
            for(int e = s + 2; e < A.length; e++){
                if(A[e] - A[e - 1] == d){
                    count++;
                }else{
                    break;
                }
            }
        }
        return count;
    }

    // 方法4：递归
    //
    int sum = 0;
    public int numberOfArithmeticSlices4(int[] A){
        slice(A, A.length - 1);
        return sum;
    }

    public int slice(int[] A, int i){
        if(i < 2)
            return 0;
        int ap = 0;
        if(A[i] - A[i - 1] == A[i - 1] - A[i - 2]){
            ap = 1 + slice(A, i - 1);
            sum += ap;
        }else{
            slice(A, i - 1);
        }
        return ap;
    }

    // 方法5: 动态规划
    public int numberOfArithmeticSlices5(int[] A){
        // 新建一个dp数组，长度等于输入数组的长度
        // 这个dp数组用来记录包含当前遍历到的i元素的等差数列子数组有多少个
        int[] dp = new int[A.length];
        // 定义一个变量sum用来记录从索引0开始到当前i索引处长度的数组总共有多少个等差数列子数组
        int sum = 0;
        for(int i = 2; i < dp.length; i++){
            // 下面这个if()判断其实控制了每次的最基本的符合要求的等差数列子数组的长度
            // 相当是一个滑动窗口，至少控制了窗口里至少有三个元素
            if(A[i] - A[i - 1] == A[i - 1] - A[i - 2]){
                dp[i] = 1 + dp[i - 1];
                sum += dp[i];
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        lc_413_numberOfArithmeticSlices tc = new lc_413_numberOfArithmeticSlices();
        int[] arr = new int[]{1,2,3,4};
//        int res = tc.numberOfArithmeticSlices2(arr);
//        int res = tc.numberOfArithmeticSlices3(arr);
        int res = tc.numberOfArithmeticSlices4(arr);
        System.out.println(res);
    }
}
