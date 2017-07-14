/*
 * [188] Best Time to Buy and Sell Stock IV
 *
 * https://leetcode.com/problems/best-time-to-buy-and-sell-stock-iv
 *
 * Hard (24.22%)
 * Total Accepted:    
 * Total Submissions: 
 * Testcase Example:  '2\n[]'
 *
 * Can you solve this problem? 🤔
 */
public class Solution {
    public int maxProfit(int k, int[] prices) {
        if (k <= 0 || prices == null || prices.length <= 1) {
            return 0;
        }
        
        if (k > prices.length / 2) {
            int count = 0;
            for (int i = 1; i < prices.length; i++) {
                if (prices[i] > prices[i - 1]) {
                    count += prices[i] - prices[i - 1];
                }
            }
            return count;
        }
        
        int[][] mustSell = new int[2][k + 1];
        int[][] globalMax = new int[2][k + 1];
        for (int i = 0; i < 2; i++) {
            mustSell[i][0] = 0;
            globalMax[i][0] = 0;
        }
        for (int j = 0; j <= k; j++) {
            mustSell[0][j] = 0;
            globalMax[0][j] = 0;
        }
        
        for (int i = 1; i < prices.length; i++) {
            for (int j = 1; j <= k; j++) {
                mustSell[i % 2][j] = Math.max(globalMax[(i - 1) % 2][j - 1], mustSell[(i - 1) % 2][j]) + prices[i] - prices[i - 1];
                globalMax[i % 2][j] = Math.max(globalMax[(i - 1) % 2][j], mustSell[i % 2][j]);
            }
        }
        
        return globalMax[(prices.length - 1) % 2][k];
    }
}
