/*
 * [132] Palindrome Partitioning II
 *
 * https://leetcode.com/problems/palindrome-partitioning-ii
 *
 * Hard (24.00%)
 * Total Accepted:    
 * Total Submissions: 
 * Testcase Example:  '"aab"'
 *
 * Can you solve this problem? 🤔
 */
public class Solution {
    public int minCut(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        
        boolean[][] isPalin = getPalinMatrix(s);
        
        int n = s.length();
        int[] dp = new int[n + 1];
        dp[0] = -1;
        
        for (int i = 1; i <= n; i++) {
            dp[i] = i - 1;
            for (int j = 0; j <= i - 1; j++) {
                if (isPalin[j][i - 1]) {
                    dp[i] = Math.min(dp[i], dp[j] + 1);
                }
            }
        }
        
        return dp[n];
    }
    
    private boolean[][] getPalinMatrix(String s) {
        int n = s.length();
        boolean[][] res = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            res[i][i] = true;
            if (i < n - 1) {
                res[i][i + 1] = s.charAt(i) == s.charAt(i + 1);
            }
        }
        
        for (int len = 2; len < n; len++) {
            for (int start = 0; start + len < n; start++) {
                res[start][start + len] = s.charAt(start) == s.charAt(start + len) && res[start + 1][start + len - 1];
            }
        }
        
        return res;
    }
}
