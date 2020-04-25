package lc_4_23;

/**
 * 单词搜索
 * @author superquanbin@gmail.com
 * @date 2020-04-23 15:35
 */
public class lc_79_exist {
    // 定义两个int型的变量 m, n 记录传入的矩阵宽和长
    private int m, n;
    private final static int[][] direction = {{1,0},{-1,0},{0,1},{0,-1}};

    public boolean exist (char[][] board, String word){
        // 国际惯例，先判断输入的数据的欺骗性
        if(word == null || word.length() == 0){
            return true;
        }
        if(board == null || board.length == 0 ||board[0].length == 0){
            return false;
        }

        // 给变量m n 赋初始值
        m = board.length;
        n = board[0].length;
        // 定义一个boolean类型的矩阵标记（/或者说是记录）当前链路有哪些格子（暂且叫格子吧）是走过的，true代表走过，false代表没走过
        boolean[][] hasVidited = new boolean[m][n];

        // 两层for循环的作用是在遍历过程中试着将每一个格子作为起点去看有没有与输入的字符word是一样的
        for (int r = 0; r < m; r++) {
            for (int c = 0; c < n; c++) {
                if(backtracking(0, r, c, hasVidited, board, word)){
                    return true;
                }
            }
        }
        return false;
    }

    // 回溯
    // curLen 记录当前链路上的字符长度
    // r 当前格子的行
    // c 当前格子的列
    // visited 这里要传入的是主方法中定义的标记矩阵
    // board 当前要在哪个字符矩阵中进行回溯
    // word 目标字符串
    private boolean backtracking(int curLen, int r, int c, boolean[][] visited
            , final char[][] board, final String word){

        // 当前链路上记录的字符串长度如果等于目标字符串说明在当前字符矩阵找到了目标字符串，返回true
        if(curLen == word.length()){
            return true;
        }
        // 判断当前格子有没有越界；是不是等于目标字符串中curLen索引位置的字符；是不是已经标记为已遍历过了
        // 越界直接返回false；不等于目标字符串中curLen所以的字符直接返回false；当前链路已经遍历过了直接返回false
        if(r < 0 || r >= m || c < 0 || c >= n
                || board[r][c] != word.charAt(curLen) || visited[r][c]){

            return false;
        }
        // 如果上面两个判断都不成立的话，说明当前链路的字符串还没有达到目标字符串的长度，
        // 并且有机会达到目标字符串的长度，因为当前字符与目标字符串中curLen索引处的相等，
        // 接下来我们需要继续探索与当前格子四边相邻的下一个字符是不是等于目标字符串curLen + 1索引处的字符
        visited[r][c] = true;

        // 下面这个for循环这就是探索与当前board[r][c]四边相邻的四个格子是不是与目标字符串的curLen + 1索引处的字符相等的代码
        for (int[] d : direction){
            if(backtracking(curLen + 1, r + d[0], c + d[1]
                    , visited, board, word)){
                return true;
            }
        }

        // 如果当前字符board[r][c]的四边没有与目标字符串curLen索引处的字符一样的字符的话，
        // 就将当前格子的标记设为false
        visited[r][c] = false;

        // 返回这个false可以在代码回溯的过程中将此链路已经标记为true的字符都改回false，以便下一条遍历链路使用当前字符
        return false;
    }

    public static void main(String[] args) {
        char[][] input = new char[][]{{'A','B','C','E'},
                                      {'S','F','C','S'},
                                      {'A','D','E','E'}};
        lc_79_exist testclass = new lc_79_exist();
        boolean res = testclass.exist(input,"ABCCED");
        System.out.println(res);
    }
}
