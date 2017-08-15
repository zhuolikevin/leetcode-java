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
        
        int[] preSum = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            preSum[i] = i == 0 ? nums[i] : preSum[i - 1] + nums[i];
        }
        
        int min = 0;
        int largest = Integer.MIN_VALUE;
        for (int i = 0; i < preSum.length; i++) {
            largest = Math.max(largest, preSum[i] - min);
            min = Math.min(min, preSum[i]);
        }
        
        return largest;
    }
}
