/*
 * [221] Maximal Square
 *
 * https://leetcode.com/problems/maximal-square
 *
 * Medium (28.53%)
 * Total Accepted:    
 * Total Submissions: 
 * Testcase Example:  '["10100","10111","11111","10010"]'
 *
 * Can you solve this problem? 🤔
 */
public class Solution {
    public int maximalSquare(char[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }
        
        int m = matrix.length;
        int n = matrix[0].length;
        int max = 0;
        int[] lastRow = new int[n];
        
        for (int j = 0; j < n; j++) {
            lastRow[j] = matrix[0][j] == '1' ? 1 : 0;
            max = Math.max(max, lastRow[j]);
        }
        
        for (int i = 1; i < m; i++) {
            int[] curRow = new int[n];
            curRow[0] = matrix[i][0] == '1' ? 1 : 0;
            max = Math.max(max, curRow[0]);
            for (int j = 1; j < n; j++) {
                curRow[j] = matrix[i][j] == '0' ? 0 : Math.min(lastRow[j - 1], Math.min(lastRow[j], curRow[j - 1])) + 1;
                max = Math.max(max, curRow[j]);
            }
            lastRow = curRow;
        }
        
        return max * max;
    }
}
