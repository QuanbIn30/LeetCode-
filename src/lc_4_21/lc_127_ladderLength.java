package lc_4_21;

import java.util.LinkedList;
import java.util.List;
import java.util.ArrayList;
import java.util.Queue;
import java.util.Set;
import java.util.HashSet;



/**
 * 最短单词路径
 *
 * 给定两个单词（beginWord 和 endWord）和一个字典，
 * 找到从 beginWord 到 endWord 的最短转换序列的长度。
 * 转换需遵循如下规则：
 * 1)每次转换只能改变一个字母。
 * 2)转换过程中的中间单词必须是字典中的单词。
 * @author superquanbin@gmail.com
 * @date 2020-04-21 08:14
 */
public class lc_127_ladderLength {
    // 方法1：BFS（广度优先搜索）
    public static int ladderLength1(String beginWord, String endWord, List<String> wordList){
        wordList.add(beginWord);
        int N = wordList.size();
        int start = N - 1;
        int end = 0;
        // 在wordList字符串链表中找到目标字符串的索引
        while(end < N && !wordList.get(end).equals(endWord)){
            end++;
        }
        if(end == N){
            return 0;
        }
        List<Integer>[] graphic = buildGraphic(wordList);
        return getShortestPath(graphic, start, end);
    }

    // 构建图
    private static List<Integer>[] buildGraphic(List<String> wordList){
        int N = wordList.size();
        List<Integer>[] graphic = new List[N];
        for(int i = 0; i < N; i++){
            graphic[i] = new ArrayList<>();
            for(int j = 0; j < N; j++){  // j < N 是因为wordList.get(i)要和wordList中所有的字符串对比看是否相连
                if(isConnect(wordList.get(i),wordList.get(j))){
                    graphic[i].add(j);  // 如果wordList.get(i)和wordList.get(j)相连的话就往wordList.get(i)处的链表后面添加wordList.get(j)
                }
            }
        }
        return graphic;
    }

    // 判断两个字符串是否相连（相连的条件是两个字符串只相差一个字符）
    private static boolean isConnect(String s1, String s2){
        int diffCnt = 0;
        for(int i = 0; i < s1.length() && diffCnt <= 1; i++){
            if(s1.charAt(i) != s2.charAt(i)){
                diffCnt++;
            }
        }
        return diffCnt == 1;
    }

    // 在传入的graphic中得到start位置的字符串转换为end位置的字符串的最短路径
    private static int getShortestPath(List<Integer>[] graphic, int start, int end){  // 传入的参数start是startWord在wordList中的索引，end就是endWord在wordList中的索引
        Queue<Integer>  queue = new LinkedList<>();
        boolean[] marked = new boolean[graphic.length];
        queue.add(start);
        marked[start] = true;
        int path = 1;
        while(!queue.isEmpty()){
            int size = queue.size();
            path++;
            while(size-- > 0){
                int cur = queue.poll();
                for(int next : graphic[cur]){
                    if(next == end){
                        return path;
                    }
                    if(marked[next]){
                        continue;
                    }
                    marked[next] = true;
                    queue.add(next);
                }
            }
        }
        return 0;
    }

    // 方法2：也是BFS，只是和方法1代码有些许不一样
    public static int ladderLength2(String beginWord, String endWord, List<String> wordList){
        if(!wordList.contains(endWord))
            return 0;

        Set<String> visited = new HashSet<>();
        Queue<String> queue = new LinkedList<>();
        queue.offer(beginWord);
        visited.add(beginWord);
        int count = 0;
        while(queue.size() > 0){
            int size = queue.size();
            ++count;
            for (int i = 0; i < size; i++) {
                String start = queue.poll();
                for(String s : wordList){
                    // 已经遍历过的不再重复遍历
                    if(visited.contains(s)){
                        continue;
                    }
                    // 不能转换的直接跳过
                    if(!canConvert(start, s)){
                        continue;
                    }
                    // 可以转换，并且可以转换成endWord的，则返回count
                    if(s.equals(endWord)){
                        return count + 1;
                    }
                    visited.add(s);
                    queue.add(s);
                }
            }
        }
        return 0;
    }

