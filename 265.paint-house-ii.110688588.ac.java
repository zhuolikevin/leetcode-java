/*
 * [265] Paint House II
 *
 * https://leetcode.com/problems/paint-house-ii
 *
 * Hard (37.83%)
 * Total Accepted:    
 * Total Submissions: 
 * Testcase Example:  '[]'
 *
 * Can you solve this problem? 🤔
 */
public class Solution {
    public int minCostII(int[][] costs) {
        if (costs == null || costs.length == 0 || costs[0].length == 0) {
            return 0;
        }
        
        int n = costs.length;
        int k = costs[0].length;
        int[][] dp = new int[n][k];
        int min1 = Integer.MAX_VALUE;
        int min2 = Integer.MAX_VALUE;
        for (int j = 0; j < k; j++) {
            dp[0][j] = costs[0][j];
            if (dp[0][j] <= min1) {
                min2 = min1;
                min1 = dp[0][j];
            } else if (dp[0][j] <= min2) {
                min2 = dp[0][j];
            }
        }
        for (int i = 1; i < n; i++) {
            int newMin1 = Integer.MAX_VALUE;
            int newMin2 = Integer.MAX_VALUE;
            for (int j = 0; j < k; j++) {
                int min = dp[i - 1][j] == min1 ? min2 : min1;
                dp[i][j] = min + costs[i][j];
                if (dp[i][j] <= newMin1) {
                    newMin2 = newMin1;
                    newMin1 = dp[i][j];
                } else if (dp[i][j] <= newMin2) {
                    newMin2 = dp[i][j];
                }
            }
            min1 = newMin1;
            min2 = newMin2;
        }
        
        return min1;
    }
}
