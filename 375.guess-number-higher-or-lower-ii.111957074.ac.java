/*
 * [375] Guess Number Higher or Lower II
 *
 * https://leetcode.com/problems/guess-number-higher-or-lower-ii
 *
 * Medium (35.77%)
 * Total Accepted:    
 * Total Submissions: 
 * Testcase Example:  '1'
 *
 * Can you solve this problem? 🤔
 */
public class Solution {
    public int getMoneyAmount(int n) {
        int[][] dp = new int[n][n];
        for (int len = 2; len <= n; len++) {
            for (int start = 0; start + len - 1 < n; start++) {
                int min = Integer.MAX_VALUE;
                for (int pivot = start; pivot <= start + len - 1; pivot++) {
                    int cost1 = pivot == start ? 0 : dp[start][pivot - 1];
                    int cost2 = pivot == start + len - 1 ? 0 : dp[pivot + 1][start + len - 1];
                    min = Math.min(min, (pivot + 1) + Math.max(cost1, cost2));
                }
                dp[start][start + len - 1] = min;
            }
        }
        
        return dp[0][n - 1];
    }
}
