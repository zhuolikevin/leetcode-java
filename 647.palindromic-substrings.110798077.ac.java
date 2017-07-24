/*
 * [647] Palindromic Substrings
 *
 * https://leetcode.com/problems/palindromic-substrings
 *
 * Medium (57.95%)
 * Total Accepted:    
 * Total Submissions: 
 * Testcase Example:  '"abc"'
 *
 * Can you solve this problem? 🤔
 */
public class Solution {
    public int countSubstrings(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        
        int n = s.length();
        int count = 0;
        boolean[][] dp = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            dp[i][i] = true;
            count++;
            if (i < n - 1) {
                if (s.charAt(i) == s.charAt(i + 1)) {
                    dp[i][i + 1] = true;
                    count++;
                }
            }
        }
        
        for (int len = 2; len < n; len++) {
            for (int start = 0; start + len < n; start++) {
                dp[start][start + len] = s.charAt(start) == s.charAt(start + len) && dp[start + 1][start + len - 1];
                if (dp[start][start + len]) {
                    count++;
                }
            }
        }
        
        return count;
    }
}
