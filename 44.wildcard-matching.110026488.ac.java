/*
 * [44] Wildcard Matching
 *
 * https://leetcode.com/problems/wildcard-matching
 *
 * Hard (19.89%)
 * Total Accepted:    
 * Total Submissions: 
 * Testcase Example:  '"aa"\n"a"'
 *
 * Can you solve this problem? 🤔
 */
public class Solution {
    public boolean isMatch(String s, String p) {
        if (s == null || p == null) {
            return false;
        }
        
        boolean[][] dp = new boolean[p.length() + 1][s.length() + 1];
        dp[0][0] = true;
        for (int i = 1; i <= p.length(); i++) {
            if (p.charAt(i - 1) == '*') {
                dp[i][0] = true;
            } else {
                break;
            }
        }
        
        for (int i = 1; i <= p.length(); i++) {
            for (int j = 1; j <= s.length(); j++) {
                if (p.charAt(i - 1) != '*') {
                    dp[i][j] = dp[i - 1][j - 1] && (p.charAt(i - 1) == '?' || p.charAt(i - 1) == s.charAt(j - 1));
                } else {
                    dp[i][j] = dp[i][j - 1] || dp[i - 1][j];
                }
            }
        }
        
        return dp[p.length()][s.length()];
    }
}
