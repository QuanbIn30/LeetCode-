package lc_20_04.lc_4_23;

import common.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 二叉树的右视图
 * @author superquanbin@gmail.com
 * @date 2020-04-23 15:13
 */
public class lc_199_rightSideView {

    List<Integer> res = new ArrayList<>();

    public List<Integer> rightSideView(TreeNode root){
        dfs(root, 0);
        return res;
    }

    private void dfs(TreeNode root, int depth){
        if(root == null)
            return;
        if(depth == res.size()){
            res.add(root.val);
        }
        depth++;
        dfs(root.right, depth);
        dfs(root.left, depth);
    }
}
