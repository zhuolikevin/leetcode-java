/*
 * [209] Minimum Size Subarray Sum
 *
 * https://leetcode.com/problems/minimum-size-subarray-sum
 *
 * Medium (30.30%)
 * Total Accepted:    
 * Total Submissions: 
 * Testcase Example:  '7\n[2,3,1,2,4,3]'
 *
 * Can you solve this problem? 🤔
 */
public class Solution {
    public int minSubArrayLen(int s, int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        
        int left = 0;
        int right = 0;
        int curSum = 0;
        Integer minLen = null;
        while (left < nums.length) {
            while (right < nums.length && curSum < s) {
                curSum += nums[right];
                right++;
            }
            
            if (curSum >= s) {
                minLen = minLen == null ? right - left : Math.min(minLen, right - left);
            }
            
            curSum -= nums[left];
            left++;
        }
        
        return minLen == null ? 0 : minLen;
    }
}
