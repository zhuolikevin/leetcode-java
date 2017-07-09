/*
 * [639] Decode Ways II
 *
 * https://leetcode.com/problems/decode-ways-ii
 *
 * Hard (19.37%)
 * Total Accepted:    
 * Total Submissions: 
 * Testcase Example:  '"*"'
 *
 * Can you solve this problem? 🤔
 */
public class Solution {
    public int numDecodings(String s) {
        if (s == null || s.length() == 0 || s.charAt(0) == '0') {
            return 0;
        }
        
        long[] dp = new long[s.length() + 1];
        dp[0] = (long)1;
        dp[1] = s.charAt(0) == '*' ? (long)9 : (long)1;
        
        for (int i = 2; i <= s.length(); i++) {
            if (s.charAt(i - 1) == '*') {
                if (s.charAt(i - 2) == '1') {
                    dp[i] = 9 * dp[i - 1] + 9 * dp[i - 2];
                } else if (s.charAt(i - 2) == '2') {
                    dp[i] = 9 * dp[i - 1] + 6 * dp[i - 2];
                } else if (s.charAt(i - 2) == '*') {
                    dp[i] = 9 * dp[i - 1] + 15 * dp[i - 2];
                } else {
                    dp[i] = 9 * dp[i - 1];
                }
            } else if (s.charAt(i - 1) == '0') {
                if (s.charAt(i - 2) > '2' || s.charAt(i - 2) == '0') {
                    return 0;
                } else if (s.charAt(i - 2) == '*') {
                    dp[i] = 2 * dp[i - 2];
                } else {
                    dp[i] = dp[i - 2];
                }
            } else if (s.charAt(i - 2) == '1' || s.charAt(i - 2) == '2' && s.charAt(i - 1) >= '0' && s.charAt(i - 1) <= '6') {
                dp[i] = dp[i - 1] + dp[i - 2];
            } else if (s.charAt(i - 2) == '*') {
                if (s.charAt(i - 1) >= '0' && s.charAt(i - 1) <= '6') {
                    dp[i] = dp[i - 1] + 2 * dp[i - 2];
                } else {
                    dp[i] = dp[i - 1] + dp[i - 2];
                }
            } else {
                dp[i] = dp[i - 1];
            }
            dp[i] = dp[i] % 1000000007;
        }
        
        return (int)dp[s.length()];
    }
}
