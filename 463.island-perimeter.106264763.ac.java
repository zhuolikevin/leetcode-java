/*
 * [463] Island Perimeter
 *
 * https://leetcode.com/problems/island-perimeter
 *
 * Easy (57.08%)
 * Total Accepted:    
 * Total Submissions: 
 * Testcase Example:  '[[0,1,0,0],[1,1,1,0],[0,1,0,0],[1,1,0,0]]'
 *
 * Can you solve this problem? 🤔
 */
public class Solution {
    public int islandPerimeter(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        
        int result = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0) {
                    continue;
                }
                int subRes = 0;
                if (i == 0) subRes++;
                if (i == m - 1) subRes++;
                if (j == 0) subRes++;
                if (j == n - 1) subRes++;
                
                if (i > 0 && grid[i-1][j] == 0) subRes++;
                if (i < m - 1 && grid[i+1][j] == 0) subRes++;
                if (j > 0 && grid[i][j-1] == 0) subRes++;
                if (j < n - 1 && grid[i][j+1] == 0) subRes++;
                
                result += subRes;
            }
        }
        
        return result;
    }
}
