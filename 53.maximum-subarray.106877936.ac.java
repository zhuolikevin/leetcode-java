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
        if (nums.length == 0) { return 0; }
        int lastMaxSub = nums[0];
        int maxSub = lastMaxSub;
        for (int i = 1; i < nums.length; i++) {
            int thisMaxSub = nums[i] + (lastMaxSub > 0 ? lastMaxSub : 0);
            maxSub = Math.max(maxSub, thisMaxSub);
            lastMaxSub = thisMaxSub;
        }
        return maxSub;
    }
}
