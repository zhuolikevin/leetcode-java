/*
 * [120] Triangle
 *
 * https://leetcode.com/problems/triangle
 *
 * Medium (33.50%)
 * Total Accepted:    
 * Total Submissions: 
 * Testcase Example:  '[[-10]]'
 *
 * Can you solve this problem? 🤔
 */
public class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        if (triangle == null || triangle.size() == 0) {
            return 0;
        }
        int n = triangle.size();
        int[] lastRow = new int[n];
        
        for (int j = 0; j < n; j++) {
            lastRow[j] = triangle.get(n - 1).get(j);
        }
        
        for (int i = n - 2; i >= 0; i--) {
            int[] newRow = new int[n];
            for (int j = 0; j <= i; j++) {
                newRow[j] = triangle.get(i).get(j) + Math.min(lastRow[j], lastRow[j + 1]);
            }
            lastRow = newRow;
        }
        
        return lastRow[0];
    }
}
