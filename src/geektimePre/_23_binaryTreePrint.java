package geektimePre;

import common.TreeNode;

/**
 * 二叉树的打印
 * @author MHLEVEL
 * @date 2020-09-09 11:19
 */
public class _23_binaryTreePrint {

    // 前序遍历，递归打印。
    public void preOrder (TreeNode root) {

        if (root == null)
            return;
        System.out.println(root.val);
        preOrder(root.left);
        preOrder(root.right);
    }

    // 中序遍历，递归打印。
    public void inOrder (TreeNode root) {

        if (root == null)
            return;
        inOrder(root.left);
        System.out.println(root.val);
        inOrder(root.right);
    }

    // 后序遍历，递归打印。
    public void postOrder (TreeNode root) {

        if (root == null)
            return;
        postOrder(root.left);
        postOrder(root.right);
        System.out.println(root.val);
    }
}
