/*
 * [583] Delete Operation for Two Strings
 *
 * https://leetcode.com/problems/delete-operation-for-two-strings
 *
 * Medium (43.98%)
 * Total Accepted:    
 * Total Submissions: 
 * Testcase Example:  '"sea"\n"eat"'
 *
 * Can you solve this problem? 🤔
 */
public class Solution {
    public int minDistance(String word1, String word2) {
        int[][] dp = new int[word1.length() + 1][word2.length() + 1];
        for (int i = 0; i <= word1.length(); i++) {
            for (int j = 0; j <= word2.length(); j++) {
                if (i == 0 || j == 0) { dp[i][j] = 0; }
                else {
                    dp[i][j] = word1.charAt(i-1) == word2.charAt(j-1)
                        ? dp[i-1][j-1] + 1
                        : Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }
        return word1.length() + word2.length() - 2 * dp[word1.length()][word2.length()];
    }
}