    private static boolean canConvert(String s1, String s2){
        if(s1.length() != s2.length())
            return false;
        int count = 0;
        for (int i = 0; i < s1.length(); i++) {
            if(s1.charAt(i) != s2.charAt(i)){
                count++;
            }
        }
        return count == 1;
    }

    // 方法3：
    // 这是方法2的第一个优化版本：
    // 将作为标记作用的visited从hashSet改为boolean数组，通过index判断是否以访问
    public static int ladderLength3(String beginWord, String endWord, List<String> wordList){
        if(!wordList.contains(endWord))
            return 0;
        // visited修改为boolean数组
        boolean[] visited = new boolean[wordList.size()];
        int idx = wordList.indexOf(beginWord);
        if(idx != -1){
            visited[idx] = true;
        }
        Queue<String> queue = new LinkedList<>();
        queue.offer(beginWord);
        int count = 0;
        while(queue.size() > 0){
            int size = queue.size();
            ++count;
            while(size-- > 0){
                String start = queue.poll();
                for(int i = 0; i < wordList.size(); ++i){
                    // 通过index判断是否已访问
                    if(visited[i] == true){
                        continue;
                    }
                    String s = wordList.get(i);
                    if(!canConvert(start,s)){
                        continue;
                    }
                    if(s.equals(endWord)){
                        return count + 1;
                    }
                    visited[i] = true;
                    queue.offer(s);
                }
            }
        }
        return 0;
    }


    // 方法4：
    // 双向BFS
    public static int ladderLength4(String beginWord, String endWord, List<String> wordList){
        int end = wordList.indexOf(endWord);
        if(end == -1){
            return 0;
        }
        wordList.add(beginWord);
        int start = wordList.size() - 1;
        // 用于BFS遍历的队列
        Queue<Integer> queue1 = new LinkedList<>();
        Queue<Integer> queue2 = new LinkedList<>();
        // 用于保存已访问的单词
        Set<Integer> visited1 = new HashSet<>();
        Set<Integer> visited2 = new HashSet<>();
        queue1.offer(start);
        queue2.offer(end);
        visited1.add(start);
        visited2.add(end);
        int count1 = 0;
        int count2 = 0;
        while(!queue1.isEmpty() && !queue2.isEmpty()){
            count1++;
            int size1 = queue1.size();
            while(size1-- > 0){
                String s = wordList.get(queue1.poll());
                for (int i = 0; i < wordList.size(); ++i) {
                    if(visited1.contains(i)){
                        continue;
                    }
                    if(!canConvert(s,wordList.get(i))){
                        continue;
                    }
                    if(visited2.contains(i)){
                        return count1 + count2 + 1;
                    }

                    visited1.add(i);
                    queue1.offer(i);
                }
            }

            count2++;
            int size2 = queue2.size();
            while(size2-- > 0){
                String s = wordList.get(queue2.poll());
                for(int i = 0; i < wordList.size(); ++i){
                    if(visited2.contains(i)){
                        continue;
                    }
                    if(!canConvert(s, wordList.get(i))){
                        continue;
                    }
                    if(visited1.contains(i)){
                        return count1 + count2 + 1;
                    }
                    visited2.add(i);
                    queue2.offer(i);
                }
            }
        }
        return 0;
    }


