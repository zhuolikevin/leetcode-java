/*
 * [516] Longest Palindromic Subsequence
 *
 * https://leetcode.com/problems/longest-palindromic-subsequence
 *
 * Medium (42.46%)
 * Total Accepted:    
 * Total Submissions: 
 * Testcase Example:  '"bbbab"'
 *
 * Can you solve this problem? 🤔
 */
public class Solution {
    public int longestPalindromeSubseq(String s) {
        int n = s.length();
        int[][] dp = new int[n][n];
        for (int i = n - 1; i >= 0; i--) {
            dp[i][i] = 1;
            for (int j = i + 1; j < n; j++) {
                dp[i][j] = s.charAt(i) == s.charAt(j) 
                    ? dp[i+1][j-1] + 2
                    : Math.max(dp[i+1][j], dp[i][j-1]);
            }
        }
        return dp[0][n-1];
    }
}
