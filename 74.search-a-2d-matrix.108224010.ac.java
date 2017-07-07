/*
 * [74] Search a 2D Matrix
 *
 * https://leetcode.com/problems/search-a-2d-matrix
 *
 * Medium (35.15%)
 * Total Accepted:    
 * Total Submissions: 
 * Testcase Example:  '[[1,3,5,7],[10,11,16,20],[23,30,34,50]]\n3'
 *
 * Can you solve this problem? 🤔
 */
public class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }
        
        int m = matrix.length;
        int n = matrix[0].length;
        
        int start = 0;
        int end = m * n - 1;
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (matrix[mid / n][mid % n] == target) {
                return true;
            } else if (matrix[mid / n][mid % n] > target) {
                end = mid;
            } else {
                start = mid;
            }
        }
        return matrix[start / n][start % n] == target || matrix[end / n][end % n] == target;
    }
}
