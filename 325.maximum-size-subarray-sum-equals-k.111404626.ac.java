/*
 * [325] Maximum Size Subarray Sum Equals k
 *
 * https://leetcode.com/problems/maximum-size-subarray-sum-equals-k
 *
 * Medium (42.27%)
 * Total Accepted:    
 * Total Submissions: 
 * Testcase Example:  '[1,-1,5,-2,3]\n3'
 *
 * Can you solve this problem? 🤔
 */
public class Solution {
    public int maxSubArrayLen(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        
        int[] preSum = new int[nums.length + 1];
        preSum[0] = 0;
        for (int i = 1; i < preSum.length; i++) {
            preSum[i] = preSum[i - 1] + nums[i - 1];
        }
        
        int longest = 0;
        Map<Integer, Integer> dict = new HashMap<>();
        for (int i = 0; i < preSum.length; i++) {
            if (dict.containsKey(preSum[i] - k)) {
                longest = Math.max(longest, i - dict.get(preSum[i] - k));
            }
            if (!dict.containsKey(preSum[i])) {
                dict.put(preSum[i], i);
            }
        }
        
        return longest;
    }
}
