/*
 * [79] Word Search
 *
 * https://leetcode.com/problems/word-search
 *
 * Medium (26.53%)
 * Total Accepted:    
 * Total Submissions: 
 * Testcase Example:  '["ABCE","SFCS","ADEE"]\n"ABCCED"'
 *
 * Can you solve this problem? 🤔
 */
public class Solution {
    private int[][] dirs = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };
    public boolean exist(char[][] board, String word) {
        if (board == null || board.length == 0 || board[0].length == 0) {
            return false;
        }
        int m = board.length;
        int n = board[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] != word.charAt(0)) {
                    continue;
                }
                Set<Integer> visited = new HashSet<>();
                visited.add(i * n + j);
                boolean find = dfs(i, j, board, visited, word, 1);
                if (find) {
                    return true;
                }
            }
        }
        return false;
    }
    
    private boolean dfs(int i, int j, char[][] board, Set<Integer> visited, String word, int index) {
        if (index == word.length()) {
            return true;
        }
        
        int m = board.length;
        int n = board[0].length;
        boolean find = false;
        
        for (int[] dir : dirs) {
            int x = i + dir[0];
            int y = j + dir[1];
            
            if (x < 0 || x >= m || y < 0 || y >= n || visited.contains(x * n + y) || board[x][y] != word.charAt(index)) {
                continue;
            }
            
            visited.add(x * n + y);
            find = dfs(x, y, board, visited, word, index + 1);
            visited.remove(x * n + y);
            
            if (find) {
                return true;
            }
        }
        
        return false;
    }
}
