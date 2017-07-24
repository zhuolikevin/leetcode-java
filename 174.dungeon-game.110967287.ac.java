/*
 * [174] Dungeon Game
 *
 * https://leetcode.com/problems/dungeon-game
 *
 * Hard (23.65%)
 * Total Accepted:    
 * Total Submissions: 
 * Testcase Example:  '[[0]]'
 *
 * Can you solve this problem? 🤔
 */
public class Solution {
    public int calculateMinimumHP(int[][] dungeon) {
        if (dungeon == null || dungeon.length == 0 || dungeon[0].length == 0) {
            return 0;
        }
        
        int m = dungeon.length;
        int n = dungeon[0].length;
        int[][] dp = new int[m][n];
        dp[m - 1][n - 1] = Math.min(0, dungeon[m - 1][n - 1]);
        for (int i = m - 2; i >= 0; i--) {
            dp[i][n - 1] = Math.min(0, dp[i + 1][n - 1] + dungeon[i][n - 1]);
        }
        for (int j = n - 2; j >= 0; j--) {
            dp[m - 1][j] = Math.min(0, dp[m - 1][j + 1] + dungeon[m - 1][j]);
        }
        for (int i = m - 2; i >= 0; i--) {
            for (int j = n - 2; j >= 0; j--) {
                dp[i][j] = Math.min(0, Math.max(dp[i + 1][j], dp[i][j + 1]) + dungeon[i][j]);
            }
        }
        return 1 - dp[0][0];
    }
}
