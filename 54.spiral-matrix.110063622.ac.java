/*
 * [54] Spiral Matrix
 *
 * https://leetcode.com/problems/spiral-matrix
 *
 * Medium (25.74%)
 * Total Accepted:    
 * Total Submissions: 
 * Testcase Example:  '[[1,2,3],[4,5,6],[7,8,9]]'
 *
 * Can you solve this problem? 🤔
 */
public class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<>();
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return res;
        }
        
        int i = 0;
        int j = 0;
        int[][] dirs = { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };
        int m = matrix.length;
        int n = matrix[0].length;
        int index = 0;
        int count = 0;
        while (count < m * n) {
            res.add(matrix[i][j]);
            matrix[i][j] = 0;
            count++;
            if (count == m * n) {
                break;
            }
            int x = i + dirs[index][0];
            int y = j + dirs[index][1];
            if (x < 0 || x >= m || y < 0 || y >= n || matrix[x][y] == 0) {
                index = (index + 1) % 4;
                x = i + dirs[index][0];
                y = j + dirs[index][1];
            }
            i = x;
            j = y;
        }
        
        return res;
    }
}
