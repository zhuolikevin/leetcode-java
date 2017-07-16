/*
 * [96] Unique Binary Search Trees
 *
 * https://leetcode.com/problems/unique-binary-search-trees
 *
 * Medium (40.76%)
 * Total Accepted:    
 * Total Submissions: 
 * Testcase Example:  '1'
 *
 * Can you solve this problem? 🤔
 */
public class Solution {
    private int[] dp;
    public int numTrees(int n) {
        if (n <= 0) {
            return 1;
        }
        
        this.dp = new int[n + 1];
        dp[0] = 1;
        for (int i = 1; i <= n; i++) {
            dp[i] = -1;
        }
        return helper(n);
    }
    
    private int helper(int k) {
        if (dp[k] != -1) {
            return dp[k];
        }
        if (k == 1) {
            dp[1] = 1;
            return 1;
        }
        
        int count = 0;
        for (int i = 0; i < k; i++) {
            int left = helper(i);
            int right = helper(k - i - 1);
            count += left * right;
        }
        dp[k] = count;
        return count;
    }
}
