package template;

import common.TreeNode;

/**
 * dfs模版
 * @author superquanbin@gmail.com
 * @date 2020-04-22 07:52
 */
public class dfs {

    // 二叉树的dfs遍历结构
    public void traverse(TreeNode root){
        // 判断base case
        // 二叉树的base case是 root == null，这样一个条件判断有两个含义：
        // 一方面，这表示root指向的子树为空，不需要再往下遍历了；
        // 另一方面，在root等于空的时候及时返回，可以让后面的root.left和root.right操作不会出现空指针异常
        if(root == null){
            return;
        }
        // 访问两个相邻节点：左子节点，右子节点
        traverse(root.left);
        traverse(root.right);
    }

    // 网格dfs遍历的代码框架
    public void dfs(int[][] grid, int r, int c){
        // 判断base case
        // 如果坐标(r, c)超出了网格范围，直接返回
        if(!inArea(grid, r, c)){
            return;
        }
        // 访问网格(r, c)的上、下、左、右四个相邻网格
        dfs(grid,r - 1, c);
        dfs(grid,r + 1, c);
        dfs(grid,r, c - 1);
        dfs(grid,r, c + 1);
    }

    // 判断坐标(r, c)是否在网格中
    boolean inArea(int[][] grid, int r, int c){
        return 0 <= r && r <grid.length &&
                0 <= c && c < grid[0].length;
    }

    // 如何避免重复遍历？？？
    // 注意：网格结构的dfs与二叉树的dfs最大的不同之处在于，遍历过程中可能会遇到遍历过的节点，
    // 这是因为，网格结构本质上是一个"图"，我们可以把每个各自看成图中的节点，每个节点有上下左右四条边
    // 在图的遍历中，自然可能遇到重复遍历的节点。如何避免重复遍历呢？？？答案是标记已经遍历过的节点，
    // 每走过一个陆地格子，我们就把格子的值设为0（当然，这样设会改变网格原有的结构，所以具体设为什么值要具体问题具体分析）

    // 我们在代码框架中加入避免重复遍历的语句
    // 这也是岛屿问题，乃至各种网格问题的通用dfs遍历方法
    void dfs2(int[][] grid, int r, int c){
        // 判断base case
        if(!isArea(grid, r, c)){
            return;
        }
        // 如果当前格子不是岛屿，直接返回
        if(grid[r][c] != 1){
            return;
        }
        // 将格子标记为已遍历过
        grid[r][c] = 2; // 注意：标记为什么值要具体问题具体分析，最好不要改变原有的输入数据

        // 访问上、下、左、右四个相邻格子
        dfs(grid,r - 1, c);
        dfs(grid,r + 1, c);
        dfs(grid,r, c - 1);
        dfs(grid,r, c + 1);
    }

    // 判断坐标(r, c)是不是在网格中
    boolean isArea(int[][] grid, int r, int c){
        return 0 < r && r < grid.length && c < 0 && c < grid[0].length;
    }
}
