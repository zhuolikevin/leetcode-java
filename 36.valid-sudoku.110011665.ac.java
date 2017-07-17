/*
 * [36] Valid Sudoku
 *
 * https://leetcode.com/problems/valid-sudoku
 *
 * Medium (35.45%)
 * Total Accepted:    
 * Total Submissions: 
 * Testcase Example:  '[".87654321","2........","3........","4........","5........","6........","7........","8........","9........"]'
 *
 * Can you solve this problem? 🤔
 */
public class Solution {
    public boolean isValidSudoku(char[][] board) {
        if (board == null || board.length == 0 || board[0].length == 0) {
            return false;
        }
        
        int m = board.length;
        int n = board[0].length;
        for (int i = 0; i < m; i++) {
            if (!isValidRow(board, i)) {
                return false;
            }
        }
        for (int j = 0; j < n; j++) {
            if (!isValidCol(board, j)) {
                return false;
            }
        }
        for (int i = 0; i <= 6; i += 3) {
            for (int j = 0; j <= 6; j += 3) {
                if (!isValidBox(board, i, j)) {
                    return false;
                }
            }
        }
        
        return true;
    }
    
    private boolean isValidRow(char[][] board, int row) {
        Set<Character> set = new HashSet<>();
        for (int j = 0; j < board[0].length; j++) {
            if (board[row][j] == '.') {
                continue;
            }
            char c = board[row][j];
            if (set.contains(c) || c < '1' || c > '9') {
                return false;
            }
            set.add(c);
        }
        return true;
    }
    private boolean isValidCol(char[][] board, int col) {
        Set<Character> set = new HashSet<>();
        for (int i = 0; i < board.length; i++) {
            if (board[i][col] == '.') {
                continue;
            }
            char c = board[i][col];
            if (set.contains(c) || c < '1' || c > '9') {
                return false;
            }
            set.add(c);
        }
        return true;
    }
    private boolean isValidBox(char[][] board, int i, int j) {
        Set<Character> set = new HashSet<>();
        for (int p = i; p < i + 3; p++) {
            for (int q = j; q < j + 3; q++) {
                if (board[p][q] == '.') {
                    continue;
                }
                char c = board[p][q];
                if (set.contains(c) || c < '1' || c > '9') {
                    return false;
                }
                set.add(c);
            }
        }
        return true;
    }
}
