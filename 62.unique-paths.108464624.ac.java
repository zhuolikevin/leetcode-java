/*
 * [62] Unique Paths
 *
 * https://leetcode.com/problems/unique-paths
 *
 * Medium (40.71%)
 * Total Accepted:    
 * Total Submissions: 
 * Testcase Example:  '1\n2'
 *
 * Can you solve this problem? 🤔
 */
public class Solution {
    public int uniquePaths(int m, int n) {
        if (m <= 0 || n <= 0) {
            return 0;
        }
        
        int[][] count = new int[m][n];
        
        for (int i = 0; i < m; i++) {
            count[i][0] = 1;
        }
        for (int j = 0; j < n; j++) {
            count[0][j] = 1;
        }
        
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                count[i][j] = count[i - 1][j] + count[i][j - 1];
            }
        }
        
        return count[m - 1][n - 1];
    }
}
