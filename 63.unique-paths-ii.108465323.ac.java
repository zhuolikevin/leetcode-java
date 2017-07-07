/*
 * [63] Unique Paths II
 *
 * https://leetcode.com/problems/unique-paths-ii
 *
 * Medium (31.52%)
 * Total Accepted:    
 * Total Submissions: 
 * Testcase Example:  '[[0]]'
 *
 * Can you solve this problem? 🤔
 */
public class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if (obstacleGrid == null || obstacleGrid.length == 0 || obstacleGrid[0].length == 0) {
            return 0;
        }
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        
        int[][] count = new int[m][n];
        count[0][0] = obstacleGrid[0][0] == 1 ? 0 : 1;
        for (int i = 1; i < m; i++) {
            count[i][0] = obstacleGrid[i][0] == 1 ? 0 : count[i - 1][0];
        }
        for (int j = 1; j < n; j++) {
            count[0][j] = obstacleGrid[0][j] == 1 ? 0 : count[0][j - 1];
        }
        
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (obstacleGrid[i][j] == 1) {
                    count[i][j] = 0;
                } else {
                    count[i][j] = count[i - 1][j] + count[i][j - 1];
                }
            }
        }
        
        return count[m - 1][n - 1];
    }
}
