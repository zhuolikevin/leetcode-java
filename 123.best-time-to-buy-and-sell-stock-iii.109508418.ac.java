/*
 * [123] Best Time to Buy and Sell Stock III
 *
 * https://leetcode.com/problems/best-time-to-buy-and-sell-stock-iii
 *
 * Hard (29.06%)
 * Total Accepted:    
 * Total Submissions: 
 * Testcase Example:  '[]'
 *
 * Can you solve this problem? 🤔
 */
public class Solution {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length <= 1) {
            return 0;
        }
        
        int[][] mustSell = new int[2][3];
        int[][] globalMax = new int[2][3];
        for (int i = 0; i < 2; i++) {
            mustSell[i][0] = 0;
            globalMax[i][0] = 0;
        }
        for (int j = 0; j <= 2; j++) {
            mustSell[0][j] = 0;
            globalMax[0][j] = 0;
        }
        
        for (int i = 1; i < prices.length; i++) {
            for (int j = 1; j <= 2; j++) {
                mustSell[i % 2][j] = Math.max(globalMax[(i - 1) % 2][j - 1], mustSell[(i - 1) % 2][j]) + prices[i] - prices[i - 1];
                globalMax[i % 2][j] = Math.max(globalMax[(i - 1) % 2][j], mustSell[i % 2][j]);
            }
        }
        
        return globalMax[(prices.length - 1) % 2][2];
    }
}
