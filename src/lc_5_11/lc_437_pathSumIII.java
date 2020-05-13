package lc_5_11;

import common.TreeNode;

/**
 * 统计路径和等于一个数的路径数量
 * @author superquanbin@gmail.com
 * @date 2020-05-11 12:26
 */
public class lc_437_pathSumIII {

    public int pathSum(TreeNode root, int sum){
        if(root == null)
            return 0;
        int ret = pathSumStartWithRoot(root, sum) + pathSum(root.left, sum) + pathSum(root.right, sum);
        return ret;
    }

    public int pathSumStartWithRoot(TreeNode root, int sum){
        if (root == null) return 0;
        int ret = 0;
        if (root.val == sum) ret++;
        ret += pathSumStartWithRoot(root.left, sum - root.val) + pathSumStartWithRoot(root.right, sum - root.val);
        return ret;
    }
}
