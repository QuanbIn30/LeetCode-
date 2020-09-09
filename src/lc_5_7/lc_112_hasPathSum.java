package lc_5_7;

import common.TreeNode;

import java.util.LinkedList;

/**
 * 路径总和
 * @author superquanbin@gmail.com
 * @date 2020-05-07 17:42
 */
public class lc_112_hasPathSum {

    // 方法1：递归
    public boolean hasPathSum1(TreeNode root, int sum){

        if(root == null)
            return false;

        if(root.left == null && root.right == null && root.val == sum)
            return true;

        return hasPathSum1(root.left, sum - root.val) ||
                hasPathSum1(root.right, sum - root.val);
    }

    // 方法2：迭代
    // 这种方法平均时间复杂度是O(LogN)而最坏情况的时间复杂度才和递归方法的正常情况一样是O(N)
    public boolean hasPathSum2(TreeNode root, int sum) {

        //  国际惯例，先判断输入的欺骗性
        if (root == null)
            return false;

        // 然后定义两个栈并分别将树的头节点和（目标sum-头节点的值）存进两个栈中
        LinkedList<TreeNode> node_stack = new LinkedList();
        LinkedList<Integer> sum_stack = new LinkedList();
        node_stack.add(root);
        sum_stack.add(sum - root.val);

        // 定义两个变量一会儿存放从栈中弹出来的数据
        TreeNode node;
        int curr_sum;
        // 只要栈不为空，就一直将栈顶元素弹栈
        while ( !node_stack.isEmpty() ) {
            // 下面两步是弹栈的过程
            node = node_stack.pollLast();
            curr_sum = sum_stack.pollLast();
            // 先判断一下是不是满足条件了，满足条件就直接return，不用再继续找了
            if ((node.right == null) && (node.left == null) && (curr_sum == 0))
                return true;

            //如果还没得到答案的话就将当前节点的左右孩子放进栈中，注意两个栈分别存放的内容

            if (node.right != null) {
                node_stack.add(node.right);
                sum_stack.add(curr_sum - node.right.val);
            }
            if (node.left != null) {
                node_stack.add(node.left);
                sum_stack.add(curr_sum - node.left.val);
            }
        }
        return false;
    }

    public static void main(String[] args) {
        TreeNode t = new TreeNode(5);
        t.left = new TreeNode(4);
        t.right = new TreeNode(8);
        t.left.left = new TreeNode(11);
        t.left.left.left = new TreeNode(7);
        t.left.left.right = new TreeNode(2);
        t.right.left = new TreeNode(13);
        t.right.right = new TreeNode(4);
        t.right.right.right = new TreeNode(1);
        lc_112_hasPathSum tc = new lc_112_hasPathSum();
//        boolean res = tc.hasPathSum1(t, 22);
        boolean res = tc.hasPathSum2(t, 22);
        System.out.println(res);
    }

}
