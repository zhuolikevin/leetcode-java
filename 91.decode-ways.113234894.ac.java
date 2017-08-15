/*
 * [91] Decode Ways
 *
 * https://leetcode.com/problems/decode-ways
 *
 * Medium (19.45%)
 * Total Accepted:    
 * Total Submissions: 
 * Testcase Example:  '""'
 *
 * Can you solve this problem? 🤔
 */
public class Solution {
    public int numDecodings(String s) {
        if (s == null || s.length() == 0 || s.charAt(0) == '0') {
            return 0;
        }
        
        int[] dp = new int[s.length() + 1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i <= s.length(); i++) {
            if (s.charAt(i - 1) == '0') {
                if (s.charAt(i - 2) == '0' || s.charAt(i - 2) > '2') {
                    dp[i] = 0;
                } else {
                    dp[i] = dp[i - 2];
                }
            } else {
                if (s.charAt(i - 2) == '0' || s.charAt(i - 2) > '2' || s.charAt(i - 2) == '2' && s.charAt(i - 1) > '6') {
                    dp[i] = dp[i - 1];
                } else {
                    dp[i] = dp[i - 2] + dp[i - 1];
                }
            }
        }
        
        return dp[s.length()];
    }
}
