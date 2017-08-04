/*
 * [474] Ones and Zeroes
 *
 * https://leetcode.com/problems/ones-and-zeroes
 *
 * Medium (38.87%)
 * Total Accepted:    
 * Total Submissions: 
 * Testcase Example:  '["10","0001","111001","1","0"]\n5\n3'
 *
 * Can you solve this problem? 🤔
 */
public class Solution {
    public int findMaxForm(String[] strs, int m, int n) {
        int[][] dp = new int[m + 1][n + 1];
        for (String str : strs) {
            int[] counts = count01s(str);
            for (int zeros = m; zeros >= counts[0]; zeros--) {
                for (int ones = n; ones >= counts[1]; ones--) {
                    dp[zeros][ones] = Math.max(1 + dp[zeros - counts[0]][ones - counts[1]], dp[zeros][ones]);
                }
            }
        }
        return dp[m][n];
    }
    
    private int[] count01s(String str) {
        int[] res = { 0, 0 };
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '0') {
                res[0]++;
            } else {
                res[1]++;
            }
        }
        return res;
    }
}