    // 方法5：
    // 对方法4的优化；主要优化的点是每次遍历一层时，从节点更少的一端遍历
    public static int ladderLength5(String beginWord, String endWord, List<String> wordList){
        int end = wordList.indexOf(endWord);
        if(end == -1)
            return 0;

        wordList.add(beginWord);
        int start = wordList.size() - 1;
        Queue<Integer> queue1 = new LinkedList<>();
        Queue<Integer> queue2 = new LinkedList<>();
        Set<Integer> visited1 = new HashSet<>();
        Set<Integer> visited2 = new HashSet<>();
        queue1.offer(start);
        queue2.offer(end);
        visited1.add(start);
        visited2.add(end);
        int count = 0;
        while(!queue1.isEmpty() && !queue2.isEmpty()){
            count++;
            if(queue1.size() > queue2.size()){
                Queue<Integer> tmp = queue1;
                queue1 = queue2;
                queue2 = tmp;
                Set<Integer> t = visited1;
                visited1 = visited2;
                visited2 = t;
            }
            int size1 = queue1.size();
            while(size1-- > 0){
                String s = wordList.get(queue1.poll());
                for(int i = 0; i < wordList.size(); ++i){
                    if(visited1.contains(i)){
                        continue;
                    }
                    if(!canConvert(s,wordList.get(i))){
                        continue;
                    }
                    if(visited2.contains(i)){
                        return count + 1;
                    }
                    visited1.add(i);
                    queue1.offer(i);
                }
            }
        }
        return 0;
    }


    // 方法6：
    // 对方法5的进一步优化，主要是单词转换判断的优化
    // **思路1**：遍历所有候选单词，判断当前单词是否可以转换成候选单词，判断的过程也就是前面的canConvert方法
    //           逐个对比单词的字符。
    // **思路2**：因为单词都是a~z这有限数量的字符组成的，可以遍历当前单词能转换成的所有单词，判断其是否包含在
    //           候选单词中，候选单词用HashSet保存，可以大大提高判断包含关系的性能
    // 当单词总数量庞大的时候，之前代码用到的思路1耗时就会很长。
    // 而当单词的字符串数量、单词长度很大时，思路2耗时就会更长。
    // 实际情况下，一般单词不会很长，字符也是固定的26个小写字母，因此思路2的性能会好很多
    public static int ladderLength6(String beginWord, String endWord, List<String> wordList){
        int end = wordList.indexOf(endWord);
        if(end == -1)
            return 0;
        wordList.add(beginWord);

        // 从两端BFS遍历要用的队列
        Queue<String> queue1 = new LinkedList<>();
        Queue<String> queue2 = new LinkedList<>();
        // 两端已经遍历过的节点
        Set<String> visited1 = new HashSet<>();
        Set<String> visited2 = new HashSet<>();

        queue1.offer(beginWord);
        queue2.offer(endWord);
        visited1.add(beginWord);
        visited2.add(endWord);

        int count = 0;
        Set<String> allWordSet = new HashSet<>(wordList);

        while(!queue1.isEmpty() && !queue2.isEmpty()){
            count++;
            if(queue1.size() > queue2.size()){
                Queue<String> tmp = queue1;
                queue1 = queue2;
                queue2 = tmp;
                Set<String> t = visited1;
                visited1 = visited2;
                visited2 = t;
            }
            int size1 = queue1.size();
            while(size1-- > 0){
                String s = queue1.poll();
                char[] chars = s.toCharArray();
                for(int j = 0; j < s.length(); ++j){
                    // 保存第j位的原始字符
                    char c0 = chars[j];
                    for(char c = 'a'; c <= 'z'; ++c){
                        chars[j] = c;
                        String newString = new String(chars);
                        // 已经访问过了的话，直接跳过
                        if(visited1.contains(newString)){
                            continue;
                        }
                        // 两端遍历相遇，结束遍历，返回count
                        if(visited2.contains(newString)){
                            return count + 1;
                        }
                        // 如果单词在列表中存在，将其添加到队列，并标记已访问
                        if(allWordSet.contains(newString)){
                            queue1.offer(newString);
                            visited1.add(newString);
                        }
                    }
                    chars[j] = c0;
                }
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("hot");
        list.add("dot");
        list.add("dog");
        list.add("lot");
        list.add("log");
        list.add("cog");
        list.add("hit");
        List<Integer>[] graphic = buildGraphic(list);
        int res = getShortestPath(graphic,6,5);
        System.out.println(res);
    }
}
