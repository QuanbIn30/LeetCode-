package exam; /**
 * @author superquanbin@gmail.com
 * @date 2020-04-10 19:46
 */


/**
 * 输入一个数组表示各个门店的车能走的距离，输出要用几辆车
 */
public class test {

    public static int solution(int[] arr){

        // 定义两个指针
        int i = 0;
        int j = 0;
        // 定义一个变量记录换了几次车
        int res = 0;
        // 定义一个临时数组来存当前这个区间
        int[] tmparr = new int[]{arr[0]};
        while(j < arr.length){
            int a = solution2(tmparr);
            i = j + 1;
            j = j + a;
            tmparr = new int[a];
            for (int k = i, m = 0; k <= j; k++, m++){
                tmparr[m] = arr[k];
            }
            res++;
        }
        return res;
    }

    public static int solution2(int[] arr){
        int tmp = 0;
        int res = 0;
        for (int i = 1; i <= arr.length; i++){
            tmp = arr[0] + i  - arr.length;
            res = Math.max(res,tmp);
        }
        return res;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{2,3,1,0,2,1,4,0,7,0,1,3,2,0,5,0};
        int res = solution(arr);
        System.out.println(res);
    }
}
