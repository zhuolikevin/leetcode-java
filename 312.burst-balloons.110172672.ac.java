/*
 * [312] Burst Balloons
 *
 * https://leetcode.com/problems/burst-balloons
 *
 * Hard (42.40%)
 * Total Accepted:    
 * Total Submissions: 
 * Testcase Example:  '[3,1,5,8]'
 *
 * Can you solve this problem? 🤔
 */
public class Solution {
    public int maxCoins(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        
        int[] newNums = new int[nums.length + 2];
        newNums[0] = 1;
        newNums[newNums.length - 1] = 1;
        for (int i = 1; i < newNums.length - 1; i++) {
            newNums[i] = nums[i - 1];
        }
        
        int[][] cache = new int[newNums.length][newNums.length];
        return helper(newNums, 0, newNums.length - 1, cache);
    }
    
    private int helper(int[] newNums, int left, int right, int[][] cache) {
        if (left + 1 == right) {
            return 0;
        }
        if (cache[left][right] != 0) {
            return cache[left][right];
        }
        
        int maxCoins = 0;
        for (int i = left + 1; i < right; i++) {
            maxCoins = Math.max(
                maxCoins,
                newNums[left] * newNums[i] * newNums[right] + helper(newNums, left, i, cache) + helper(newNums, i, right, cache)
            );
        }
        cache[left][right] = maxCoins;
        return maxCoins;
    }
}
