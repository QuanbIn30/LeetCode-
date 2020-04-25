package lc_4_19;

import java.util.*;

/**
 * 根据身高和序号重组队列
 *
 * 为了使插入操作不影响后续的操作，身高较高的学生应该先做插入操作，
 * 否则身高较小的学生原先正确插入的第 k 个位置可能会变成第 k+1 个位置。
 *
 * 身高 h 降序、个数 k 值升序，然后将某个学生插入队列的第 k 个位置中。
 * @author superquanbin@gmail.com
 * @date 2020-04-19 12:50
 */
public class lc_406_reconstructQueue {

    // 方法1：
    public static int[][] reconstructQueue1(int[][] people){

        // 先判断输入的整数对是不是空
        if(people == null || people.length == 0 || people[0].length == 0){
            return new int[0][0];
        }

        Arrays.sort(people, (a,b) -> (a[0] == b[0] ? a[1] - b[1] : b[0] - a[0]));
        List<int[]> queue = new ArrayList<>();
        for(int[] p : people){
            queue.add(p[1],p);
        }
        return queue.toArray(new int[queue.size()][]);
    }

    // 方法2：(其实和方法1相同只是代码不一样)
    public static int[][] reconstructQueue2(int[][] people){

        // 将输入的整数对排序：
        // 如果身高一样则按照k值升序排序；
        // 如果身高不一样则按照身高降序排序
        Arrays.sort(people, new Comparator<int[]>(){
            @Override
            public int compare(int[] o1, int[] o2) {
                // if the heights are equals, compare k-value
                return o1[0] == o2[0] ? o1[1] - o2[1] : o2[0] - o1[0];
            }
        });

        // 然后声明一个存放数组元素的链表
        List<int[]> output = new LinkedList<>();

        // 遍历已经经过排序的整数对，按照k值所代表的索引位置将当前整数对存放在正确的索引处
        for(int[] p : people){
            output.add(p[1],p);
        }

        // 输出
        int n = people.length;
        return output.toArray(new int[n][2]);
    }
}
