/*
 * [130] Surrounded Regions
 *
 * https://leetcode.com/problems/surrounded-regions
 *
 * Medium (18.22%)
 * Total Accepted:    
 * Total Submissions: 
 * Testcase Example:  '["XXXX","XOOX","XXOX","XOXX"]'
 *
 * Can you solve this problem? 🤔
 */
public class Solution {
    public void solve(char[][] board) {
        if (board == null || board.length == 0 || board[0].length == 0) {
            return;
        }
        
        int m = board.length;
        int n = board[0].length;
        if (m == 1 || n == 1) {
            return;
        }
        
        for (int i = 0; i < m; i += m - 1) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 'O') {
                    bfs(board, 'B', i, j);
                }
            }
        }
        for (int j = 0; j < n; j += n - 1) {
            for (int i = 0; i < m; i++) {
                if (board[i][j] == 'O') {
                    bfs(board, 'B', i, j);
                }
            }
        }
        for (int i = 1; i < m - 1; i++) {
            for (int j = 1; j < n - 1; j++) {
                if (board[i][j] == 'O') {
                    bfs(board, 'X', i, j);
                }
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 'B') {
                    board[i][j] = 'O';
                }
            }
        }
    }
    
    private void bfs(char[][] board, char tag, int i, int j) {
        int m = board.length;
        int n = board[0].length;
        int[][] dirs = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };
        
        board[i][j] = tag;
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(i * n + j);

        while (!queue.isEmpty()) {
            int index = queue.poll();
            int x = index / n;
            int y = index % n;

            for (int[] dir : dirs) {
                int xx = x + dir[0];
                int yy = y + dir[1];

                if (xx < 0 || xx >= m || yy < 0 || yy >= n || board[xx][yy] != 'O') {
                    continue;
                }

                board[xx][yy] = tag;
                queue.offer(xx * n + yy);
            }
        }
    }
}
