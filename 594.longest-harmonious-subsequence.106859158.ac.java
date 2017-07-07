/*
 * [594] Longest Harmonious Subsequence
 *
 * https://leetcode.com/problems/longest-harmonious-subsequence
 *
 * Easy (39.89%)
 * Total Accepted:    
 * Total Submissions: 
 * Testcase Example:  '[1,3,2,2,5,2,3,7]'
 *
 * Can you solve this problem? 🤔
 */
public class Solution {
    public int findLHS(int[] nums) {
        if (nums.length == 0) { return 0; }
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        int maxLength = 0;
        for (int num : map.keySet()) {
            int l1 = map.get(num);
            if (map.get(num - 1) != null) {
                maxLength = Math.max(maxLength, l1 + map.get(num - 1));
            }
            if (map.get(num + 1) != null) {
                maxLength = Math.max(maxLength, l1 + map.get(num + 1));
            }
        }
        return maxLength;
    }
}
