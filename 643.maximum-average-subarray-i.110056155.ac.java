/*
 * [643] Maximum Average Subarray I
 *
 * https://leetcode.com/problems/maximum-average-subarray-i
 *
 * Easy (39.66%)
 * Total Accepted:    
 * Total Submissions: 
 * Testcase Example:  '[1,12,-5,-6,50,3]\n4'
 *
 * Can you solve this problem? 🤔
 */
public class Solution {
    public double findMaxAverage(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return (double)0;
        }
        
        double max = Integer.MIN_VALUE;
        int[] preSum = new int[nums.length + 1];
        preSum[0] = 0;
        for (int i = 0; i < nums.length; i++) {
            preSum[i + 1] = preSum[i] + nums[i];
        }
        
        for (int i = k; i < preSum.length; i++) {
            max = Math.max(max, (double)(preSum[i] - preSum[i - k]) / (double)k);
        }
        
        return max;
    }
}
