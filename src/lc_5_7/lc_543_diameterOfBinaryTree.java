package lc_5_7;

import common.TreeNode;

/**
 * 二叉树的直径
 * 给定一棵二叉树，你需要计算它的直径长度。
 * 一棵二叉树的直径长度是任意两个结点路径长度中的最大值。
 * 这条路径可能穿过也可能不穿过根结点。
 * @author superquanbin@gmail.com
 * @date 2020-05-07 11:53
 */
public class lc_543_diameterOfBinaryTree {

    // 方法1
    int ans;
    public int diameterOfBinaryTree(TreeNode root){
        ans = 1;
        depth(root);
        return ans - 1;
    }
    private int depth(TreeNode node){
        // 访问到空节点了，返回0
        if(node == null) return 0;
        // 左儿子为根的子树的深度
        int L = depth(node.left);
        // 右儿子为根的子树的深度
        int R = depth(node.right);
        // 计算d_node即L+R+1（L+R+1就是当前节点为根的树的最大直径），并更新ans
        ans = Math.max(ans, L + R + 1);
        // 返回该节点为根的子树的深度
        return Math.max(L, R) + 1;
    }

    // 方法1中的代码精简版～
    // ans如何去掉加一减一的操作(因为方法1的代码中ans是全局变量，所以这里用a替代ans)
    int a;
    public int diameterOfBinaryTree2(TreeNode root){
        a = 0;
        depth2(root);
        return a;
    }
    public int depth2(TreeNode root){
        if(root == null)
            return 0;
        int L = depth(root.left);
        int R = depth(root.right);
        a = Math.max(a, L + R);
        return Math.max(L, R) + 1;
    }
}
