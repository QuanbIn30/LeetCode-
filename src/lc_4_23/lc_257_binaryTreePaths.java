package lc_4_23;

import common.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 输出二叉树中所有从根到叶子的路径
 * @author superquanbin@gmail.com
 * @date 2020-04-23 19:50
 */
public class lc_257_binaryTreePaths {

    public List<String> binaryTreePaths (TreeNode root){
        // 定义一个paths链表存放结果集
        List<String> paths = new ArrayList<>();
        // 国际惯例，检查输入数据的欺骗性
        if(root == null){
            return paths;
        }

        // 定义一个存放Integer类型数据的链表values用来存放当前遍历链路中的数据
        List<Integer> values = new ArrayList<>();
        // 从输入节点开始回溯，盘它
        backtracking(root, values, paths);
        return paths;
    }

    // 回溯
    private void backtracking(TreeNode node, List<Integer> values, List<String> paths){
        // 判断，如果当前节点是空，直接返回
        if(node == null)
            return;

        // 将当前节点的值存进values链表中
        values.add(node.val);

        // 如果节点是叶子节点则将当前链路转换String字符串存放进结果集paths中
        // 如果不是叶子节点的话就继续往下遍历（深度优先遍历）
        if(isLeaf(node)){
            paths.add(buildPath(values));
        }else{
            backtracking(node.left, values, paths);
            backtracking(node.right, values, paths);
        }
        // 回溯
        // 删除当前轮次的遍历中添加进values链表的节点值
        values.remove(values.size() - 1);
    }

    private boolean isLeaf(TreeNode node){
        return node.left == null && node.right == null;
    }

    private String buildPath(List<Integer> values){
        StringBuilder str = new StringBuilder();
        for(int i = 0; i < values.size(); i++){
            str.append(values.get(i));
            if(i != values.size() - 1){
                str.append("->");
            }
        }
        return str.toString();
    }

    public static void main(String[] args) {
        TreeNode inputTree = new TreeNode(1);
        inputTree.right = new TreeNode(3);
        inputTree.left = new TreeNode(2);
        inputTree.left.right = new TreeNode(5);
        lc_257_binaryTreePaths testclass = new lc_257_binaryTreePaths();
        List<String> res = testclass.binaryTreePaths(inputTree);
        System.out.println(res);
    }
}
