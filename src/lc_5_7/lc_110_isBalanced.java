package lc_5_7;

import common.TreeNode;

/**
 * 平衡树
 * @author superquanbin@gmail.com
 * @date 2020-05-07 09:51
 */
public class lc_110_isBalanced {
    // 方法1：DFS(对这题来说是暴力法)
    // 用height()方法找到每个节点（这个节点是isBalance()方法中参数的左右孩子节点）的高度
    // 然后在isBalances()方法这一层判断当前节点左右孩子节点的高度差
    // 时间复杂度 O(nLogN)；树中一共有n个节点，因为是平衡二叉树，所以每个节点上，调用height方法的次数不会超过O(LogN)次
    public boolean isBalanced1(TreeNode root){
        if(root == null)
            return true;
        return Math.abs(height(root.left) - height(root.right)) < 2
                && isBalanced1(root.left)
                && isBalanced1(root.right);
    }

    public int height(TreeNode root) {
        if (root == null) {
            return 0;
        } else {
            int left_height = height(root.left);
            int right_height = height(root.right);
            return Math.max(left_height, right_height) + 1;
        }
    }

    // 方法2
    // 我也不知道，题解也没写这种方法叫什么名字，但是可以避免方法1中冗余的子节点高度重复计算
    // 很秒～

    // Utility class to store information from recursive calls
    final class TreeInfo {
        public final int height;
        public final boolean balanced;

        public TreeInfo(int height, boolean balanced) {
            this.height = height;
            this.balanced = balanced;
        }
    }

    class Solution {

        private TreeInfo isBalancedTreeHelper(TreeNode root) {
            // An empty tree is balanced and has height = -1
            if (root == null) {
                return new TreeInfo(-1, true);
            }

            // Check subtrees to see if they are balanced.
            TreeInfo left = isBalancedTreeHelper(root.left);
            if (!left.balanced) {
                return new TreeInfo(-1, false);
            }
            TreeInfo right = isBalancedTreeHelper(root.right);
            if (!right.balanced) {
                return new TreeInfo(-1, false);
            }

            // Use the height obtained from the recursive calls to
            // determine if the current node is also balanced.
            if (Math.abs(left.height - right.height) < 2) {
                return new TreeInfo(Math.max(left.height, right.height) + 1, true);
            }
            return new TreeInfo(-1, false);
        }

        public boolean isBalanced2(TreeNode root) {
            return isBalancedTreeHelper(root).balanced;
        }
    }

    // 方法3：从底至顶
    // 思路是对二叉树做先序遍历，从底至顶返回子树最大高度，
    // 若判定某子树不是平衡树则 “剪枝”（返回-1就相当于对当前节点进行剪枝了（在以后的判断中生效）） ，直接向上返回。
    public boolean isBalanced3(TreeNode root){
        return recur(root) != -1;
    }

    private int recur(TreeNode root){
        if(root == null) return 0;
        int left = recur(root.left);
        if(left == -1) return -1;
        int right = recur(root.right);
        if(right == -1) return -1;
        return Math.abs(left - right) < 2 ? Math.max(left, right) + 1 : -1;
    }
}
