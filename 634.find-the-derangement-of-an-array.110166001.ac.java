/*
 * [634] Find the Derangement of An Array
 *
 * https://leetcode.com/problems/find-the-derangement-of-an-array
 *
 * Medium (29.34%)
 * Total Accepted:    
 * Total Submissions: 
 * Testcase Example:  '1'
 *
 * Can you solve this problem? 🤔
 */
public class Solution {
    public int findDerangement(int n) {
        if (n == 0) {
            return 1;
        }
        if (n == 1) {
            return 0;
        }
        long[] dp = new long[n + 1];
        dp[0] = 1;
        dp[1] = 0;
        for (int i = 2; i <= n; i++) {
            dp[i] = ((i - 1) * (dp[i - 2] + dp[i - 1])) % 1000000007;
        }
        return (int)dp[n];
    }
}
