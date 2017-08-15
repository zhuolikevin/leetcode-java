/*
 * [322] Coin Change
 *
 * https://leetcode.com/problems/coin-change
 *
 * Medium (26.48%)
 * Total Accepted:    
 * Total Submissions: 
 * Testcase Example:  '[1]\n0'
 *
 * Can you solve this problem? 🤔
 */
public class Solution {
    public int coinChange(int[] coins, int amount) {
        if ((coins == null || coins.length == 0) && amount != 0) {
            return -1;
        }
        
        int[] dp = new int[amount + 1];
        dp[0] = 0;
        for (int i = 1; i <= amount; i++) {
            boolean find = false;
            dp[i] = Integer.MAX_VALUE;
            for (int j = 0; j < coins.length; j++) {
                if (coins[j] <= i && dp[i - coins[j]] != -1) {
                    find = true;
                    dp[i] = Math.min(dp[i], dp[i - coins[j]] + 1);
                }
            }
            dp[i] = find ? dp[i] : -1;
        }
        
        return dp[amount];
    }
}
