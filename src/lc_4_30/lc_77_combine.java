package lc_4_30;

import java.util.ArrayList;
import java.util.List;

/**
 * @author superquanbin@gmail.com
 * @date 2020-04-30 08:16
 */
public class lc_77_combine {

    // 方法1：回溯法
    public List<List<Integer>> combine1(int n, int k){
        // 定义一个存放最终结果集的链表
        List<List<Integer>> combinations = new ArrayList<>();
        // 定义一个临时存放结果集的链表
        List<Integer> combineList = new ArrayList<>();
        backtracking1(combineList, combinations, 1, k, n);
        return combinations;
    }

    private void backtracking1 (List<Integer> combineList, List<List<Integer>> combinations, int start, int k, final int n){
        // 如果k等于0的话，那么临时结果集中的数满足题目条件的k，可以把它存进最终结果集中并返回
        if(k == 0){
            combinations.add(new ArrayList<>(combineList));
            return;
        }
        // 这个i <= n - k + 1是什么原因呢？？
        for(int i = start; i <= n - k + 1; i++){
            combineList.add(i);
            backtracking1(combineList,combinations, i + 1, k - 1, n);
            combineList.remove(combineList.size() - 1);
        }
    }


    // 方法2：和方法1一样是回溯法，只是代码有些许不同
    List<List<Integer>> combineres = new ArrayList<>();
    int k;
    int n;
    public List<List<Integer>> combine2(int n, int k){
        List<Integer> combinetmp = new ArrayList<>();
        this.k = k;
        this.n = n;
        backtracking2(1, combinetmp);
        return combineres;
    }

    private void backtracking2(int first, List<Integer> combinetmp){
        if(combinetmp.size() == k){
            combineres.add(new ArrayList<>(combinetmp));
            return;
        }
        for (int i = first; i < n + 1; ++i) {
            combinetmp.add(i);
            backtracking2(i + 1, combinetmp);
            combinetmp.remove(combinetmp.size() - 1);
        }
    }


    public static void main(String[] args) {
        lc_77_combine testclass = new lc_77_combine();
        int n = 4;
        int k = 3;
//        List<List<Integer>> res = testclass.combine1(n, k);
        List<List<Integer>> res = testclass.combine2(n, k);
        System.out.println(res);
    }
}
