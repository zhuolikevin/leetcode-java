/*
 * [198] House Robber
 *
 * https://leetcode.com/problems/house-robber
 *
 * Easy (38.61%)
 * Total Accepted:    
 * Total Submissions: 
 * Testcase Example:  '[]'
 *
 * Can you solve this problem? 🤔
 */
public class Solution {
    public int rob(int[] nums) {
        if (nums.length <= 0) { return 0; }
        if (nums.length == 1) { return nums[0]; }
        int prevPrev = nums[0];
        int prev = Math.max(nums[0], nums[1]);
        for (int i = 2; i < nums.length; i++) {
            int now = Math.max(prev, prevPrev + nums[i]);
            prevPrev = prev;
            prev = now;
        }
        return prev;
    }
}
