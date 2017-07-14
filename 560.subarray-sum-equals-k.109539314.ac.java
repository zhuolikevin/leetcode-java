/*
 * [560] Subarray Sum Equals K
 *
 * https://leetcode.com/problems/subarray-sum-equals-k
 *
 * Medium (40.91%)
 * Total Accepted:    
 * Total Submissions: 
 * Testcase Example:  '[1,1,1]\n2'
 *
 * Can you solve this problem? 🤔
 */
public class Solution {
    public int subarraySum(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        
        int count = 0;
        int[] preSum = new int[nums.length + 1];
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < preSum.length; i++) {
            preSum[i] = i == 0 ? 0 : preSum[i - 1] + nums[i - 1];
            if (i > 0 && map.get(preSum[i] - k) != null) {
                count += map.get(preSum[i] - k);
            }
            map.put(preSum[i], map.getOrDefault(preSum[i], 0) + 1);
        }
        
        return count;
    }
}
