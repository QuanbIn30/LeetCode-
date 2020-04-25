package lc_4_20;

import common.TreeNode;
import java.util.List;
import java.util.LinkedList;

/**
 * 不同的二叉搜索树
 *
 * 题意：给定一个整数 n，生成所有由 1 ... n 为节点所组成的二叉搜索树。
 * @author superquanbin@gmail.com
 * @date 2020-04-20 17:01
 */
public class lc_95_generateTrees {

    public static List<TreeNode> generateTrees (int n){
        if(n < 1){
            return new LinkedList<TreeNode>();
        }
        return generateTrees(1,n);
    }

    private static List<TreeNode> generateTrees(int s, int e){
        List<TreeNode> res = new LinkedList<TreeNode>();
        if(s > e){
            res.add(null);
            return res;
        }
        for(int i = s; i <= e; ++i){
            List<TreeNode> leftSubtrees = generateTrees(s, i - 1);
            List<TreeNode> rightSubtrees = generateTrees(i + 1, e);
            for(TreeNode left : leftSubtrees){
                for (TreeNode right : rightSubtrees){
                    TreeNode root = new TreeNode(i);
                    root.left = left;
                    root.right = right;
                    res.add(root);
                }
            }
        }
        return res;
    }
}
