/*
 * [523] Continuous Subarray Sum
 *
 * https://leetcode.com/problems/continuous-subarray-sum
 *
 * Medium (22.35%)
 * Total Accepted:    
 * Total Submissions: 
 * Testcase Example:  '[23,2,4,6,7]\n6'
 *
 * Can you solve this problem? 🤔
 */
public class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return false;
        }
        
        int preSum = 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        for (int i = 0; i < nums.length; i++) {
            preSum += nums[i];
            if (k != 0) {
                preSum %= k;
            }
            
            if (map.containsKey(preSum)) {
                if (i - map.get(preSum) > 1) {
                   return true; 
                }
            } else {
                map.put(preSum, i);
            }
        }
        
        return false;
    }
}
