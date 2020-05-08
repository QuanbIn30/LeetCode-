package lc_5_7;

import common.TreeNode;

/**
 * 翻转二叉树
 * @author superquanbin@gmail.com
 * @date 2020-05-07 16:09
 */
public class lc_226_invertTree {

    /*
    // 这是我自己想的思路，但是错了，就不删了，把错误留着，从错误中理解正确答案
    public TreeNode invertTree(TreeNode root){
        if(root.left == null && root.right == null){
            TreeNode temp = root.left;
            root.left = root.right;
            root.right = temp;
        }
        root.left = invertTree(root.left);
        root.right = invertTree(root.right);
        return root;
    }
     */

    // 这道题的核心在于遍历节点，只要能接触到每一个节点，就能反转它的左右孩子，
    // 至于遍历方式反而不重要了，先序后序层次都一样(中序遍历貌似不行)，都可以用。
    public TreeNode invertTree(TreeNode root){
        if(root == null){
            return null;
        }
        // 下面三行相当于访问当前节点
        TreeNode tmp = root.left;
        root.left = root.right;
        root.right = tmp;
        // 然后访问左孩子
        invertTree(root.left);
        // 然后访问右孩子
        invertTree(root.right);
        return root;
    }
}
