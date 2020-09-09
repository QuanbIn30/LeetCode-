package lc_5_7;

import common.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 树的高度
 * @author superquanbin@gmail.com
 * @date 2020-05-07 08:04
 */
public class lc_104_maxDepth {

    // 方法1：DFS
    // 时间复杂度O(N)
    // 空间复杂度：极端情况下是O(N)，就是树已经退化到只有一边了，每一层要么只有左子树，要么只有右子树
    //           正常情况空间复杂度是树的层数 O(logN)
    public int maxDepth1(TreeNode root){
        if(root == null){
            return 0;
        }else{
            int left_height = maxDepth1(root.left);
            int right_height = maxDepth1(root.right);
            // 把目光放在某个遍历到的跟节点上，秘诀就在这个 + 1 上，
            // 因为就算我左边，右边得到的都是0，但是我把我自己算上，那我返回去的也是1
            // 而对于不是根节点的节点来说，那就是简单的找到更大的一个数（也就是更高层）再加上我自己这一层
            // 很简单粗暴，对于底层来说，啥也没有但是有自己，对于上层来说，割了最大的韭菜还要加上自己，轻轻松松
            return Math.max(left_height, right_height) + 1;
        }
    }

    // 方法2：BFS
    public int maxDepth2(TreeNode root) {
        int level = 0;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()) {
            int size = q.size();
            level++;
            for (int i = 0; i < size; i++) {
                // 这一步获取从队列中出队的元素，很重要，因为接下来要进队列的元素要依据它来定
                TreeNode tmp = q.poll();
                if (tmp.left != null) {
                    q.add(tmp.left);
                }
                if (tmp.right != null) {
                    q.add(tmp.right);
                }
            }
        }
        return level;
    }
}
