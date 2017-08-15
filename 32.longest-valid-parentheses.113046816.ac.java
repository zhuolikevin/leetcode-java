/*
 * [32] Longest Valid Parentheses
 *
 * https://leetcode.com/problems/longest-valid-parentheses
 *
 * Hard (23.03%)
 * Total Accepted:    
 * Total Submissions: 
 * Testcase Example:  '""'
 *
 * Can you solve this problem? 🤔
 */
public class Solution {
    public int longestValidParentheses(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        
        int[] dp = new int[s.length() + 1];
        dp[0] = 0;
        int longest = 0;
        for (int i = 1; i <= s.length(); i++) {
            if (s.charAt(i - 1) == '(') {
                dp[i] = 0;
            } else {
                dp[i] = i - dp[i - 1] - 1 >= 1 && s.charAt(i - dp[i - 1] - 2) == '(' ? dp[i - 1] + 2 + dp[i - dp[i - 1] - 2]: 0;
            }
            longest = Math.max(longest, dp[i]);
        }
        return longest;
    }
}
