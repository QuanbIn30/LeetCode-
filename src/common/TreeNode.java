package common;

/**
 * @author superquanbin@gmail.com
 * @date 2020-04-20 16:59
 */
public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode(){

    }

    public TreeNode(int data){
        this.val = data;
    }

    public TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
