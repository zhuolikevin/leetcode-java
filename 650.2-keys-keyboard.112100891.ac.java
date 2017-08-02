/*
 * [650] 2 Keys Keyboard
 *
 * https://leetcode.com/problems/2-keys-keyboard
 *
 * Medium (37.91%)
 * Total Accepted:    
 * Total Submissions: 
 * Testcase Example:  '3'
 *
 * Can you solve this problem? 🤔
 */
public class Solution {
    public int minSteps(int n) {
        if (n == 1) {
            return 0;
        }
        
        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 0;
        dp[2] = 2;
        for (int i = 3; i <= n; i++) {
            dp[i] = Integer.MAX_VALUE;
            for (int j = i - 2; j >= 1; j--) {
                if (i % j == 0) {
                    int count = i / j;
                    dp[i] = Math.min(dp[i], dp[j] + 1 + count - 1);
                }
            }
        }
        
        return dp[n];
    }
}
