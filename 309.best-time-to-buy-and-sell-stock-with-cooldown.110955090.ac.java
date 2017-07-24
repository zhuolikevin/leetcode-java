/*
 * [309] Best Time to Buy and Sell Stock with Cooldown
 *
 * https://leetcode.com/problems/best-time-to-buy-and-sell-stock-with-cooldown
 *
 * Medium (40.57%)
 * Total Accepted:    
 * Total Submissions: 
 * Testcase Example:  '[1,2,3,0,2]'
 *
 * Can you solve this problem? 🤔
 */
public class Solution {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length < 2) {
            return 0;
        }
        
        int[] buy = new int[prices.length];
        int[] sell = new int[prices.length];
        buy[0] = -prices[0];
        sell[0] = 0;
        for (int i = 1; i < prices.length; i++) {
            buy[i] = i >= 2 ? Math.max(sell[i - 2] - prices[i], buy[i - 1]) : Math.max(-prices[i], buy[i - 1]);
            sell[i] = Math.max(buy[i - 1] + prices[i], sell[i - 1]);
        }
        
        return Math.max(buy[prices.length - 1], sell[prices.length - 1]);
    }
}
