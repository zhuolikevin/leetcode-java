/*
 * [329] Longest Increasing Path in a Matrix
 *
 * https://leetcode.com/problems/longest-increasing-path-in-a-matrix
 *
 * Hard (36.15%)
 * Total Accepted:    
 * Total Submissions: 
 * Testcase Example:  '[[9,9,4],[6,6,8],[2,1,1]]'
 *
 * Can you solve this problem? 🤔
 */
public class Solution {
    private int[][] dp;
    private boolean[][] visited;
    public int longestIncreasingPath(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }
        
        int maxLen = 0;
        int m = matrix.length;
        int n = matrix[0].length;
        this.dp = new int[m][n];
        this.visited = new boolean[m][n];
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                visited[i][j] = true;
                dp[i][j] = dfs(i, j, matrix);
                visited[i][j] = false;
                
                maxLen = Math.max(maxLen, dp[i][j]);
            }
        }
        
        return maxLen;
    }
    
    private int dfs(int x, int y, int[][] matrix) {
        if (dp[x][y] != 0) {
            return dp[x][y];
        }
        
        int maxLen = 0;
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] dirs = new int[][] { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };
        for (int[] dir : dirs) {
            int xx = x + dir[0];
            int yy = y + dir[1];
            
            if (xx < 0 || xx >= m || yy < 0 || yy >= n || visited[xx][yy] || matrix[xx][yy] <= matrix[x][y]) {
                continue;
            }
            
            visited[xx][yy] = true;
            dp[xx][yy] = dfs(xx, yy, matrix);
            maxLen = Math.max(maxLen, dp[xx][yy]);
            visited[xx][yy] = false;
        }
        
        return maxLen + 1;
    }
}
