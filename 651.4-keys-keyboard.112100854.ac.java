/*
 * [651] 4 Keys Keyboard
 *
 * https://leetcode.com/problems/4-keys-keyboard
 *
 * Medium (41.82%)
 * Total Accepted:    
 * Total Submissions: 
 * Testcase Example:  '1'
 *
 * Can you solve this problem? 🤔
 */
public class Solution {
    public int maxA(int N) {
        if (N == 1) {
            return 1;
        }
        if (N == 2) {
            return 2;
        }
        int[] dp = new int[N];
        dp[0] = 1;
        dp[1] = 2;
        dp[2] = 3;
        for (int i = 3; i < N; i++) {
            dp[i] = dp[i - 1] + 1;
            for (int j = 3; i - j >= 0; j++) {
                dp[i] = Math.max(dp[i], dp[i - j] * (j - 1));
            }
        }
        
        return dp[N - 1];
    }
}
