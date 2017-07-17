/*
 * [37] Sudoku Solver
 *
 * https://leetcode.com/problems/sudoku-solver
 *
 * Hard (29.83%)
 * Total Accepted:    
 * Total Submissions: 
 * Testcase Example:  '["..9748...","7........",".2.1.9...","..7...24.",".64.1.59.",".98...3..","...8.3.2.","........6","...2759.."]'
 *
 * Can you solve this problem? 🤔
 */
public class Solution {
    public void solveSudoku(char[][] board) {
        if (board == null || board.length == 0 || board[0].length == 0) {
            return;
        }
        
        solve(board, 0);
    }
    
    private boolean solve(char[][] board, int index) {
        int m = board.length;
        int n = board[0].length;

        while (index < m * n && Character.isDigit(board[index / n][index % n])) {
            index++;
        }
        
        if (index == m * n) {
            return true;
        }
        
        int x = index / n;
        int y = index % n;
        for (char c = '1'; c <= '9'; c++) {
            if (isValid(board, x, y, c)) {
                board[x][y] = c;
                if (solve(board, index + 1)) {
                    return true;
                } else {
                    board[x][y] = '.';
                }
            }
        }
        return false;
    }
    
    private boolean isValid(char[][] board, int row, int col, char c){
        for (int i = 0; i < 9; i++) {
            if (board[i][col] != '.' && board[i][col] == c) {
                return false;
            }
            if (board[row][i] != '.' && board[row][i] == c) {
                return false;
            }
            if (board[3 * (row / 3) + i / 3][ 3 * (col / 3) + i % 3] != '.' && 
board[3 * (row / 3) + i / 3][3 * (col / 3) + i % 3] == c) {
                return false;
            }
        }
        return true;
    }
}
