/*
 * [115] Distinct Subsequences
 *
 * https://leetcode.com/problems/distinct-subsequences
 *
 * Hard (31.34%)
 * Total Accepted:    
 * Total Submissions: 
 * Testcase Example:  '""\n"a"'
 *
 * Can you solve this problem? 🤔
 */
public class Solution {
    public int numDistinct(String s, String t) {
        int m = s.length();
        int n = t.length();
        if (n > m) {
            return 0;
        }
        
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 0; i <= m; i++) {
            dp[i][0] = 1;
        }
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= Math.min(i, n); j++) {
                dp[i][j] = s.charAt(i - 1) == t.charAt(j - 1) ? dp[i - 1][j] + dp[i - 1][j - 1] : dp[i - 1][j];
            }
        }
        
        return dp[m][n];
    }
}
