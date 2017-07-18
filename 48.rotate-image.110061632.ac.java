/*
 * [48] Rotate Image
 *
 * https://leetcode.com/problems/rotate-image
 *
 * Medium (38.35%)
 * Total Accepted:    
 * Total Submissions: 
 * Testcase Example:  '[[1]]'
 *
 * Can you solve this problem? 🤔
 */
public class Solution {
    public void rotate(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return;
        }
        
        int m = matrix.length;
        int n = matrix[0].length;
        
        for (int i = 0; i < m / 2; i++) {
            for (int j = i; j < n - i - 1; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[n - j - 1][i];
                matrix[n - j - 1][i] = matrix[n - i - 1][m - j - 1];
                matrix[n - i - 1][m - j - 1] = matrix[j][m - i - 1];
                matrix[j][m - i - 1] = temp;
            }
        }
    }
}
