package lc_5_7;

import com.sun.scenario.effect.Merge;
import common.TreeNode;

/**
 * 合并二叉树
 * @author superquanbin@gmail.com
 * @date 2020-05-07 16:50
 */
public class lc_617_mergeTrees {

    // 方法1：递归
    public TreeNode mergeTrees1(TreeNode t1, TreeNode t2){
        // base case
        if(t1 == null && t2 == null) return null;
        if(t1 == null) return t2;
        if(t2 == null) return t1;
        TreeNode root = new TreeNode(t1.val + t2.val);
        root.left = mergeTrees1(t1.left, t2.left);
        root.right = mergeTrees1(t1.right, t2.right);
        return root;
    }

    // 方法1的精简版 --> 方法2
    public TreeNode mergeTrees2(TreeNode t1, TreeNode t2){
        if(t1 == null) return t2;
        if(t2 == null) return t1;
        t1.val += t2.val;
        t1.left = mergeTrees2(t1.left, t2.left);
        t1.right = mergeTrees2(t1.right, t2.right);
        return t1;
    }
}
