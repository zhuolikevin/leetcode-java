/*
 * [494] Target Sum
 *
 * https://leetcode.com/problems/target-sum
 *
 * Medium (43.85%)
 * Total Accepted:    
 * Total Submissions: 
 * Testcase Example:  '[1,1,1,1,1]\n3'
 *
 * Can you solve this problem? 🤔
 */
public class Solution {
    public int findTargetSumWays(int[] nums, int S) {
        if (nums.length == 0) { return 0; }
        return helper(nums, 0, S);
    }
    private int helper(int[] nums, int index, int target) {
        if (index == nums.length - 1) {
            int count = 0;
            if (target == nums[index]) { count++; }
            if (target == - nums[index]) { count++; }
            return count;
        }
        return helper(nums, index + 1, target + nums[index]) + helper(nums, index + 1, target - nums[index]);
    }
}
