/*
 * [219] Contains Duplicate II
 *
 * https://leetcode.com/problems/contains-duplicate-ii
 *
 * Easy (32.17%)
 * Total Accepted:    
 * Total Submissions: 
 * Testcase Example:  '[]\n0'
 *
 * Can you solve this problem? 🤔
 */
public class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        if (nums.length == 0) { return false; }
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (!map.containsKey(nums[i])) {
                map.put(nums[i], i);
            } else if (i - map.get(nums[i]) <= k) {
                return true;
            } else {
                map.put(nums[i], i);
            }
        }
        return false;
    }
}
