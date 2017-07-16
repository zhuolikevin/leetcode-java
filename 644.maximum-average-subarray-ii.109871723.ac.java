/*
 * [644] Maximum Average Subarray II
 *
 * https://leetcode.com/problems/maximum-average-subarray-ii
 *
 * Hard (13.16%)
 * Total Accepted:    
 * Total Submissions: 
 * Testcase Example:  '[1,12,-5,-6,50,3]\n4'
 *
 * Can you solve this problem? 🤔
 */
public class Solution {
    public double findMaxAverage(int[] nums, int k) {
        double maxVal = Integer.MIN_VALUE;
        double minVal = Integer.MAX_VALUE;
        for (int num : nums) {
            maxVal = Math.max(maxVal, num);
            minVal = Math.min(minVal, num);
        }
        
        double prev = maxVal;
        double error = Integer.MAX_VALUE;
        while (error > 0.00001) {
            double midVal = (maxVal + minVal) * 0.5;
            if (check(nums, midVal, k)) {
                minVal = midVal;
            } else {
                maxVal = midVal;
            }
            error = Math.abs(midVal - prev);
            prev = midVal;
        }
        
        return minVal;
    }
    
    private boolean check(int[] nums, double midVal, int k) {
        double sum = 0;
        double preSum = 0;
        double preMin = 0;
        
        for (int i = 0; i < k; i++) {
            sum += nums[i] - midVal;
        }
        if (sum >= 0) {
            return true;
        }
        
        for (int i = k; i < nums.length; i++) {
            sum += nums[i] - midVal;
            preSum += nums[i - k] - midVal;
            preMin = Math.min(preMin, preSum);
            if (sum >= preMin) {
                return true;
            }
        }
        
        return false;
    }
}
