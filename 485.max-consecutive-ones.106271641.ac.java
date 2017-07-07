/*
 * [485] Max Consecutive Ones
 *
 * https://leetcode.com/problems/max-consecutive-ones
 *
 * Easy (54.19%)
 * Total Accepted:    
 * Total Submissions: 
 * Testcase Example:  '[1,0,1,1,0,1]'
 *
 * Can you solve this problem? 🤔
 */
public class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int maxCount = 0;
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                maxCount = Math.max(maxCount, count);
                count = 0;
            } else {
                count++;
            }
        }
        maxCount = Math.max(maxCount, count);
        return maxCount;
    }
}
