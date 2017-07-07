/*
 * [529] Minesweeper
 *
 * https://leetcode.com/problems/minesweeper
 *
 * Medium (50.36%)
 * Total Accepted:    
 * Total Submissions: 
 * Testcase Example:  '["EEEEE","EEMEE","EEEEE","EEEEE"]\n[3,0]'
 *
 * Can you solve this problem? 🤔
 */
public class Solution {
    public char[][] updateBoard(char[][] board, int[] click) {
        int x = click[0];
        int y = click[1];
        if (board[x][y] == 'M') {
            board[x][y] = 'X';
            return board;
        }
        
        int mines = countMine(board, x, y);
        if (mines != 0) {
            board[x][y] = (char)(mines + '0');
            return board;
        }
        
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{ x, y });
        while (!queue.isEmpty()) {
            int[] pair = queue.remove();
            int i = pair[0];
            int j = pair[1];
            int mine = countMine(board, i, j);
            if (mine != 0) {
                board[i][j] = (char)(mine + '0');
                continue;
            }
            board[i][j] = 'B';
            for (int p = -1; p < 2; p++) {
                for (int q = -1; q < 2; q++) {
                    if (p == 0 && q == 0) { continue; }
                    int row = i + p, col = j + q;
                    if (row < 0 || row >= board.length || col < 0 || col >= board[0].length) { continue; }
                    if (board[row][col] == 'E') {
                        queue.add(new int[]{ row, col });
                        board[row][col] = 'B';
                    }
                }
            }
        }
        
        return board;
    }
    
    private int countMine(char[][] board, int i, int j) {
        int count = 0;
        if (i > 0 && board[i-1][j] == 'M')                                              { count++; }
        if (i < board.length - 1 && board[i+1][j] == 'M')                               { count++; }
        if (j > 0 && board[i][j-1] == 'M')                                              { count++; }
        if (j < board[0].length - 1 && board[i][j+1] == 'M')                            { count++; }
        if (i > 0 && j > 0 && board[i-1][j-1] == 'M')                                   { count++; }
        if (i > 0 && j < board[0].length - 1 && board[i-1][j+1] == 'M')                 { count++; }
        if (i < board.length - 1 && j > 0 && board[i+1][j-1] == 'M')                    { count++; }
        if (i < board.length - 1 && j < board[0].length - 1 && board[i+1][j+1] == 'M')  { count++; }
        return count;
    }
}
