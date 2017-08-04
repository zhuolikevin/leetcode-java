/*
 * [491] Increasing Subsequences
 *
 * https://leetcode.com/problems/increasing-subsequences
 *
 * Medium (38.95%)
 * Total Accepted:    
 * Total Submissions: 
 * Testcase Example:  '[4,6,7,7]'
 *
 * Can you solve this problem? 🤔
 */
public class Solution {
    public List<List<Integer>> findSubsequences(int[] nums) {
        Set<List<Integer>> res = new HashSet<>();
        if (nums == null || nums.length < 2) {
            return new ArrayList<>(res);
        }
        
        search(res, nums, 0, new ArrayList<>());
        return new ArrayList<>(res);
    }
    
    private void search(Set<List<Integer>> res, int[] nums, int start, List<Integer> cur) {
        if (cur.size() > 1) {
            res.add(new ArrayList<>(cur));
        }
        
        for (int i = start; i < nums.length; i++) {
            if (start == 0 || start > 0 && nums[i] >= cur.get(cur.size() - 1)) {
                cur.add(nums[i]);
                search(res, nums, i + 1, cur);
                cur.remove(cur.size() - 1);
            }
        }
    }
}
