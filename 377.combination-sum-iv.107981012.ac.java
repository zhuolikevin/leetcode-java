/*
 * [377] Combination Sum IV
 *
 * https://leetcode.com/problems/combination-sum-iv
 *
 * Medium (41.71%)
 * Total Accepted:    
 * Total Submissions: 
 * Testcase Example:  '[1,2,3]\n4'
 *
 * Can you solve this problem? 🤔
 */
public class Solution {
    public int combinationSum4(int[] nums, int target) {
        Map<Integer, Integer> cache = new HashMap<>();
        Arrays.sort(nums);
        return helper(nums, target, cache);
    }
    
    private int helper(int[] nums, int target, Map<Integer, Integer> cache) {
        if (cache.containsKey(target)) { return cache.get(target); }
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > target) { break; }
            if (nums[i] == target) {
                res += 1;
                break;
            }
            res += helper(nums, target - nums[i], cache);
        }
        cache.put(target, res);
        return res;
    }
}
