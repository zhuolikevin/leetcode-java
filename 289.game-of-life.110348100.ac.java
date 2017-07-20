/*
 * [289] Game of Life
 *
 * https://leetcode.com/problems/game-of-life
 *
 * Medium (36.76%)
 * Total Accepted:    
 * Total Submissions: 
 * Testcase Example:  '[[]]'
 *
 * Can you solve this problem? 🤔
 */
public class Solution {
    private int live = 1;
    private int die = 0;
    private int toDie = 2;
    private int toLive = 3;
    public void gameOfLife(int[][] board) {
        if (board == null || board.length == 0 || board[0].length == 0) {
            return;
        }
        
        int m = board.length;
        int n = board[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int liveCount = countLives(board, i, j);
                if (board[i][j] == live && (liveCount < 2 || liveCount > 3)) {
                    board[i][j] = toDie;
                } else if (board[i][j] == die && liveCount == 3){
                    board[i][j] = toLive;
                }
            }
        }
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == toDie) {
                    board[i][j] = die;
                } else if (board[i][j] == toLive) {
                    board[i][j] = live;
                }
            }
        }
    }
    
    private int countLives(int[][] board, int i, int j) {
        int m = board.length;
        int n = board[0].length;
        int count = 0;
        int[][] dirs = { { -1, -1 }, { -1, 0 }, { -1, 1 }, { 0, -1 }, { 0, 1 }, { 1, -1 }, { 1, 0 }, { 1, 1 } };
        for (int[] dir : dirs) {
            int x = i + dir[0];
            int y = j + dir[1];
            if (x < 0 || x >= m || y < 0 || y >= n) {
                continue;
            }
            if (board[x][y] == live || board[x][y] == toDie) {
                count++;
            }
        }
        return count;
    }
}
