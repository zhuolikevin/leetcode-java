/*
 * [121] Best Time to Buy and Sell Stock
 *
 * https://leetcode.com/problems/best-time-to-buy-and-sell-stock
 *
 * Easy (40.79%)
 * Total Accepted:    
 * Total Submissions: 
 * Testcase Example:  '[7,1,5,3,6,4]'
 *
 * Can you solve this problem? 🤔
 */
public class Solution {
    public int maxProfit(int[] prices) {
        if (prices.length < 2) { return 0; }
        int curMin = prices[0];
        int maxProfit = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > curMin) {
                maxProfit = Math.max(maxProfit, prices[i] - curMin);
            } else {
                curMin = prices[i];
            }
        }
        return maxProfit;
    }
}
