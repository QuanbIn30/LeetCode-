package lc_20_04.lc_4_19;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * 分隔字符串使同种字符出现在一起
 * @author superquanbin@gmail.com
 * @date 2020-04-19 21:34
 */
public class lc_763_partitionLabels {
    public static List<Integer> partitionLabels (String S){
        // 定义一个长度为26的数组
        int[] lastIndexsOfChar = new int[26];

        // 遍历字符串将字符串中的每个字符在原字符串中最后一次出现的索引存在lastIndexsOfChar[]数组中该字符按照字典序排序的索引处
        for (int i = 0; i < S.length(); i++){
            lastIndexsOfChar[char2Index(S.charAt(i))] = i;
        }

        // 定义一个存放整数类型的链表
        List<Integer> partitions = new ArrayList<>();

        int firstIndex = 0;
        while(firstIndex < S.length()){
            int lastIndex = firstIndex;
            for(int i = firstIndex; i < S.length() && i <= lastIndex; i++){
                int index = lastIndexsOfChar[char2Index(S.charAt(i))];
                if(index > lastIndex){
                    lastIndex = index;
                }
            }
            partitions.add(lastIndex - firstIndex + 1);
            firstIndex = lastIndex + 1;
        }
        return partitions;
    }

    private static int char2Index(char c){
        return c - 'a';
    }

    private static String printList(List<Integer> list){
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for(int i = 0; i < list.size(); i++){
            sb.append(list.get(i) + " ");
        }
        sb.append("]");
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println("please input a string~");
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        List<Integer> ans = partitionLabels(str);
        String res = printList(ans);
        System.out.println(res);
    }
}
