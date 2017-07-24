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
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, -1);
        dp[0] = 0;
        for (int i = 1; i <= amount; i++) {
            boolean find = false;
            int minCount = Integer.MAX_VALUE;
            for (int j = 0; j < coins.length; j++) {
                if (i >= coins[j] && dp[i - coins[j]] != -1) {
                    find = true;
                    minCount = Math.min(minCount, 1 + dp[i - coins[j]]);
                }
            }
            dp[i] = find ? minCount : -1;
        }
        return dp[amount];
    }
}
