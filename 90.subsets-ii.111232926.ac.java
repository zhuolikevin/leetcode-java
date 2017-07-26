/*
 * [90] Subsets II
 *
 * https://leetcode.com/problems/subsets-ii
 *
 * Medium (35.72%)
 * Total Accepted:    
 * Total Submissions: 
 * Testcase Example:  '[1,2,2]'
 *
 * Can you solve this problem? 🤔
 */
public class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        dfs(res, nums, 0, new ArrayList<>());
        return res;
    }
    
    private void dfs(List<List<Integer>> res, int[] nums, int start, List<Integer> subset) {
        res.add(new ArrayList<>(subset));
        for (int i = start; i < nums.length; i++) {
            if (i > start && nums[i] == nums[i - 1]) {
                continue;
            }
            subset.add(nums[i]);
            dfs(res, nums, i + 1, subset);
            subset.remove(subset.size() - 1);
        }
    }
}
