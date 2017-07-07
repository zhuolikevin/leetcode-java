/*
 * [498] Diagonal Traverse
 *
 * https://leetcode.com/problems/diagonal-traverse
 *
 * Medium (46.05%)
 * Total Accepted:    
 * Total Submissions: 
 * Testcase Example:  '[[1,2,3],[4,5,6],[7,8,9]]'
 *
 * Can you solve this problem? 🤔
 */
public class Solution {
    public int[] findDiagonalOrder(int[][] matrix) {
        if (matrix.length == 0 || matrix[0].length == 0) { return new int[0]; }
        int m = matrix.length;
        int n = matrix[0].length;
        boolean up = true;
        int i = 0;
        int j = 0;
        int count = 0;
        int[] res = new int[m * n];
        while (count < m * n) {
            res[count] = matrix[i][j];
            count++;
            i = up ? i - 1 : i + 1;
            j = up ? j + 1 : j - 1;
            if (i < 0 || j < 0 || i >= m || j >= n) {
                up = !up;
                if (i < 0 && j < n) {
                    i = 0;
                } else if (i < 0 && j >= n) {
                    i = 1;
                    j = n - 1;
                } else if (j < 0 && i < m) {
                    j = 0;
                } else if (j < 0 && i >= m) {
                    j = 1;
                    i = m - 1;
                } else if (i >= m) {
                    i = m - 1;
                    j += 2;
                } else if (j >= n) {
                    j = n - 1;
                    i += 2;
                }
            }
        }
        return res;
    }
}
