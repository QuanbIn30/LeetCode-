package lc_20_05.lc_5_1;

import common.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author superquanbin@gmail.com
 * @date 2020-05-01 19:08
 */
public class lc_337_rob {
    Map<TreeNode, Integer> memo = new HashMap<>();
    public int rob(TreeNode root){
        // 国际惯例，判断一下输入的欺骗性
        if(root == null){
            return 0;
        }
        // 然后看一下是不是走过了，就是看memo中是不是已经存在了
        if(memo.containsKey(root)){
            return memo.get(root);
        }
        // 然后就是对当前房间抢还是不抢的问题
        // 抢！！！
        int do_rob = root.val + (root.left == null ? 0 : rob(root.left.left) +
                                 rob(root.left.right)) + (root.right == null ? 0 : rob(root.right.left) +
                                                                                        rob(root.right.right));
        // 不抢！！！
        int no_rob = rob(root.left) + rob(root.right);
        int res = Math.max(do_rob, no_rob);
        memo.put(root, res);
        return res;
    }
}
