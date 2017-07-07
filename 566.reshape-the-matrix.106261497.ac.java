/*
 * [566] Reshape the Matrix
 *
 * https://leetcode.com/problems/reshape-the-matrix
 *
 * Easy (59.79%)
 * Total Accepted:    
 * Total Submissions: 
 * Testcase Example:  '[[1,2],[3,4]]\n1\n4'
 *
 * Can you solve this problem? 🤔
 */
public class Solution {
    public int[][] matrixReshape(int[][] nums, int r, int c) {
        int m = nums.length;
        int n = nums[0].length;
        if (m * n != r * c) {
            return nums;
        }
        
        int[][] result = new int[r][c];
        
        for (int i = 0; i < r * c; i++) {
            result[i / c][i % c] = nums[i / n][i % n];
        }
        return result;
    }
}
