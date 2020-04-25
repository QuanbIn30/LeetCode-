package lc_4_22;

/**
 * @author superquanbin@gmail.com
 * @date 2020-04-22 15:01
 */
public class lc_130_solve {

    private int m, n;
    private int[][] direction = {{0, 1},{0, -1},{1, 0},{-1, 0}};

    // 方法1：DFS
    public void solve(char[][] board){
        if(board == null || board.length == 0){
            return;
        }
        m = board.length;
        n = board[0].length;

        // 遍历第一列和左右一列，使等于'O'的字符都变成'T'
        for(int i = 0; i < m; i++){
            dfs(board, i, 0);
            dfs(board, i, n - 1);
        }
        // 遍历第一行和最后一行，使等于'O'的字符都变成'T'
        for(int i = 0; i < n; i++){
            dfs(board, 0, i);
            dfs(board, m - 1, i);
        }
        // 经过上面两次for循环之后分布在矩阵的四周上的字符'O'，以及四周上字符'O'能到达的字符'O'都变成了'T'
        // 而中间被字符'X'包围的字符'O'都没有变，换言之，没有变为字符'T'的都是被字符'X'包围的

        // 遍历整个字符矩阵，使其中的字符'T'变为'O'，使其中的字符'O'变成'X'
        for(int i = 0; i < m; i++){
            for (int j = 0; j < n; j++) {
                if(board[i][j] == 'T'){
                    board[i][j] = 'O';
                }else if (board[i][j] == 'O'){
                    board[i][j] = 'X';
                }
            }
        }
    }

    private void dfs(char[][] board, int r, int c){
        if(r < 0 || r >= m || c < 0 || c >= n || board[r][c] != 'O'){
            return;
        }
        board[r][c] = 'T';
        for(int[] d : direction){
            dfs(board, r + d[0], c + d[1]);
        }
    }
}
