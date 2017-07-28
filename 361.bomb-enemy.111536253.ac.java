/*
 * [361] Bomb Enemy
 *
 * https://leetcode.com/problems/bomb-enemy
 *
 * Medium (38.79%)
 * Total Accepted:    
 * Total Submissions: 
 * Testcase Example:  '["0E00","E0WE","0E00"]'
 *
 * Can you solve this problem? 🤔
 */
public class Solution {
    public int maxKilledEnemies(char[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        
        int m = grid.length;
        int n = grid[0].length;
        int[][] counts = new int[m][n];
        
        for (int i = 0; i < m; i++) {
            int count = 0;
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 'E') {
                    count++;
                } else if (grid[i][j] == 'W') {
                    count = 0;
                } else {
                    counts[i][j] += count;
                }
            }
            count = 0;
            for (int j = n - 1; j >= 0; j--) {
                if (grid[i][j] == 'E') {
                    count++;
                } else if (grid[i][j] == 'W') {
                    count = 0;
                } else {
                    counts[i][j] += count;
                }
            }
        }
        
        int maxCount = 0;
        for (int j = 0; j < n; j++) {
            int count = 0;
            for (int i = 0; i < m; i++) {
                if (grid[i][j] == 'E') {
                    count++;
                } else if (grid[i][j] == 'W') {
                    count = 0;
                } else {
                    counts[i][j] += count;
                }
            }
            count = 0;
            for (int i = m - 1; i >= 0; i--) {
                if (grid[i][j] == 'E') {
                    count++;
                } else if (grid[i][j] == 'W') {
                    count = 0;
                } else {
                    counts[i][j] += count;
                    maxCount = Math.max(maxCount, counts[i][j]);
                }
            }
        }
        
        return maxCount;
    }
}
