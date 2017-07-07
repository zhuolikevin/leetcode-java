/*
 * [53] Maximum Subarray
 *
 * https://leetcode.com/problems/maximum-subarray
 *
 * Easy (39.44%)
 * Total Accepted:    
 * Total Submissions: 
 * Testcase Example:  '[-2,1,-3,4,-1,2,1,-5,4]'
 *
 * Can you solve this problem? 🤔
 */
public class Solution {
    public int maxSubArray(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        
        int curMin = 0;
        int curSum = 0;
        int res = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            curSum += nums[i];
            res = Math.max(res, curSum - curMin);
            curMin = Math.min(curMin, curSum);
        }
        
        return res;
    }
}
